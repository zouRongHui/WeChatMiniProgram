package com.rone.model;

import java.util.HashSet;
import java.util.Set;

/**
 * 黑名单缓存
 *
 * @author rone
 */
public class BlockUserCacheData {

    /**
     * 手机号黑名单
     */
    private Set<String> phoneSet = new HashSet<>();
    /**
     * openId黑名单
     */
    private Set<String> openIdSet = new HashSet<>();

    public Set<String> getPhoneSet() {
        return phoneSet;
    }

    public void setPhoneSet(Set<String> phoneSet) {
        this.phoneSet = phoneSet;
    }

    public Set<String> getOpenIdSet() {
        return openIdSet;
    }

    public void setOpenIdSet(Set<String> openIdSet) {
        this.openIdSet = openIdSet;
    }
}
