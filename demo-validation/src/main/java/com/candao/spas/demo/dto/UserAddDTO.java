package com.candao.spas.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 用户添加 DTO
 */
@Data
@ApiModel("用户新增dto")
public class UserAddDTO {

    /**
     * 账号
     */
    @NotEmpty(message = "用户名称不能为空")
    @Length(min = 5, max = 16, message = "用户名称长度为 5-16 位")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "用户名称为数字以及字母")
    @ApiModelProperty("用户名称check")
    private String username;
    /**
     * 密码
     */
    @NotEmpty(message = "密码不能为空")
    @NotNull(message = "不能为空")
    @Length(min = 4, max = 16, message = "密码长度为 4-16 位")
    @ApiModelProperty("用户密码check")
    private String password;


    @Override
    public String toString() {
        return "UserAddDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
