package com.shubhamDemo.rest.webservices.restwebservices.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseException {

    private Date timestamp;
    private String message;
    private String details;

}
