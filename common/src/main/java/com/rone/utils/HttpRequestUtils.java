package com.rone.utils;

import org.apache.commons.codec.Charsets;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

/**
 * http请求工具类
 *
 * @author rone
 */
public class HttpRequestUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpRequestUtils.class);

    private HttpRequestUtils() {
        throw new IllegalStateException("Utility class");
    }

    private static CloseableHttpClient httpClient = null;

    /**
     * http连接池最大连接数
     */
    private static final int MAX_TOTAL = 200;
    /**
     * http连接池每条链路的最大连接数
     */
    private static final int MAX_PER_ROUTE = 100;
    /**
     * socket超时配置，单位毫秒
     */
    private static final int SOCKET_TIMEOUT = 30 * 1000;
    /**
     * 编码格式
     */
    private static final String UTF8 = "UTF-8";

    static {
        init();
    }

    /**
     * 获取HttpClient
     *
     * @return
     */
    public static CloseableHttpClient getHttpClient() {
        if (httpClient == null) {
            synchronized (HttpRequestUtils.class) {
                if (httpClient == null) {
                    init();
                }
            }
        }
        return httpClient;
    }

    /**
     * 初始化，配置连接池等属性
     */
    private static void init() {
        // 配置链接池
        PoolingHttpClientConnectionManager pool = new PoolingHttpClientConnectionManager();
        // 最大连接数
        pool.setMaxTotal(MAX_TOTAL);
        // 每条链路的最大连接数
        pool.setDefaultMaxPerRoute(MAX_PER_ROUTE);
        // 设置编码格式
        pool.setDefaultConnectionConfig(ConnectionConfig.custom().setCharset(Charsets.toCharset(StandardCharsets.UTF_8)).build());
        SocketConfig socketConfig = SocketConfig.custom().setSoTimeout(SOCKET_TIMEOUT).build();
        pool.setDefaultSocketConfig(socketConfig);
        httpClient = HttpClients.custom().setConnectionManager(pool).build();
    }
}
