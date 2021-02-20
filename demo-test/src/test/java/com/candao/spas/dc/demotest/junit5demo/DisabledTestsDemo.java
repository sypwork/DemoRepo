package com.candao.spas.dc.demotest.junit5demo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
/**
 * Junit5 禁用用例 Demo
 * @author Nicholas
 * @title: DisabledTestsDemo
 * @projectName demo-test
 * @description: TODO
 * @date 2021-02-02 17:52
 */
@Slf4j
@DisplayName("禁用測試")
public class DisabledTestsDemo {
    @Disabled
    @Test
    void testWillBeSkipped() {
        log.info("不會執行");
    }
    
    @Test
    void testWillBeExecuted() {
        log.info("會執行");
    }
}