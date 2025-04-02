package com.example.library.kata.controller;

import com.example.library.kata.persistence.User;
import com.example.library.kata.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserRepository usersRepository;

    public UserController(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
        loadUsers();
    }

    @GetMapping(path = "/{id}")
    public Optional<User> getUser(@PathVariable long id) {
        return usersRepository.findById(id);
    }

    @GetMapping(path = "/all")
    public List<User> getUsers() {
        return usersRepository.findAll();
    }

    private void loadUsers() {
        var users = List.of(
                new User("Jon", "Doe"),
                new User("Test", "User")
        );

        usersRepository.saveAll(users);
    }
}
