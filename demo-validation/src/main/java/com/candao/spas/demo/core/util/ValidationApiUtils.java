package com.candao.spas.demo.core.util;

import com.candao.spas.demo.config.ApplicationContextProvider;
import com.candao.spas.demo.enums.ServiceExceptionEnum;
import com.candao.spas.demo.core.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *  Validation校验util(手动触发验证)
 * @author Darren bo
 * @version 1.0
 * @date  2021-01-25
 */
@Slf4j
public class ValidationApiUtils {
//    private static ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

    public static List<String> check(Object entity) {
        //        Validator validator = validatorFactory.getValidator();
        //获取系统配置的Validator
        Validator  validator=(Validator) ApplicationContextProvider.getBean("validator");
        if(validator==null){
            throw new ServiceException(ServiceExceptionEnum.SYS_ERROR.getCode(),
                    "validator验证器未初始化成功");
        }
        Set<ConstraintViolation<Object>> constraintViolationSet = validator.validate(entity);
        ArrayList<String> list = new ArrayList<>();
        for (ConstraintViolation<Object> constraintViolation : constraintViolationSet) {
            String message = constraintViolation.getMessage();
            list.add(message);
            log.info(message);
        }
        return list;
    }
}
