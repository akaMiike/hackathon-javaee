package com.stefanini.services;
import com.stefanini.model.User;
import com.stefanini.util.PasswordUtils;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class AuthService {

    @Inject
    UserService userService;

    public Boolean authenticate(String login, String password){
        User user = userService.findByLogin(login);
        return PasswordUtils.passwordMatches(user.getPassword(),password);
    }
}
