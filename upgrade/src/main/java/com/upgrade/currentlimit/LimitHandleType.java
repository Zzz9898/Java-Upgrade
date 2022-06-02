package com.upgrade.currentlimit;

/**
 * @Author zhangjiaw
 * @Date 2022/5/27 23:13
 */
public enum LimitHandleType {
    SIMPLE(0, "默认方式"),
    SLIDING_WINDOW(1, "滑动窗口算法");

    private Integer id;
    private String label;

    LimitHandleType(Integer id, String label) {
        this.id = id;
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
