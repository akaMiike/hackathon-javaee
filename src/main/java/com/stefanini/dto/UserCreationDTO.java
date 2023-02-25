package com.stefanini.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stefanini.model.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class UserCreationDTO {

    @Size(max = 50, message= "Name must have 50 characters maximum.")
    @NotBlank(message = "Name can't be empty.")
    private String name;

    @Email(message = "Invalid email format.")
    @Size(min = 10, message = "Email must have at least 10 characters.")
    @NotBlank(message = "Email can't be empty.")
    private String email;

    @Size(min = 5, max = 20, message = "Login must have between 5 and 20 characters.")
    @NotBlank(message = "Login can't be empty.")
    private String login;

    @NotBlank(message = "Password can't be empty.")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{4,10}$",
            message = "Password must have between 4 and 10 characters, with least 1 special character, 1 upper character, 1 lower character and 1 number"
    )
    private String password;

    private LocalDate birthDate;

    public UserCreationDTO(){}

    public UserCreationDTO(String name, String email, String login, String password, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.login = login;
        this.password = password;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public User toUser(){
        return new User(
                this.getName(),
                this.getLogin(),
                this.getEmail(),
                this.getPassword(),
                this.getBirthDate()
        );
    }
}
