package com.candao.spas.dc.demotest.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
// 注意 static
import static org.junit.jupiter.api.Assertions.*;


/**
 * Junit 5 单元测试 Demo
 * @author Nicholas
 * @title: TestServiceTest
 * @projectName demo-test
 * @description:  Junit 5 Test
 * @date 2021-02-02 16:44
 *
 */
@SpringBootTest
public class TestServiceTest {
    
    @Autowired
    TestService testService;
    
    /*
     * 测试是否满足条件
     * @author Nicholas
     * @date 2021-02-02 17:13
     * @param
     * @return
     */
    @DisplayName("assertEquals Junit5")
    @Test
    void assertEquals() {
        /**
         * run 效果
         * org.opentest4j.AssertionFailedError:
         * 预期:Junit6
         * 实际:Junit5
         */
        Assertions.assertEquals("Junit4",testService.get());
    }
    
    @DisplayName("assertSame Junit5")
    @Test
    void assertSame() {
        /**
         * run 效果
         * org.opentest4j.AssertionFailedError:
         * 预期:Junit6
         * 实际:Junit5
         */
        Assertions.assertSame("Junit5",testService.get());
    }
    
    @DisplayName("assertSame Junit5")
    @Test
    void assertFalse() {
        /**
         * run 效果
         * org.opentest4j.AssertionFailedError:
         * 预期:Junit6
         * 实际:Junit5
         */
        Assertions.assertFalse((1==1));
    }
}