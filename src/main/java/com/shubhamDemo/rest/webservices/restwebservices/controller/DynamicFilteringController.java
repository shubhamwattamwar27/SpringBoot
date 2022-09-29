package com.shubhamDemo.rest.webservices.restwebservices.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.shubhamDemo.rest.webservices.restwebservices.bean.SomeBean;
import com.shubhamDemo.rest.webservices.restwebservices.bean.SomeBeanDynamicFiltering;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DynamicFilteringController {

    @GetMapping("/dynamic-filtering")
    public MappingJacksonValue fetchSomeBean(){
        SomeBeanDynamicFiltering someBeanDynamicFiltering= new SomeBeanDynamicFiltering("test1","test2","test3");
        SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("test1");

        FilterProvider filter = new SimpleFilterProvider().addFilter("SomeDynamicFilter",simpleBeanPropertyFilter);

        MappingJacksonValue mapping = new MappingJacksonValue(someBeanDynamicFiltering);
        mapping.setFilters(filter);
        return mapping;
    }
}
