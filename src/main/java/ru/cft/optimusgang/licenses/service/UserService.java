package ru.cft.optimusgang.licenses.service;

import ru.cft.optimusgang.licenses.repository.model.entities.UserEntity;

import java.util.List;
import java.util.Optional;


public interface UserService {
    public List<UserEntity> getAllUsers();

    public Optional<UserEntity> getUserById(Long userId);

    public void createUser(UserEntity userEntity);

    public void updateUser(Long userId, UserEntity userEntity);
}
