package com.itsrohitnaik.graphql.services;

import com.itsrohitnaik.graphql.dataFetcher.AllUsersDataFetcher;
import com.itsrohitnaik.graphql.dataFetcher.UserDataFetcher;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

@Service
public class GraphqlService {

    @Value("classpath:users.graphql")
    Resource resource;

    @Autowired
    AllUsersDataFetcher allUsersDataFetcher;

    @Autowired
    UserDataFetcher userDataFetcher;

    private GraphQL graphQL;



    @PostConstruct
    private void GraphqlService() throws IOException {
        File schemaFile = resource.getFile();
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        graphQL = GraphQL.newGraphQL(schema).build();
    }


    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("allUsers", allUsersDataFetcher)
                        .dataFetcher("user", userDataFetcher)
                )
                .build();
    }


    public GraphQL getGraphQL() {
        return graphQL;
    }
}
