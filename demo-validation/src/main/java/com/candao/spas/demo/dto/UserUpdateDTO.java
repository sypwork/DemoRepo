package com.candao.spas.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 用户更新 DTO
 */
@Data
@ApiModel("用户更新dto")
public class UserUpdateDTO {

    /**
     * 用户编号
     */
    @NotNull(message = "{UserUpdateDTO.id.NotNull}")
    @Min(value = 1L, message = "{UserUpdateDTO.id.Min}")
    @ApiModelProperty("用户id：编号必须大于 0")
    private Integer id;

    @NotNull(message = "用户名不能为空")
    @Length(min = 4, max = 16, message = "用户名 4-16 位", groups = UserUpdateStatusDTO.Group01.class) //必须有该标致才会进行验证，否则不会验证
    @ApiModelProperty("用户名称：groups01")
    private String username;


    public Integer getId() {
        return id;
    }

    public UserUpdateDTO setId(Integer id) {
        this.id = id;
        return this;
    }

}
