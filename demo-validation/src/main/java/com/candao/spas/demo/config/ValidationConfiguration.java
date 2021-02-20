package com.candao.spas.demo.config;

import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MessageSourceResourceBundleLocator;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 *  Validation配置
 * @author Darren bo
 * @version 1.0
 * @date  2021-01-25
 */
@Configuration
public class ValidationConfiguration {

    /**
     * 参考 {@link ValidationAutoConfiguration#defaultValidator()} 方法，构建 Validator Bean
     *
     * @return Validator 对象
     */
   /* @Bean
    public Validator validator(MessageSource messageSource)  {
        // 创建 LocalValidatorFactoryBean 对象
        LocalValidatorFactoryBean validator = ValidationAutoConfiguration.defaultValidator();
        // 设置 messageSource 属性，实现 i18 国际化
        validator.setValidationMessageSource(messageSource);
        // 返回
        return validator;
    }*/


    /**
     * 快速失败（不需要则注释下面的方法）
     * @return
     */
    @Bean
    public Validator validator(MessageSource messageSource) {//
        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure()
                //添加国际化
                .messageInterpolator(new ResourceBundleMessageInterpolator(new MessageSourceResourceBundleLocator(messageSource)))
                //快速失败：failFast的意思只要出现校验失败的情况，就立即结束校验，不再进行后续的校验。
                .failFast(true)
                .buildValidatorFactory();
        return validatorFactory.getValidator();
    }

}
