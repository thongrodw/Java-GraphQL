package com.api.customer.controllers.graphql;

import com.api.customer.services.GraphQLService;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/graphql")
@RestController
public class UserControllerGraphQL {

    @Autowired
    GraphQLService graphQLService;

    @PostMapping
    public ResponseEntity<Object> getAllUsers(@RequestBody String query){
        ExecutionResult result = graphQLService.getGraphQL().execute(query);
        return new ResponseEntity<Object>(result, HttpStatus.OK);
    }
}
