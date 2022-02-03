package ru.cft.yellowrubberduck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.cft.yellowrubberduck.repository.model.UserEntity;
import ru.cft.yellowrubberduck.repository.model.dto.UserDto;
import ru.cft.yellowrubberduck.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/user/all")
    public List<UserEntity> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public Optional<UserEntity> getUserById(@PathVariable Long id)
    {
        return userService.getUserById(id);
    }

    @PostMapping
    public void createUser(@RequestBody UserEntity userEntity){
        userService.createUser(userEntity);
    }
}
