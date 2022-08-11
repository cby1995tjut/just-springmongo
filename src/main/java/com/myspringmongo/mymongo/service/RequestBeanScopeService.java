package com.myspringmongo.mymongo.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


public class RequestBeanScopeService {

    private long id;

    public RequestBeanScopeService() {
        this.id = System.nanoTime();
    }

    @Override
    public String toString() {
        return "BeanScopeService{" +
                "id=" + id +
                '}';
    }
}
