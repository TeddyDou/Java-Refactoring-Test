package com.h2rd.refactoring.dao.impl;

import com.h2rd.refactoring.dao.UserDao;
import com.h2rd.refactoring.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

@Repository
public class UserDaoImpl implements UserDao {

    private ArrayList<User> users;

    private static UserDaoImpl userDaoImpl;

    public static UserDaoImpl getUserDaoImpl() {
        if (userDaoImpl == null) {
            userDaoImpl = new UserDaoImpl();
        }
        return userDaoImpl;
    }

    public void saveUser(User user) {
        if (users == null) {
            users = new ArrayList<User>();
        }
        users.add(user);
    }

    public ArrayList<User> getUsers() {
        try {
            return users;
        } catch (Throwable e) {
            System.out.println("error");
            return null;
        }
    }

    public void deleteUser(User userToDelete) {
        try {
            for (User user : users) {
                if (user.getName().equals(userToDelete.getName())) {
                    users.remove(user);
                }
            }
        } catch (ConcurrentModificationException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User userToUpdate) {
        try {
            for (User user : users) {
                if (user.getName().equals(userToUpdate.getName())) {
                    user.setEmail(userToUpdate.getEmail());
                    user.setRoles(userToUpdate.getRoles());
                }
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public User findUser(String name) {
        try {
            for (User user : users) {
                if (user.getName().equals(name)) {
                    return user;
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }
}
