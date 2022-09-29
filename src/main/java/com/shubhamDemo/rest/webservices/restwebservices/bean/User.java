package com.shubhamDemo.rest.webservices.restwebservices.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    @Size(min = 2,message = "Name should have at leat 2 char")
    private String name;
    @Past(message = "Date should be in past")
    private Date dob;


    public User(int id, String name, Date dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
    }

    public User(){}
}
