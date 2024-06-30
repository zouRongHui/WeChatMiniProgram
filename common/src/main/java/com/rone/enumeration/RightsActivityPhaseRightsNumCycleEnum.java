package com.rone.enumeration;

import org.apache.commons.lang3.StringUtils;

/**
 * 阶段频率
 *
 * @author rone
 */
public enum RightsActivityPhaseRightsNumCycleEnum {
    DAY("1", "日"),
    WEEK("2", "周"),
    MONTH("3", "月"),
    YEAR("4", "年");

    private final String code;

    private final String name;

    RightsActivityPhaseRightsNumCycleEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static RightsActivityPhaseRightsNumCycleEnum getByCode(String code) {
        if (StringUtils.isEmpty(code)) {
            return null;
        }
        for (RightsActivityPhaseRightsNumCycleEnum value : RightsActivityPhaseRightsNumCycleEnum.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }
}
