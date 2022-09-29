package com.shubhamDemo.rest.webservices.restwebservices.controller;

import com.shubhamDemo.rest.webservices.restwebservices.bean.SomeBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController {

    @GetMapping("/filtering")
    public SomeBean fetchSomeBean(){
       return new SomeBean("test1","test2","test3");
    }

}
