package com.candao.spas.demo.controller;

import com.candao.spas.demo.core.result.RespData;
import com.candao.spas.demo.dto.UserAddDTO;
import com.candao.spas.demo.dto.UserUpdateDTO;
import com.candao.spas.demo.dto.UserUpdateGenderDTO;
import com.candao.spas.demo.dto.UserUpdateStatusDTO;
import com.candao.spas.demo.enums.ServiceExceptionEnum;
import com.candao.spas.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.groups.Default;


/**
 *  测试控制器
 * @author Darren bo
 * @version 1.0
 * @date  2021-01-25
 */
@RestController
@RequestMapping("/users")
@Validated
@Api(tags = "用户管理-参数验证")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @GetMapping("/get")
    @ApiOperation("基本验证-@RequestParam方法参数验证")
    public RespData get(@ApiParam("编号:编号必须大于 0") @RequestParam("id") @Min(value = 1L, message = "编号必须大于 0") Integer id) {
        logger.info("[get][id: {}]", id);
        return RespData.success();
    }

    @PostMapping("/add")
    @ApiOperation("基本验证举例-@Valid对象属性参数-json")
    public RespData add(@RequestBody @Valid UserAddDTO addDTO) {
        logger.info("[add][addDTO: {}]", addDTO);
        return RespData.success();
    }


    @PostMapping("/add-service")
    @ApiOperation("基本验证举例-业务层-@Valid对象属性参数")
    public RespData addService(UserAddDTO addDTO) {
        userService.add(addDTO);
        return RespData.success();
    }

    @PostMapping("/add-service-m")
    @ApiOperation("基本验证举例-业务方法-@Valid对象属性参数")
    public RespData addServiceM(UserAddDTO addDTO) {
        userService.add01(addDTO);
        return RespData.success();
    }

    @PostMapping("/update_gender")
    @ApiOperation("自定义验证-@InEnum")
    public RespData updateGender(@Valid UserUpdateGenderDTO updateGenderDTO) {
        logger.info("[updateGender][UserUpdateGenderDTO: {}]", updateGenderDTO);
        return RespData.success();
    }

    @PostMapping("/update_status_manager")
    @ApiOperation("@Validated分组验证1(Group01选择性验证)-0-1-2")
    public RespData updateStatusManager(@Validated(UserUpdateStatusDTO.Group01.class) UserUpdateStatusDTO updateStatusDTO) {
        logger.info("[updateStatusManager][UserUpdateStatusDTO: {}]", updateStatusDTO);
        return RespData.success();
    }

    @PostMapping("/update_status_user")
    @ApiOperation("@Validated分组测试2(Group02选择性验证)-1-2")
    public RespData updateStatusUser(@Validated(UserUpdateStatusDTO.Group02.class) UserUpdateStatusDTO updateStatusDTO) {
        logger.info("[updateStatusUser][UserUpdateStatusDTO: {}]", updateStatusDTO);
        return RespData.success();
    }

    /**
     * @Valid @Validated只会生效一个
     * @Validated @Valid 两个都会生效,分组和非分组都会进行验证1
     * @param updateDTO
     */
   /* @PostMapping("/update")
    @ApiOperation("验证所有规则（含分组）-@Validated+@Valid ")
    public void update(@Validated(UserUpdateStatusDTO.Group01.class)  @Valid  UserUpdateDTO updateDTO) {
        logger.info("[update][UserUpdateDTO: {}]", updateDTO);
    }*/


    /**
     * 验证所有规则2
     * @param updateDTO
     */
   @PostMapping("/update")
    @ApiOperation("验证所有规则（含指定分组）-Default ")
    public RespData update(@Validated({UserUpdateStatusDTO.Group01.class, Default.class}) UserUpdateDTO updateDTO) {
        logger.info("[update][UserUpdateDTO: {}]", updateDTO);
        return RespData.success();
    }


    /**
     * 只会对分组1的参数进行验证
     * @param updateDTO
     */
   /* @PostMapping("/update1")
    @ApiOperation("局部验证Group01-@Validated分组验证")
    public RespData update1(@Validated(UserUpdateStatusDTO.Group01.class)  UserUpdateDTO updateDTO) {
        logger.info("[update][UserUpdateDTO: {}]", updateDTO);
        return RespData.success();
    }*/

    /**
     * 只会对非分组的参数进行验证
     * @param updateDTO
     */
    @PostMapping("/update2")
    @ApiOperation("非分组验证-@Valid实现-Json格式")
    public RespData update2(@RequestBody @Valid UserUpdateDTO updateDTO) {
        logger.info("[update2][UserUpdateDTO: {}]", updateDTO);
        return RespData.success();
    }

    /**
     *  BindingResult封装样例
     * @param updateDTO
     * @param result
     * @return
     */
    @PostMapping("/updateUserdemo")
    @ApiOperation("验证demo-BindingResult封装样例")
    public RespData updateUserdemo(@RequestBody @Validated UserUpdateDTO updateDTO, BindingResult result) {
        logger.info("[updateUserdemo][UserUpdateDTO: {}]", updateDTO);
        if(result.hasErrors()){
            for (ObjectError error : result.getAllErrors()) {
                return RespData.error(ServiceExceptionEnum.INVALID_REQUEST_PARAM_ERROR.getCode(),error.getDefaultMessage());
            }
        }
        return RespData.success();
    }




}
