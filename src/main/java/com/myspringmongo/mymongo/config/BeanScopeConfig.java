package com.myspringmongo.mymongo.config;

import com.myspringmongo.mymongo.service.RequestBeanScopeService;
import com.myspringmongo.mymongo.service.SessionBeanScopeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class BeanScopeConfig {

    @Bean
    @RequestScope
    public RequestBeanScopeService getRequestScopeService() {
        return new RequestBeanScopeService();
    }

    @Bean
    @SessionScope
    public SessionBeanScopeService getSessionScopeService() {
        return new SessionBeanScopeService();
    }
}
