package com.myspringmongo.mymongo.service;


public class SessionBeanScopeService {

    private long id;

    public SessionBeanScopeService() {
        this.id = System.nanoTime();
    }

    @Override
    public String toString() {
        return "BeanScopeService{" +
                "id=" + id +
                '}';
    }
}
