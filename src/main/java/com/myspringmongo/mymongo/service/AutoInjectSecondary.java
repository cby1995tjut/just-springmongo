package com.myspringmongo.mymongo.service;

import org.springframework.stereotype.Service;

import javax.annotation.Priority;

@Service
@Priority(1)
public class AutoInjectSecondary implements AutoInject {

    public AutoInjectSecondary() {
        //only for test
        System.out.println("Priority....");
    }
}
