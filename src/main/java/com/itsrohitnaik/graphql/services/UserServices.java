package com.itsrohitnaik.graphql.services;

import com.itsrohitnaik.graphql.dao.UsersDao;
import com.itsrohitnaik.graphql.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices implements UserServiceInterface {

    @Autowired
    UsersDao userDao;

    @Override
    public List<Users> getUsers() {
        return userDao.getUsers();
    }
}
