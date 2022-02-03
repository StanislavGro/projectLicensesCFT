package ru.cft.yellowrubberduck.repository.model.dto;

import lombok.Data;
import ru.cft.yellowrubberduck.repository.model.enums.UserType;

@Data
public class UserDto {

    private Long userId;

    private String userLogin;

    private String userEmail;

    private UserType userType;
}
