package ru.cft.yellowrubberduck.service;

import ru.cft.yellowrubberduck.repository.model.UserEntity;
import ru.cft.yellowrubberduck.repository.model.dto.UserDto;

import java.util.List;
import java.util.Optional;


public interface UserService {
    public List<UserEntity> getAllUsers();

    public Optional<UserEntity> getUserById(Long userId);

    public void createUser(UserEntity userEntity);
}
