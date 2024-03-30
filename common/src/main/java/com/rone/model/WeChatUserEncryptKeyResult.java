package com.rone.model;

import java.util.List;

/**
 * 获取用户encryptKey。 会获取用户最近3次的key，每个 key 的存活时间为3600s
 *
 * @author rone
 */
public class WeChatUserEncryptKeyResult {

    private String errcode;
    private String errmsg;
    private List<KeyInfo> key_info_list;

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public List<KeyInfo> getKey_info_list() {
        return key_info_list;
    }

    public void setKey_info_list(List<KeyInfo> key_info_list) {
        this.key_info_list = key_info_list;
    }

    public static class KeyInfo {
        /**
         * 加密key
         */
        private String encrypt_key;
        /**
         * 创建key的时间戳
         */
        private String create_time;
        /**
         * 剩余有效时间
         */
        private String expire_in;
        /**
         * key的版本号
         */
        private Integer version;
        /**
         * 加密iv
         */
        private String iv;

        public String getEncrypt_key() {
            return encrypt_key;
        }

        public void setEncrypt_key(String encrypt_key) {
            this.encrypt_key = encrypt_key;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getExpire_in() {
            return expire_in;
        }

        public void setExpire_in(String expire_in) {
            this.expire_in = expire_in;
        }

        public Integer getVersion() {
            return version;
        }

        public void setVersion(Integer version) {
            this.version = version;
        }

        public String getIv() {
            return iv;
        }

        public void setIv(String iv) {
            this.iv = iv;
        }
    }
}
