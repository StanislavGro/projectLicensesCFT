package ru.cft.yellowrubberduck.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.yellowrubberduck.repository.UserRepository;
import ru.cft.yellowrubberduck.repository.model.UserEntity;
import ru.cft.yellowrubberduck.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return (List<UserEntity>) userRepository.findAll();
    }

    @Override
    public List<UserEntity> getUserById(Long userId) {
        return null;
    }

}
