package com.upgrade.transaction.enums;

/**
 * @Author zhangjiaw
 * @Date 2021/11/14 10:48
 */
public enum DataStatusEnum {

    INVALID(0, "无效"),
    OPERABLE(1, "可操作"),
    OPERATED(2, "已操作");

    private int value;
    private String desc;

    DataStatusEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
