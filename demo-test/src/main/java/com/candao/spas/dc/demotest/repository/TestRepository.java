package com.candao.spas.dc.demotest.repository;

import org.springframework.stereotype.Repository;

/**
 * @author Nicholas
 * @title: TestRepository
 * @projectName demo-test
 * @description: 假装是个Repo
 * @date 2021-02-02 16:40
 */
@Repository
public class TestRepository {
    public String get(){
        return "Junit5";
    }
}