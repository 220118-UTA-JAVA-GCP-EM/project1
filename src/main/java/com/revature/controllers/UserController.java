package com.revature.controllers;

import com.revature.daos.UserDaoImp;
import com.revature.models.User;
import com.revature.services.UserService;
import io.javalin.http.Context;

import java.util.List;

public class UserController {
    UserService us = new UserService();

    public void handleCreateUser(Context ctx){
        User u = ctx.bodyAsClass(User.class);
        boolean success = us.createUser(u);

        if (success){
            ctx.status(201);
        }else{
            ctx.status(400);
        }
    }

    public void handleUpdateUser(Context ctx){
        User u = ctx.bodyAsClass(User.class);
        boolean success = us.updateUser(u);
    }

    public void handleGetAllUsers(Context ctx){
        List<User> u = us.getAllUsers();
        ctx.json(u);
    }

    public void handleGetUserById(Context ctx){

    }

    public void handleGetUserByUsernameAndPassword(Context ctx){

    }

    public void handleDeleteUser(){}
}
