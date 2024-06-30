package com.rone.qo;

/**
 * 权益活动
 *
 * @author rone
 */
public class RightsActivityQO {

    /**
     * 页码
     */
    private Integer page;
    /**
     * 每页展示数量
     */
    private Integer size;
    /**
     * 主标题
     */
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
