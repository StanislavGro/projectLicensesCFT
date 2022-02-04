package ru.cft.yellowrubberduck.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.yellowrubberduck.repository.UserRepository;
import ru.cft.yellowrubberduck.repository.model.UserEntity;
import ru.cft.yellowrubberduck.repository.model.dto.UserDto;
import ru.cft.yellowrubberduck.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper)
    {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return (List<UserEntity>) userRepository.findAll();
    }

    @Override
    public Optional<UserEntity> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public void createUser(UserEntity userEntity) {
        //UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
        userRepository.save(userEntity);
    }

    @Override
    public void updateUser(Long userId, UserEntity userEntity) {
        Optional<UserEntity> tempUser = userRepository.findById(userId);
        UserEntity user = tempUser.get();
        modelMapper.map(userEntity, user);
        userRepository.save(user);
    }

}
