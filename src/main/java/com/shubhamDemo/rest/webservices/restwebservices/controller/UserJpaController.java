package com.shubhamDemo.rest.webservices.restwebservices.controller;

import com.shubhamDemo.rest.webservices.restwebservices.bean.User;
import com.shubhamDemo.rest.webservices.restwebservices.dao.UserDaoImpl;
import com.shubhamDemo.rest.webservices.restwebservices.dao.UserRepository;
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
public class UserJpaController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/jpa/users")
    public List<User> fetchAll(){
        return  userRepository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public EntityModel fetchUser(@PathVariable Integer id)
    {
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent())
            throw new UserNotFoundException("id = "+id);
        EntityModel<Optional<User>> entityModel = EntityModel.of(user);

        WebMvcLinkBuilder linkBuilder = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).fetchAll());
        entityModel.add(linkBuilder.withRel("all-users"));
        return entityModel;
    }


    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable Integer id)
    {
        userRepository.deleteById(id);
    }

    @PostMapping("/jpa/users")
    public ResponseEntity save(@Valid @RequestBody User user)
    {
        User savedUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}
