package com.rone.utils.security;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;

/**
 * 3DES加解密
 *
 * @author rone
 */
public class TripleDESUtil {

    private static final Logger log = LoggerFactory.getLogger(TripleDESUtil.class);
    private static final String Algorithm = "DESede";
    private static final String PASSWORD_CRYPT_KEY = "lzoou0vDPHDvdHoBev2Ua0UkCH4Af1Lfc3EJrM9kz01qoYfPACMZu95dIgrgAJaG166YnbOygfwcn5oHN6qjOTtqSaV5VZ0J7rpMBQOLNf7n5CYTlZxhtD7Oob2f0hpq";
    private static final String DEFAULT_ENCODING = "UTF-8";

    /**
     * 加密方法
     *
     * @param src 源数据的字节数组
     * @return
     */
    public static String encryptMode(String src) {
        try {
            byte[] srcArr = src.getBytes(DEFAULT_ENCODING);
            // 生成密钥
            SecretKey desKey = new SecretKeySpec(build3DesKey(PASSWORD_CRYPT_KEY), Algorithm);
            // 实例化负责加密/解密的Cipher工具类
            Cipher c1 = Cipher.getInstance(Algorithm);
            // 初始化为加密模式
            c1.init(Cipher.ENCRYPT_MODE, desKey);
            return Base64.encodeBase64String(c1.doFinal(srcArr));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }


    /**
     * 根据字符串生成密钥字节数组
     *
     * @param keyStr 密钥字符串
     * @return
     * @throws UnsupportedEncodingException
     */
    private static byte[] build3DesKey(String keyStr) throws UnsupportedEncodingException {
        // 声明一个24位的字节数组，默认里面都是0
        byte[] key = new byte[24];
        // 将字符串转成字节数组
        byte[] temp = keyStr.getBytes(DEFAULT_ENCODING);

        System.arraycopy(temp, 0, key, 0, Math.min(key.length, temp.length));
        return key;
    }
}
