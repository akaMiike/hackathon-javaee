package com.stefanini.services;

import com.stefanini.dao.UserDAO;
import com.stefanini.exceptions.user.InvalidPasswordException;
import com.stefanini.exceptions.user.UserLoginAlreadyExistsException;
import com.stefanini.exceptions.user.UserNotFoundException;
import com.stefanini.model.User;
import com.stefanini.util.PasswordUtils;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class UserService {

    @Inject
    UserDAO userDAO;

    public List<User> getAll(){
        return userDAO.findAll();
    }

    public List<User> getAll(String nameInitial){
        if(nameInitial == null) return getAll();
        else return userDAO.findAllByNameWithLetterPrefix(nameInitial);
    }

    public List<User> getAllBirthdaysOfTheMonth(Integer month){
        if(month == 0) month = LocalDate.now().getMonthValue();
        return userDAO.getBirthdaysOfMonth(month);
    }

    public void save(User newUser){
        if(userDAO.existsUserByLogin(newUser.getLogin()))
            throw new UserLoginAlreadyExistsException();
        else if(!PasswordUtils.isValidPassword(newUser.getPassword())){
            throw new InvalidPasswordException();
        }

        newUser.setPassword(PasswordUtils.encodeBase64(newUser.getPassword()));
        userDAO.save(newUser);
    }

    public User update(Integer id, User updatedUser){
        if(!PasswordUtils.isValidPassword(updatedUser.getPassword())){
            throw new InvalidPasswordException();
        }

        User oldUser = findById(id);

        updatedUser.setId(id);
        updatedUser.setCreatedAt(oldUser.getCreatedAt());
        updatedUser.setPassword(PasswordUtils.encodeBase64(updatedUser.getPassword()));

        return userDAO.update(updatedUser);
    }

    public void delete(Integer id){
        User existsUser = findById(id);
        userDAO.delete(existsUser.getId());
    }

    public User findById(Integer id){
        return userDAO.findUserById(id).orElseThrow(
                () -> new UserNotFoundException()
        );
    }

    public User findByLogin(String login){
        return userDAO.findUserByLogin(login).orElseThrow(
                () -> new UserNotFoundException()
        );
    }

    public List<String> findAllUsersEmailProviders(){
        return userDAO.findAllUsersEmailProviders();
    }
}
