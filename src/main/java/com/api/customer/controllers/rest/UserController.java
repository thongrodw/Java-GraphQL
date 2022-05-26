package com.api.customer.controllers.rest;

import com.api.customer.models.User;
import com.api.customer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/rest/users")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping(path = "/{userId}")
    public Optional<User> getUserById(@PathVariable(value = "userId") String id){
        return  userService.getUserById(id);
    }

    @GetMapping(path = "/search")
    public List<User> getUserByName(@RequestParam(value = "name") String name){
        return  userService.getUser(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user){
        userService.createUser(user);
    }

}
