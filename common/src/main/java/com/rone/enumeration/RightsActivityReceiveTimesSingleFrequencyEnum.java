package com.rone.enumeration;

import org.apache.commons.lang3.StringUtils;

/**
 * 权益活动，单人可领取次数的频率枚举
 *
 * @author rone
 */
public enum RightsActivityReceiveTimesSingleFrequencyEnum {
    WHOLE("0", "整个活动"),
    DAY("1", "每日"),
    WEEK("2", "每周"),
    MONTH("3", "每月"),
    YEAR("4", "每年");

    private final String code;

    private final String name;

    RightsActivityReceiveTimesSingleFrequencyEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static RightsActivityReceiveTimesSingleFrequencyEnum getByCode(String code) {
        if (StringUtils.isEmpty(code)) {
            return null;
        }
        for (RightsActivityReceiveTimesSingleFrequencyEnum value : RightsActivityReceiveTimesSingleFrequencyEnum.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }
}