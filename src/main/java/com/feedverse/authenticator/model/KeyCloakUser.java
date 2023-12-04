package com.feedverse.authenticator.model;
import jakarta.persistence.*;

@Entity
public class KeyCloakUser {

    private String username;
    private String fullName;

    @Id
    private String email;

    private String password;

    public KeyCloakUser() {
    }
    public KeyCloakUser(String username, String fullName,String email, String password) {
        this.username = username;
        this.fullName= fullName;
        this.email = email;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "KeyCloakUser{" +
                "username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
