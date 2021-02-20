package com.candao.spas.demo.enums;

/**
 *  性别枚举类
 * @author Darren bo
 * @version 1.0
 * @date  2021-01-25
 */
public enum GenderEnum implements IEnumValid {

    MAN(0, "男"),
    WOMAN(1, "女");

    /**
     * 性别值
     */
    private final Integer value;
    /**
     * 性别名
     */
    private final String name;

    GenderEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String getName() {
        return name;
    }




}
