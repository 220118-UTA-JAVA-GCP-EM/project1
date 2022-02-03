package com.revature.daos;

import com.revature.models.User;

import java.util.List;

public interface UserDao {
    public boolean createUser();
    public List<User> getAllUsers();
    public User getUserById();
    public User getUserByUsernameAndPassword();

}
