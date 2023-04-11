package com.teclead.demo.controller;

import com.teclead.demo.model.CustomUser;
import com.teclead.demo.repository.UserRepository;
import com.teclead.demo.exception.CustomUserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<CustomUser>> getUsersByName() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/{name}", produces = "application/json")
    public ResponseEntity<List<CustomUser>> getUsersByName(@PathVariable String name) {
        return new ResponseEntity<>(userRepository.findByName(name), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<CustomUser> updateUser(@PathVariable Long id, @RequestBody CustomUser updatedUser) {
        CustomUser user = userRepository.findById(id).orElseThrow(() ->
            new CustomUserNotFoundException("Could not find user " + id)
        );

        user.setName(updatedUser.getName());
        user.setSurname(updatedUser.getSurname());
        user.setEmail(updatedUser.getEmail());
        return new ResponseEntity(userRepository.save(user), HttpStatus.OK);
    }

    @PostMapping(value= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<CustomUser> addUser(@RequestBody CustomUser user) {
        return new ResponseEntity(userRepository.save(user), HttpStatus.CREATED);
    }
}
