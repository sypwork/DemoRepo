package com.candao.spas.dc.demotest.junit5demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * Junit5 標簽使用 Demo
 * @author Nicholas
 * @title: TaggingDemo
 * @projectName demo-test
 * @description: TODO
 * @date 2021-02-02 17:58
 *
 * @Notice 标签不能为null或空白。
 * 裁剪标签不能包含空格(whitespace)。
 * 裁剪标签不得包含ISO控制字符。
 * 裁剪标签不得包含以下任何保留字符 ->  ,, (, ), &, |, !
 */
@Slf4j
@DisplayName("給測試打標簽")
public class TaggingDemo {
    @Test
    @Tag("tag")
    void testingTaxCalculation() {
        log.info("this is tag");
    }
}