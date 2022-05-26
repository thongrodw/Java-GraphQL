package com.api.customer.repository;

import com.api.customer.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

    @Override
    Optional<User> findById(String id);

    List<User> findByFirstName(String firstName);
    List<User> findByEmail(String email);

}
