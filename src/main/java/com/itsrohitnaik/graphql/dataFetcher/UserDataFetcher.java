package com.itsrohitnaik.graphql.dataFetcher;

import com.itsrohitnaik.graphql.model.Users;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

@Component
public class UserDataFetcher implements DataFetcher {
    @Override
    public Object get(DataFetchingEnvironment environment) {
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
        String id = environment.getArgument("id");

        return (id == "1") ? u1 : u2;
    }
}
