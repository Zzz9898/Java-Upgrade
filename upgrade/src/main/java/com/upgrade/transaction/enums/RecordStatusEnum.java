package com.upgrade.transaction.enums;

/**
 * @Author zhangjiaw
 * @Date 2021/11/14 10:48
 */
public enum RecordStatusEnum {

    FAIL(0, "无效"),
    WAIT(1, "待操作"),
    SUCCESS(2, "操作成功");

    private int value;
    private String desc;

    RecordStatusEnum(int value, String desc) {
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
