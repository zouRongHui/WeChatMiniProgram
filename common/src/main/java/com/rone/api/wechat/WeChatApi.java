package com.rone.api.wechat;

import cn.hutool.crypto.digest.HMac;
import cn.hutool.crypto.digest.HmacAlgorithm;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rone.exception.ParamException;
import com.rone.exception.ThirdPlatformException;
import com.rone.exception.RoneException;
import com.rone.exception.WeChatAccessTokenExpireException;
import com.rone.model.WeChatLogonResult;
import com.rone.model.WeChatUserEncryptKeyResult;
import com.rone.utils.HttpRequestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 与微信服务器相关交互
 *
 * @author rone
 */
@Component
public class WeChatApi {

    public static final Logger LOGGER = LoggerFactory.getLogger(WeChatApi.class);

    public static final String APP_ID = "xxxxx";
    public static final String SECRET = "xxxxx";
    public static final String LOGON_URL = "https://api.weixin.qq.com/sns/jscode2session";
    /**
     * 获取ACCESS_TOKEN
     */
    public static final String GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token";
    /**
     * 获取小程序码，有数量限制，参数最大128字节
     */
    public static final String GET_MINI_APP_CODE = "https://api.weixin.qq.com/wxa/getwxacode";
    /**
     * 获取小程序码，无数量限制，参数最大64字符
     */
    public static final String GET_MINI_APP_CODE_UNLIMITED = "https://api.weixin.qq.com/wxa/getwxacodeunlimit";
    /**
     * 获取用户encryptKey。 会获取用户最近3次的key，每个 key 的存活时间为3600s
     */
    public static final String GET_USER_ENCRYPT_KEY = "https://api.weixin.qq.com/wxa/business/getuserencryptkey";

    /**
     * 获取小程序码，有数量限制，最大参数长度128字节
     *
     * @param accessToken
     * @param path
     * @return
     * @throws URISyntaxException
     * @throws IOException
     * @throws ThirdPlatformException
     */
    public byte[] getMiniAppCode(String accessToken, String path) throws URISyntaxException, IOException, ThirdPlatformException {
        Map<String, String> paramMap = new HashMap<>(1);
        paramMap.put("path", path);
        return miniAppCode(GET_MINI_APP_CODE + "?access_token=" + accessToken, paramMap);
    }

    /**
     * 获取小程序码，无数量限制，最大参数长度32字符
     *
     * @param accessToken
     * @param param
     * @param page        页面路径
     * @return
     * @throws URISyntaxException
     * @throws IOException
     * @throws ThirdPlatformException
     */
    public byte[] getMiniAppCodeUnlimited(String accessToken, String param, String page) throws URISyntaxException, IOException, ThirdPlatformException, ParamException {
        if (param != null && param.length() > 32) {
            throw new ParamException("二维码参数长度超过限制，最大支持32个字符，工号+产品ID最大29位字符");
        }
        Map<String, String> paramMap = new HashMap<>(1);
        paramMap.put("scene", param);
        if (StringUtils.isNotEmpty(page)) {
            paramMap.put("page", page);
        }
        return miniAppCode(GET_MINI_APP_CODE_UNLIMITED + "?access_token=" + accessToken, paramMap);
    }

    /**
     * 获取小程序码
     *
     * @param url
     * @param paramMap
     * @return
     * @throws URISyntaxException
     * @throws IOException
     * @throws ThirdPlatformException
     */
    private byte[] miniAppCode(String url, Map<String, String> paramMap) throws URISyntaxException, IOException, ThirdPlatformException {
        HttpPost httpPost = new HttpPost((new URIBuilder(url)).build());
        httpPost.setEntity(new StringEntity(JSON.toJSONString(paramMap), "utf-8"));
        HttpEntity responseEntity = execute(httpPost);
        byte[] resultBytes = EntityUtils.toByteArray(responseEntity);
        String result = new String(resultBytes, StandardCharsets.UTF_8);
        LOGGER.info("微信API，请求URL：{}", url);// 返回内容过长只输出请求url
        if (StringUtils.isEmpty(result)) {
            LOGGER.error("微信API，获取小程序码出错，返回数据为空");
            throw new ThirdPlatformException("微信API，获取小程序码出错，返回数据为空");
        } else if (result.indexOf("errcode") > 0) {
            LOGGER.error("微信API，获取小程序码出错，出错提示：{}", result);
            throw new ThirdPlatformException(String.format("微信API，获取小程序码出错，出错提示：%s", JSON.parseObject(result).getString("errmsg")));
        }
        return resultBytes;
    }

    /**
     * 获取ACCESS_TOKEN
     *
     * @return
     * @throws ThirdPlatformException
     * @throws IOException
     * @throws URISyntaxException
     */
    public String getAccessToken() throws ThirdPlatformException, IOException, URISyntaxException {
        Map<String, String> paramMap = new HashMap<>(3);
        paramMap.put("grant_type", "client_credential");
        paramMap.put("appid", APP_ID);
        paramMap.put("secret", SECRET);

        try {
            JSONObject resultJson = executeNormalParam(GET_ACCESS_TOKEN_URL, paramMap);
            return resultJson.getString("access_token");
        } catch (RoneException e) {
            LOGGER.error("微信API，获取ACCESS_TOKEN出错，错误信息：{}", e.getMessage());
            throw new ThirdPlatformException("微信API，微信小程序获取ACCESS_TOKEN，请稍后重试！");
        }
    }

    /**
     * 微信小程序登陆
     *
     * @param js_code 小程序前端获取
     * @return
     * @throws Exception
     */
    public WeChatLogonResult login(String js_code) throws Exception {
        Map<String, String> paramMap = new HashMap<>(4);
        paramMap.put("appid", APP_ID);
        paramMap.put("secret", SECRET);
        paramMap.put("js_code", js_code);
        paramMap.put("grant_type", "authorization_code");

        try {
            JSONObject resultJson = executeNormalParam(LOGON_URL, paramMap);
            WeChatLogonResult weChatLogonResult = new WeChatLogonResult();
            weChatLogonResult.setOpenId(resultJson.getString("openid"));
            weChatLogonResult.setSessionKey(resultJson.getString("session_key"));
            weChatLogonResult.setUnionId(resultJson.getString("unionid"));
            return weChatLogonResult;
        } catch (ThirdPlatformException e) {
            LOGGER.error("微信API，登录出错，错误信息：{}", e.getMessage());
            throw new ThirdPlatformException("微信小程序登陆异常，请重新登陆");
        }
    }

    /**
     * 获取用户encryptKey。 会获取用户最近3次的key，每个 key 的存活时间为3600s
     *
     * @param access_token 接口调用凭证，储存在系统参数中
     * @param openid       用户的openId
     * @param sessionKey   用户登录时的微信返回的会话密钥
     * @return
     * @throws RoneException
     */
    public WeChatUserEncryptKeyResult getUserEncryptKey(String access_token, String openid, String sessionKey) throws RoneException {
        Map<String, String> paramMap = new HashMap<>(4);
        paramMap.put("access_token", access_token);
        paramMap.put("openid", openid);
        paramMap.put("signature", (new HMac(HmacAlgorithm.HmacSHA256, sessionKey.getBytes())).digestHex("".getBytes()));
        paramMap.put("sig_method", "hmac_sha256");

        try {
            JSONObject resultJson = executeNormalParam(GET_USER_ENCRYPT_KEY, paramMap);
            return JSONObject.parseObject(resultJson.toJSONString(), WeChatUserEncryptKeyResult.class);
        } catch (RoneException e) {
            LOGGER.error("微信API，获取用户encryptKey出错，错误信息：{}", e.getMessage());
            throw e;
        } catch (Exception e) {
            LOGGER.error("微信API，获取用户encryptKey出错，错误信息：{}", e.getMessage());
            throw new ThirdPlatformException("微信API，获取用户encryptKey出错", e);
        }
    }

    /**
     * 执行参数为键值对的请求，目前请求方式为get
     *
     * @param url
     * @param paramMap
     * @return
     * @throws URISyntaxException
     * @throws IOException
     * @throws ThirdPlatformException
     */
    private JSONObject executeNormalParam(String url, Map<String, String> paramMap) throws URISyntaxException, IOException, ThirdPlatformException, WeChatAccessTokenExpireException {
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        if (paramMap != null) {
            for (Map.Entry<String, String> entry : paramMap.entrySet()) {
                nameValuePairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }

        URI uri = new URIBuilder(url).setParameters(nameValuePairs).build();
        HttpGet httpGet = new HttpGet(uri);
        HttpEntity responseEntity = execute(httpGet);
        JSONObject resultJson = JSON.parseObject(EntityUtils.toString(responseEntity, StandardCharsets.UTF_8));
        LOGGER.info("微信API，请求URL：{}，返回结果：{}", uri, resultJson.toString());
        Integer errcode = resultJson.getInteger("errcode");
        if (errcode == null || errcode == 0) {
            return resultJson;
        } else if (42001 == errcode) {
            throw new WeChatAccessTokenExpireException();
        } else {
            throw new ThirdPlatformException(resultJson.toString());
        }
    }

    /**
     * 执行请求
     *
     * @param httpRequest
     * @return
     * @throws IOException
     */
    private HttpEntity execute(HttpRequestBase httpRequest) throws IOException {
        httpRequest.setConfig(RequestConfig.custom().setSocketTimeout(120000).setConnectTimeout(120000).build());
        CloseableHttpClient httpClient = HttpRequestUtils.getHttpClient();
        CloseableHttpResponse httpResponse = httpClient.execute(httpRequest);
        HttpEntity responseEntity = httpResponse.getEntity();
        return responseEntity;
    }
}
