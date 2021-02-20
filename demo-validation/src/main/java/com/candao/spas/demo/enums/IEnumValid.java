package com.candao.spas.demo.enums;


/**
 *  定义enum的统一校验接口，用于统一获取枚举属性值
 * @author Darren bo
 * @version 1.0
 * @date  2021-01-26
 */
public interface IEnumValid {

    /**
     * 枚举值
     * @return
     */
    Integer getValue();

    /**
     *  枚举描述
     * @return
     */
    String getName();

}
