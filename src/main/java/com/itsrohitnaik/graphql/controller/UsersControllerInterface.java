package com.itsrohitnaik.graphql.controller;

import com.itsrohitnaik.graphql.model.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UsersControllerInterface {
    public ResponseEntity<Object> getAllUsers(@RequestBody String query);
}
