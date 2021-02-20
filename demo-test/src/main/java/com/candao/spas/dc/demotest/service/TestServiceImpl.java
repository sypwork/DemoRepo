package com.candao.spas.dc.demotest.service;

import com.candao.spas.dc.demotest.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Nicholas
 * @title: TestServiceImpl
 * @projectName demo-test
 * @description: TODO
 * @date 2021-02-02 16:38
 */
@Service
public class TestServiceImpl implements TestService {
    
    @Autowired
    TestRepository repo;
    
    @Override
    public String get() {
        return repo.get();
    }
    
}