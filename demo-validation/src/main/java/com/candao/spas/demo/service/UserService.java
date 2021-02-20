package com.candao.spas.demo.service;

import com.candao.spas.demo.enums.ServiceExceptionEnum;
import com.candao.spas.demo.core.exception.ServiceException;
import com.candao.spas.demo.core.util.ValidationApiUtils;
import com.candao.spas.demo.dto.UserAddDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Service
@Validated
public class UserService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public void get(@Min(value = 1L, message = "编号必须大于 0") Integer id) {
        logger.info("[get][id: {}]", id);
    }

    public void add(@Valid UserAddDTO addDTO) {
        logger.info("[add][addDTO: {}]", addDTO);
    }

    public void add01(UserAddDTO addDTO) {
        logger.info("[add01][addDTO: {}]", addDTO);

        List<String> errorMsgs = ValidationApiUtils.check(addDTO);;
        if (!errorMsgs.isEmpty()) {
            throw new ServiceException(ServiceExceptionEnum.INVALID_REQUEST_PARAM_ERROR.getCode(),
                    errorMsgs.toString());
        }
    }

    public void add02(UserAddDTO addDTO) {
        self().add(addDTO);
    }

    private UserService self() {
        return (UserService) AopContext.currentProxy();
    }

}
