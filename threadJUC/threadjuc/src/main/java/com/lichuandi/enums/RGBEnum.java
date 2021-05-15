package com.lichuandi.enums;

/**
 * 覆盖枚举的方法
 */
public enum RGBEnum {
    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);
    // 成员变量
    private String name;
    private int index;
    // 构造方法 ,赋值给成员变量
    private RGBEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    //覆盖方法  :只能使用toString方法来输出枚举变量值
    @Override
    public String toString() {
        return this.index+"_"+this.name;
    }
}
