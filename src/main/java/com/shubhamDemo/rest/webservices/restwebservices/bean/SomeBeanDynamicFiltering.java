package com.shubhamDemo.rest.webservices.restwebservices.bean;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@JsonFilter("SomeDynamicFilter")
public class SomeBeanDynamicFiltering {

    private String test1;
    private String test2;
    private String test3;
}
