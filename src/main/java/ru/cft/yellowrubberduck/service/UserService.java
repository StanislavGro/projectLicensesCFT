package ru.cft.yellowrubberduck.service;

import ru.cft.yellowrubberduck.repository.model.UserEntity;

import java.util.List;
import java.util.Optional;


public interface UserService {
    public List<UserEntity> getAllUsers();

    public Optional<UserEntity> getUserById(Long userId);

}
