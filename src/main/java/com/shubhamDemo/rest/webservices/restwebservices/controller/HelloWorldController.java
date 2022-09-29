package com.shubhamDemo.rest.webservices.restwebservices.controller;

import com.shubhamDemo.rest.webservices.restwebservices.bean.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping(path = "/hello-world")
    public String helloworld(){
        return "HEllo World Rest SErvice";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloworldBean(){
        return new HelloWorldBean("HEllo World Rest SErvice");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloworldPathVariable(@PathVariable(name = "name") String name1){
        return new HelloWorldBean(String.format("Hello World Rest Service = %s",name1));
    }

    @GetMapping(path = "/hello-world-internationalized")
    public String helloworldInternationalized(@RequestHeader(name = "Accept-Language", required = false) Locale locale )
    {

        return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
    }
}
