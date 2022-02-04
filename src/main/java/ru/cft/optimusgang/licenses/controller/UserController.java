package ru.cft.optimusgang.licenses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.cft.optimusgang.licenses.repository.model.entities.User;
import ru.cft.optimusgang.licenses.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/user/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUserById(@PathVariable Long id)
    {
        return userService.getUserById(id);
    }

    @PostMapping("/user")
    public void createUser(@RequestBody User user){
        userService.createUser(user);
    }
}
