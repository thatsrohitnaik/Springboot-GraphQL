package com.itsrohitnaik.graphql.controller;

import com.itsrohitnaik.graphql.model.Users;
import com.itsrohitnaik.graphql.services.GraphqlService;
import com.itsrohitnaik.graphql.services.UserServices;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UsersController implements UsersControllerInterface {

    @Autowired
    UserServices userServices;

    @Autowired
    GraphqlService graphqlService;

    @GetMapping("/users")
    @Override
    public List<Users> getUsers() {
        return userServices.getUsers();
    }

    @PostMapping("/users")
    public ResponseEntity<Object> getAllBooks(@RequestBody String query) {
        ExecutionResult execute = graphqlService.getGraphQL().execute(query);
        return new ResponseEntity<>(execute, HttpStatus.OK);
    }
}
