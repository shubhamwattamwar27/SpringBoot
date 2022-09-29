package com.shubhamDemo.rest.webservices.restwebservices.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties(value = "test2")
public class SomeBean {

    private String test1;
    private String test2;
    @JsonIgnore
    private String test3;
}
