package com.shubhamDemo.rest.webservices.restwebservices.dao;

import com.shubhamDemo.rest.webservices.restwebservices.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
