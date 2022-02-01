package ru.cft.yellowrubberduck.model;

public class User {

    public String login;
    public String email;

    public String getLogin(){
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
