package ru.cft.yellowrubberduck.service;

import ru.cft.yellowrubberduck.repository.model.UserEntity;

import java.util.List;


public interface UserService {
    public List<UserEntity> getAllUsers();

    public List<UserEntity> getUserById(Long userId);

}
