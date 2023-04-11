package com.teclead.demo.controllers;

import com.teclead.demo.models.CustomUser;
import com.teclead.demo.repositories.UserRepository;
import exceptions.CustomUserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/", produces = "application/json")
    public List<CustomUser> getUsersByName() {
        return userRepository.findAll();
    }
    @GetMapping(value = "/{name}", produces = "application/json")
    public List<CustomUser> getUsersByName(@PathVariable String name) {
        return userRepository.findByName(name);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

    @PatchMapping(value = "/{id}", produces = "application/json")
    public CustomUser updateUser(@PathVariable Long id, @RequestBody CustomUser updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setName(updatedUser.getName());
            user.setSurname(updatedUser.getSurname());
            user.setEmail(updatedUser.getEmail());
            return userRepository.save(user);
        }).orElseThrow(() ->
            new CustomUserNotFoundException(id)
        );
    }

    @PostMapping(value= "/", consumes = "application/json", produces = "application/json")
    public CustomUser addUser(@RequestBody CustomUser user) {
        return userRepository.save(user);
    }
}
