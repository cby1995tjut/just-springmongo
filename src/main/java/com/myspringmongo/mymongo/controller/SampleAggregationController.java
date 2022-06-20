package com.myspringmongo.mymongo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleAggregationController {

    @RequestMapping("/sample")
    public String getSampleAggregation() {
        return "";
    }
}
