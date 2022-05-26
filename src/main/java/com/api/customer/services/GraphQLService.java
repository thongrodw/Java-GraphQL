package com.api.customer.services;

import com.api.customer.services.datafetcher.AllUsersDataFetcher;
import com.api.customer.services.datafetcher.UserDataFetcher;
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
public class GraphQLService {

    @Value("classpath:users.graphql")
    Resource resource;

    private GraphQL graphQL;
    @Autowired
    private AllUsersDataFetcher allUsersDataFetcher;
    @Autowired
    private UserDataFetcher userDataFetcher;

    //Load Schema when application start
    @PostConstruct
    public void loadSchema() throws IOException {

        //Get GraphQL Schema
        File file = resource.getFile();

        //Parse
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(file);
        RuntimeWiring wiring = buildRuntimeWiring();

        //Create GraphQL Schema
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        graphQL = GraphQL.newGraphQL(schema).build();

    }

    //Map GraphQL Schema and Fetch the Data
    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring ->
                        typeWiring
                                .dataFetcher("allUsers", allUsersDataFetcher)
                                .dataFetcher("user", userDataFetcher))
                .build();
    }

    //Query Service for API
    public GraphQL getGraphQL() {
        return graphQL;
    }
}
