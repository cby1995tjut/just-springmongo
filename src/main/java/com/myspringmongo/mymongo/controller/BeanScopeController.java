package com.myspringmongo.mymongo.controller;

import com.myspringmongo.mymongo.service.RequestBeanScopeService;
import com.myspringmongo.mymongo.service.SessionBeanScopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeanScopeController {

    private final RequestBeanScopeService requestScopeService;
    private final SessionBeanScopeService sessionScopeService;

    @Autowired
    public BeanScopeController(RequestBeanScopeService requestScopeService, SessionBeanScopeService sessionScopeService) {
        this.requestScopeService = requestScopeService;
        this.sessionScopeService = sessionScopeService;
    }

    @RequestMapping("/request")
    public String getRequestBeanScope() {
        return requestScopeService.toString();
    }

    @RequestMapping("/session")
    public String getSessionBeanScope() {
        return sessionScopeService.toString();
    }
}
