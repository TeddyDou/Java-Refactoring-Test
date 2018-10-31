package com.h2rd.refactoring.service;

import com.h2rd.refactoring.dao.impl.UserDaoImpl;
import com.h2rd.refactoring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserDaoImpl userDao;

    @Autowired
    public UserService(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public void addUser(User user) {
        userDao.saveUser(user);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    public List<User> getUsers() {
        return userDao.getUsers();
    }

    public User findUser(String name) {
        return userDao.findUser(name);
    }
}
