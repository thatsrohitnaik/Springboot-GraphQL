package com.itsrohitnaik.graphql.dao;

import com.itsrohitnaik.graphql.model.Users;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsersDao implements UsersDaoInterface{

    @Override
    public List<Users> getUsers() {
        List<Users> users = new ArrayList<>();
        Users u1 = new Users();
        Users u2 = new Users();
        u1.setAddress("at home");
        u1.setAge(32);
        u1.setId("1");
        u1.setName("Duck");
        u2.setAddress("at home");
        u2.setAge(12);
        u2.setId("2");
        u2.setName("Bear");
        users.add(u1);
        users.add(u2);
        return users;
    }
}
