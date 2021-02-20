package com.candao.spas.dc.demotest.junit5demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Junit5 假設使用 Demo
 * @author Nicholas
 * @title: AsumptionsDemo
 * @projectName demo-test
 * @description: TODO
 * @date 2021-02-02 17:34
 */
@Slf4j
@DisplayName("假設條件使用")
public class AsumptionsDemo {
    
    @Test
    void testOnlyOnCiServer() {
        assumeTrue("CI".equals(System.getenv("ENV")));
        // remainder of test
    }
    
    @Test
    void testOnlyOnDeveloperWorkstation() {
        assumeTrue("DEV".equals(System.getenv("ENV")),
                () -> "Aborting test: not on developer workstation");
        // remainder of test
    }
    
    @Test
    void testInAllEnvironments() {
        assumingThat("CI".equals(System.getenv("ENV")),
                () -> {
                    // perform these assertions only on the CI server
                    assertEquals(2, 2);
                });
        
        // perform these assertions in all environments
        assertEquals("a string", "a string");
    }
    
}