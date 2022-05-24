package com.upgrade.currentlimit;

/**
 * @Author zhangjiaw
 * @Date 2022/5/24 21:09
 */
public enum LimitType {
    DEFAULT(0, "时间(默认)"),
    IP(1, "IP");
    private Integer id;
    private String label;

    LimitType(Integer id, String label) {
        this.id = id;
        this.label = label;
    }
}
