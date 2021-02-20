package com.candao.spas.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 用户更新状态 DTO
 */
@Data
@ApiModel("用户更新状态dto")
public class UserUpdateStatusDTO {

    /**
     * 定义分组 ，分组1(管理员可以操作0,1,2状态)
     */
    public interface Group01 {}

    /**
     * 定义分组，分组2(普通用户操作1,2状态)
     */
    public interface Group02 {}

    /**
     * 状态[删除，上/下线]
     */
    @Range(min = 1, max = 2, message = "状态必须为[1,2]", groups = Group02.class)
    @Range(min = 0, max = 2, message = "状态必须为[0,2]", groups = Group01.class)
    @ApiModelProperty("用户状态：Group01/Group02")
    private Integer status;


}
