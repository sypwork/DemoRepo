package com.candao.spas.dc.demotest.junit5demo;

import org.junit.jupiter.api.*;

/**
 * 接口測試與默認方法 Demo
 * @author Nicholas
 * @title: TestLifecycleDemo
 * @projectName demo-test
 * @description: TODO
 * @date 2021-02-02 18:07
 */

@DisplayName("聲明測試實例的生命周期" +
        "Lifecycle --> PER_CLASS每个测试类将创建一个新的测试实例")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
interface TestLifecycleDemo {
   
    @BeforeAll
    default void beforeAllTests() {
    }
    
    @AfterAll
    default void afterAllTests() {
    }
    
    @BeforeEach
    default void beforeEachTest(TestInfo testInfo) {
    }
    
    @AfterEach
    default void afterEachTest(TestInfo testInfo) {
    }
    
}