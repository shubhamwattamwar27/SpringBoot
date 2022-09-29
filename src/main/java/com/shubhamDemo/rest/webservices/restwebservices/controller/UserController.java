package com.shubhamDemo.rest.webservices.restwebservices.controller;

import com.shubhamDemo.rest.webservices.restwebservices.bean.User;
import com.shubhamDemo.rest.webservices.restwebservices.dao.UserDaoImpl;
import com.shubhamDemo.rest.webservices.restwebservices.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserDaoImpl userDao;

    @GetMapping("/users")
    public List<User> fetchAll(){
        return userDao.findAll();
    }

    @GetMapping("/users/{id}")
    public EntityModel fetchUser(@PathVariable Integer id)
    {
        User user = userDao.findOne(id);
        if(user == null)
            throw new UserNotFoundException("id = "+id);
        EntityModel<User> entityModel = EntityModel.of(user);

        WebMvcLinkBuilder linkBuilder = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).fetchAll());
        entityModel.add(linkBuilder.withRel("all-users"));
        return entityModel;
    }


    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id)
    {
        User user = userDao.deleteOne(id);
        if(user == null)
            throw new UserNotFoundException("id = "+id);

    }

    @PostMapping("users")
    public ResponseEntity save(@Valid @RequestBody User user)
    {
        User savedUser = userDao.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}
