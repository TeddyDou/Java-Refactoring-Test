package com.h2rd.refactoring.dao;

import com.h2rd.refactoring.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserDao {

    void saveUser(User user);

    ArrayList<User> getUsers();

    void deleteUser(User userToDelete);

    void updateUser(User userToUpdate);

    User findUser(String name);
}
