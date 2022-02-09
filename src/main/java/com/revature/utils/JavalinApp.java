package com.revature.utils;

import com.revature.controllers.AuthController;
import com.revature.controllers.ReimbursementController;
import com.revature.controllers.UserController;
import com.revature.daos.ReimbursementDao;
import com.revature.daos.ReimbursementDaoImp;
import com.revature.daos.UserDao;
import com.revature.daos.UserDaoImp;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.models.UserRole;
import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static io.javalin.apibuilder.ApiBuilder.*;

import static com.revature.models.UserRole.EMPLOYEE;
import static com.revature.models.UserRole.MANAGER;

public class JavalinApp {

    LoggingUtil logger = new LoggingUtil();

    UserController uc = new UserController();
    ReimbursementController rc = new ReimbursementController();
    AuthController auth = new AuthController();
    //LoggingUtil logger = new LoggingUtil();

    private Javalin app = Javalin.create().routes(() -> {

        //require a valid token for all account and customer activities
       /*
        before("account", auth::authorizeToken);
        before("account/*", auth::authorizeToken);
        before("customer", auth::authorizeToken);
        before("customer/*", auth::authorizeToken);


        */

        //before making an account
        path("user", () -> {
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


    public static void main(String[] args) {
        Javalin app = Javalin.create().start(8080);

        //Javalin runs until "close" is typed into the console
        Scanner scan = new Scanner(System.in);
        while (true) {

            String input = scan.nextLine();

            //if "close is entered, Javalin closes and the app closes
            if (input.equals("close")) {
                app.close();
                break;
            }
        }
    }
}