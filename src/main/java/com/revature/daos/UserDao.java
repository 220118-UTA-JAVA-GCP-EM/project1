package com.revature.daos;

import com.revature.models.User;

import java.util.List;

public interface UserDao {
    public boolean createUser(User u);
    public boolean createRole(User u);
    public boolean updateUser(User c);
    public List<User> getAllUsers();
    public User getUserById(int id);
    public User getUserByUsernameAndPassword(String user, String pass);

}
