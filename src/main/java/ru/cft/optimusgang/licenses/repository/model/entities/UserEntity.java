package ru.cft.optimusgang.licenses.repository.model.entities;

import org.hibernate.annotations.GenericGenerator;
import ru.cft.optimusgang.licenses.repository.model.enums.UserType;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "Users")
public class UserEntity implements Serializable {
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

    //нигде не используется
    //@OneToMany(mappedBy = "user")
    //@JsonBackReference
    //private List<License> licenseList;

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserEntity)) {
            return false;
        }

        UserEntity anotherUser = (UserEntity) obj;
        // Compare the data members and return accordingly
        return (this.userId.compareTo(anotherUser.userId) == 0)
                && (this.userLogin.compareTo(anotherUser.userLogin) == 0)
                && (this.userEmail.compareTo(anotherUser.userEmail) == 0)
                && (this.userType.compareTo(anotherUser.userType) == 0);
    }

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
