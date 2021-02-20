package com.candao.spas.demo.core.validator;

import com.candao.spas.demo.enums.IEnumValid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *  自定义InEnum枚举校验规则，
 *  可以统一验证枚举值的范围是否满足
 * @author Darren bo
 * @version 1.0
 * @date  2021-01-26
 */
public class InEnumValidator implements ConstraintValidator<InEnum, Integer> {

    /**
     * 值数组
     */
    private Set<Integer> values;

    @Override
    public void initialize(InEnum annotation) {
        IEnumValid[] values = annotation.value().getEnumConstants();
        if (values.length == 0) {
            this.values = Collections.emptySet();
        } else {
            this.values =  Arrays.stream(values).map(IEnumValid::getValue).collect(Collectors.toSet());
        }
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        // 校验通过
        if (values.contains(value)) {
            return true;
        }
        // 校验不通过，自定义提示语句（因为，注解上的 value 是枚举类，无法获得枚举类的实际值）
        context.disableDefaultConstraintViolation(); // 禁用默认的 message 的值
        context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate()
//                .replaceAll("\\{value}", values.toString())//可以采用参数替换的展示所有的合规值
        ).addConstraintViolation(); // 重新添加错误提示语句
        return false;
    }

}
