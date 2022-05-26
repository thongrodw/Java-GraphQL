package com.api.customer.services.datafetcher;

import com.api.customer.models.User;
import com.api.customer.repository.UserRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AllUsersDataFetcher implements DataFetcher<List<User>> {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> get(DataFetchingEnvironment environment) throws Exception {
        return userRepository.findAll();
    }
}
