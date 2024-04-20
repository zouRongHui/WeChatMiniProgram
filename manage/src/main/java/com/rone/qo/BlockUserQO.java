package com.rone.qo;

/**
 * 黑名单
 *
 * @author rone
 */
public class BlockUserQO {

    /**
     * 页码
     */
    private Integer page;
    /**
     * 每页展示数量
     */
    private Integer size;

    /**
     * 加入黑名单时间-开始
     */
    private String createTimeStart;

    /**
     * 加入黑名单时间-截止
     */
    private String createTimeEnd;

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

    public String getCreateTimeStart() {
        return createTimeStart;
    }

    public void setCreateTimeStart(String createTimeStart) {
        this.createTimeStart = createTimeStart;
    }

    public String getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(String createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }
}
