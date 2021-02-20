package com.candao.spas.dc.demotest.junit5demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Junit 5 单元测试 Demo
 * @author Nicholas
 * @title: TestServiceTest
 * @projectName demo-test
 * @description:  Junit 5 Test
 * @date 2021-02-02 16:44
 *
 * 注解简介
 * @Test 表示方法是测试方法。与JUnit4的@Test注解不同的是，这个注解没有声明任何属性，因为JUnit Jupiter中的测试扩展是基于他们自己的专用注解来操作的。除非被覆盖，否则这些方法可以继承。
 * @ParameterizedTest 表示方法是参数化测试。 除非被覆盖，否则这些方法可以继承。
 * @RepeatedTest 表示方法是用于重复测试的测试模板。除非被覆盖，否则这些方法可以继承。
 * @TestFactory 表示方法是用于动态测试的测试工厂。除非被覆盖，否则这些方法可以继承。
 * @TestInstance 用于为被注解的测试类配置测试实例生命周期。 这个注解可以继承。
 * @TestTemplate 表示方法是测试用例的模板，设计为被调用多次，调用次数取决于自注册的提供者返回的调用上下文。除非被覆盖，否则这些方法可以继承。
 * @DisplayName  声明测试类或测试方法的自定义显示名称。这个注解不被继承。
 * @BeforeEach 表示被注解的方法应在当前类的每个@Test，@RepeatedTest，@ParameterizedTest或@TestFactory方法之前执行; 类似于JUnit 4的@Before。 除非被覆盖，否则这些方法可以继承。
 * @AfterEach 表示被注解的方法应在当前类的每个@Test，@RepeatedTest，@ParameterizedTest或@TestFactory方法之后执行; 类似于JUnit 4的@After。 除非被覆盖，否则这些方法可以继承。
 * @BeforeAll 表示被注解的方法应该在当前类的所有@Test，@RepeatedTest，@ParameterizedTest和@TestFactory方法之前执行; 类似于JUnit 4的@BeforeClass。 这样的方法可以继承（除非被隐藏或覆盖），并且必须是静态的（除非使用“per-class”测试实例生命周期）。
 * @AfterAll 表示被注解的方法应该在当前类的所有@Test，@RepeatedTest，@ParameterizedTest和@TestFactory方法之后执行; 类似于JUnit 4的@AfterClass。 这样的方法可以继承（除非被隐藏或覆盖），并且必须是静态的（除非使用“per-class”测试实例生命周期）。
 * @Nested 表示被注解的类是一个嵌套的非静态测试类。除非使用“per-class”测试实例生命周期，否则@BeforeAll和@AfterAll方法不能直接在@Nested测试类中使用。 这个注解不能继承。
 * @Tag  在类或方法级别声明标签，用于过滤测试; 类似于TestNG中的test group或JUnit 4中的Categories。这个注释可以在类级别上继承，但不能在方法级别上继承。
 * @Disabled 用于禁用测试类或测试方法; 类似于JUnit4的@Ignore。这个注解不能继承。
 * @ExtendWith 用于注册自定义扩展。 这个注解可以继承。
 *
 */
@Slf4j
@DisplayName("Junit5基礎使用")
public class Base {
    /*
     * 等于 Junit4 的注解 ： @Before
     * @author Nicholas
     * @date 2021-02-02 17:16
     * @param
     * @return
     */
    @BeforeAll
    static void beforeAll() {
        log.info("beforeAll");
    }
    
    @BeforeEach
    void beforeEach() {
        log.info("beforeEach");
    }
    
    @Test
    void succeedingTest() {
        log.info("succeedingTest");
    }
    
    @Test
    @Disabled("for demonstration purposes")
    void skippedTest() {
        log.info("skippedTest");
    }
    
    @AfterEach
    void afterEach() {
        log.info("afterEach");
    }
    
    @AfterAll
    static void afterAll() {
        log.info("afterAll");
    }
    
    // 以下是顯示名稱的用法
    @Test
    @DisplayName("Custom test name containing spaces")
    void testWithDisplayNameContainingSpaces() {
    }
    
    @Test
    @DisplayName("╯°□°）╯")
    void testWithDisplayNameContainingSpecialCharacters() {
    }
    
    @Test
    @DisplayName("😱")
    void testWithDisplayNameContainingEmoji() {
    }
}