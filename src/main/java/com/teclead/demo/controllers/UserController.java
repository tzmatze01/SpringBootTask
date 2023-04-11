package com.teclead.demo.controllers;

import com.teclead.demo.models.CustomUser;
import com.teclead.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/{name}", produces = "application/json")
    public List<CustomUser> getUsers(@PathVariable String name) {
        return userRepository.findByName(name);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public CustomUser deleteUser(@PathVariable int id) {
        return null;
    }

    @PatchMapping(value = "/{id}", produces = "application/json")
    public CustomUser updateUser(@PathVariable int id, @RequestBody CustomUser user) {
        return null;
    }

    @PostMapping(produces = "application/json")
    public CustomUser createUser(@RequestBody CustomUser user) {
        return null;
    }
}
