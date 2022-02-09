package com.revature.utils;

import com.revature.controllers.AuthController;
import com.revature.controllers.ReimbursementController;
import com.revature.controllers.UserController;
import io.javalin.Javalin;

import java.util.Scanner;

import static io.javalin.apibuilder.ApiBuilder.*;

public class JavalinApp {

    static LoggingUtil logger = new LoggingUtil();
    static UserController uc = new UserController();
    static ReimbursementController rc = new ReimbursementController();
    static AuthController auth = new AuthController();


    /*


    //private Javalin app = Javalin.create().routes(() -> {

        //before making an account
        path("/user", () -> {
            post(uc::handleCreateUser);
        });

        //when you already have an account
        path("login", () -> {
            post(auth::authenticateLogin);
        });

        //if you have an employee token
        path("employee", () ->{
            before(auth::authorizeEmployee);
            path("user", () -> {
                post(uc::handleCreateUser);
                path("{id}", () -> {
                    //by their OWN id
                    get(uc::handleGetUserById);
                    put(uc::handleUpdateUser);
                });
            });
            path("request", () -> {
                post(rc::handleCreateRequest);
                path("{id}", () -> {
                    //by their OWN id
                    get(rc::handleGetRequestById);
                });
            });
        });

        //if you have a manager token
        path("manager", () ->{
            before(auth::authorizeManager);
            path("user", () -> {
                post(uc::handleCreateUser);
                get(uc::handleGetAllUsers);
                path("{id}", () -> {
                    get(uc::handleGetUserById);
                    put(uc::handleUpdateUser);
                    delete(uc::handleDeleteUser);
                });
            });
            path("request", () -> {
                get(rc::handleGetAllRequests);
                delete(rc::handleDeleteRequest);
                path("{id}", () -> {
                    get(rc::handleGetRequestById);
                    put(rc::handleUpdateRequest);
                });
            });
        });
        before("*", logger::logRequest);
    });
*/


    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {config.enableCorsForAllOrigins();});

        //Initial logins
        app.post("/user", uc::handleCreateUser);
        app.post("/login", auth::authenticateLogin);


        //employee stuff
        app.get("/employee/user/{id}", uc::handleGetUserById);
        app.put("/employee/user/{id}", uc::handleUpdateUser);
        app.post("/employee/request", rc::handleCreateRequest);
        app.get("/employee/request/{id}", rc::handleGetRequestById);



        app.start(8080);
    }
}