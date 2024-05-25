package com.rone.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 小程序码
 *
 * @author rone
 */
public class MiniAppCode implements Serializable {
    /**
     * 小程序码包含的参数
     */
    private String codeParams;

    /**
     * 图片地址
     */
    private String codeUrl;

    /**
     * 生成时间
     */
    private Date generateTime;

    private static final long serialVersionUID = 1L;

    public String getCodeParams() {
        return codeParams;
    }

    public void setCodeParams(String codeParams) {
        this.codeParams = codeParams == null ? null : codeParams.trim();
    }

    public String getCodeUrl() {
        return codeUrl;
    }

    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl == null ? null : codeUrl.trim();
    }

    public Date getGenerateTime() {
        return generateTime;
    }

    public void setGenerateTime(Date generateTime) {
        this.generateTime = generateTime;
    }
}