package ru.cft.optimusgang.licenses.repository.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;
import ru.cft.optimusgang.licenses.repository.model.enums.UserType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "Users")
public class User implements Serializable {
    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "login")
    private String userLogin;

    @Column(name = "email")
    private String userEmail;

    @Column(name = "user_type")
    private UserType userType;

    @OneToMany(mappedBy = "user")
    //@JsonBackReference
    private List<License> licenseList;

    public User(){}

    public User(String userLogin, String userEmail, UserType userType){
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
