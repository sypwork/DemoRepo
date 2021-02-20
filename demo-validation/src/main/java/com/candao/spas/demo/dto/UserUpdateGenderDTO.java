package com.candao.spas.demo.dto;

import com.candao.spas.demo.enums.GenderEnum;
import com.candao.spas.demo.core.validator.InEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 用户更新性别 DTO
 */
@Data
@ApiModel("用户更新性别dto")
public class UserUpdateGenderDTO {

    /**
     * 用户编号
     */
    @NotNull(message = "用户编号不能为空")
    @ApiModelProperty("用户id：编号不为空")
    private Integer id;

    /**
     * 性别：必须是枚举里面的值才可以，否则会提示错误
     */
    @NotNull(message = "性别不能为空")
    @InEnum(value = GenderEnum.class, message = "性别参数输入有误") //自定义验证
    @ApiModelProperty("用户性别：枚举值 [0, 1]")
    private Integer gender;

    @Override
    public String toString() {
        return "UserUpdateGenderDTO{" +
                "id=" + id +
                ", gender=" + gender +
                '}';
    }

}
