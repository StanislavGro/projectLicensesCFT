package ru.cft.optimusgang.licenses.repository.model.entities.dto;

import lombok.Data;
import ru.cft.optimusgang.licenses.repository.model.enums.UserType;

@Data
public class UserDto {

    private Long userId;

    private String userLogin;

    private String userEmail;

    private UserType userType;

}
