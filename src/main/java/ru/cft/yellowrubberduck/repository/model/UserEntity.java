package ru.cft.yellowrubberduck.repository.model;


import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "User")
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "login")
    private String userLogin;

    @Column(name = "email")
    private String userEmail;

    @Column(name = "user_type")
    private UserType userType;

    public UserEntity(){}

    public UserEntity(String userLogin, String userEmail, UserType userType){
        this.userLogin = userLogin;
        this.userEmail = userEmail;
        this.userType = userType;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
