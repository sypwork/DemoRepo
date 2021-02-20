package com.candao.spas.dc.demotest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Nicholas
 * @title: TestController
 * @projectName demo-unit-test
 * @description: TODO
 * @date 2021-02-02 16:23
 */
@Controller
public class TestController {
    @ResponseBody
    @GetMapping("/")
    public String hello() {
        return "Hello Controller";
    }
    
}