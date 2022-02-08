package com.myspringmongo.mymongo.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class AutoInjectImpl implements AutoInject {
    public AutoInjectImpl() {
        System.out.println("only for test: inject impl");
    }
}
