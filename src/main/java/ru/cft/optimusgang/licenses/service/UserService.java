package ru.cft.optimusgang.licenses.service;

import ru.cft.optimusgang.licenses.repository.model.entities.User;

import java.util.List;
import java.util.Optional;


public interface UserService {
    public List<User> getAllUsers();

    public Optional<User> getUserById(Long userId);

    public void createUser(User user);
}
