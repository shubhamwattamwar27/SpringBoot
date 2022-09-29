package com.shubhamDemo.rest.webservices.restwebservices.dao;

import com.shubhamDemo.rest.webservices.restwebservices.bean.User;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserDaoImpl {

    private static List<User> userList = new ArrayList<>();

    private static int userCount = 4;

    static {
        userList.add(new User(1,"Shubham test 1",new Date()));
        userList.add(new User(2,"Shubham test 2",new Date()));
        userList.add(new User(3,"Shubham test 3",new Date()));
        userList.add(new User(4,"Shubham test 4",new Date()));
    }

    public User save(User user){
        if(user.getId() == null )
            user.setId(++userCount);
        userList.add(user);
        return user;
    }

    public List<User> findAll()
    {
        return userList;
    }

    public User findOne(int id)
    {
        for(User user : userList){
            if(user.getId() == id)
                return user;
        }
        return null;
    }

    public User deleteOne(int id)
    {
        Iterator<User> iterator= userList.iterator();
        while(iterator.hasNext())
        {
            User user = iterator.next();
            if(user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }



}
