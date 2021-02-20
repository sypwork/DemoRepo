package com.candao.spas.dc.demotest.junit5demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 參數化測試
 * @ValueSource 指定一个原生类型（String，int，long或double）的数组，并且只能为每次调用提供一个参数
 * @EnumSource 使用Enum常量的简便方法。该注释提供了一个可选的name参数，可以指定使用哪些常量。如果省略，所有的常量将被用在下面的例子中
 * @MethodSource 允许你引用一个或多个测试类的工厂方法。这样的方法必须返回一个Stream，Iterable，Iterator或者参数数组。另外，这种方法不能接受任何参数。默认情况下，除非测试类用@TestInstance(Lifecycle.PER_CLASS)注解，否则这些方法必须是静态的。
 * @CsvSource @CsvSource允许您将参数列表表示为以逗号分隔的值（例如，字符串文字）。
 * @CsvSource 让你使用classpath中的CSV文件。CSV文件中的每一行都会导致参数化测试的一次调用。
 *
 * @author Nicholas
 * @title: ParamsDemo
 * @projectName demo-test
 * @description: TODO
 * @date 2021-02-02 18:20
 */
@Slf4j
@DisplayName("參數化測試")
public class ParamsDemo {
    @DisplayName("輸入參數測試")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testWithValueSource(int argument) {
        assertNotNull(argument);
    }
    
    @DisplayName("回文測試")
    @ParameterizedTest
    @ValueSource(strings = {"racecar", "radar", "able was I ere I saw elba"})
    void palindromes(String msg) {
        assertTrue(isPalindrome(msg));
    }
    
    private boolean isPalindrome(String str) {
        int lenth = str.length();
        for (int i = 0; i < lenth / 2; i++) {
            if (str.toCharArray()[i] != str.toCharArray()[lenth - i - 1]) {
                return false;
            }
        }
        return true;
    }
    
    @DisplayName("枚舉測試")
    @ParameterizedTest
    @EnumSource(TimeUnit.class)
    void testWithEnumSource(TimeUnit timeUnit) {
        assertNotNull(timeUnit);
    }
    
    @DisplayName("枚舉測試2")
    @ParameterizedTest
    @EnumSource(value = TimeUnit.class, names = { "DAYS", "HOURS" })
    void testWithEnumSourceInclude(TimeUnit timeUnit) {
        assertTrue(EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS).contains(timeUnit));
    }
    
    @DisplayName("枚舉測試3")
    @ParameterizedTest
    @EnumSource(value = TimeUnit.class, mode = EnumSource.Mode.EXCLUDE, names = { "DAYS", "HOURS" })
    void testWithEnumSourceExclude(TimeUnit timeUnit) {
        assertFalse(EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS).contains(timeUnit));
        assertTrue(timeUnit.name().length() > 5);
    }
    
    @DisplayName("枚舉測試4")
    @ParameterizedTest
    @EnumSource(value = TimeUnit.class, mode = EnumSource.Mode.MATCH_ALL, names = "^(M|N).+SECONDS$")
    void testWithEnumSourceRegex(TimeUnit timeUnit) {
        String name = timeUnit.name();
        assertTrue(name.startsWith("M") || name.startsWith("N"));
        assertTrue(name.endsWith("SECONDS"));
    }
    
    @DisplayName("method測試")
    @ParameterizedTest
    @MethodSource("stringProvider")
    void testWithSimpleMethodSource(String argument) {
        assertNotNull(argument);
    }
    
    static Stream<String> stringProvider() {
        return Stream.of("foo", "bar");
    }
    
    @DisplayName("method測試2")
    @ParameterizedTest
    @MethodSource("range")
    void testWithRangeMethodSource(int argument) {
        assertNotEquals(9, argument);
    }
    
    static IntStream range() {
        return IntStream.range(0, 20).skip(10);
    }
    
    @DisplayName("method測試3")
    @ParameterizedTest
    @MethodSource("stringIntAndListProvider")
    void testWithMultiArgMethodSource(String str, int num, List<String> list) {
        assertEquals(3, str.length());
        assertTrue(num >=1 && num <=2);
        assertEquals(2, list.size());
    }
    
    static Stream<Arguments> stringIntAndListProvider() {
        return Stream.of(
                Arguments.of("foo", 1, Arrays.asList("a", "b")),
                Arguments.of("bar", 2, Arrays.asList("x", "y"))
        );
    }
    
    @DisplayName("Csv測試1")
    @ParameterizedTest
    @CsvSource({ "foo, 1", "bar, 2", "'baz, qux', 3" })
    void testWithCsvSource(String first, int second) {
        assertNotNull(first);
        assertNotEquals(0, second);
    }
    
    @DisplayName("CsvFile測試1")
    @ParameterizedTest
    @CsvFileSource(resources = "/two-column.csv")
    void testWithCsvFileSource(String first, int second) {
        assertNotNull(first);
        assertNotEquals(0, second);
    }
    
    @DisplayName("通過參數化自定義顯示名稱")
    @ParameterizedTest(name = "{index} ==> first=''{0}'', second={1}")
    @CsvSource({ "foo, 1", "bar, 2", "'baz, qux', 3" })
    void testWithCustomDisplayNames(String first, int second) {
    }
}