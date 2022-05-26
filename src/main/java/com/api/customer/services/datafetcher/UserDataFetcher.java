package com.api.customer.services.datafetcher;

import com.api.customer.models.User;
import com.api.customer.repository.UserRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDataFetcher implements DataFetcher<Optional<User>> {

    @Autowired
    UserRepository userRepository;

    @Override
    public Optional<User> get(DataFetchingEnvironment environment) throws Exception {

        String id = environment.getArgument("id");

        return userRepository.findById(id);
    }
}
