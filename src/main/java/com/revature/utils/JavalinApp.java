package com.revature.utils;

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

import static com.revature.models.UserRole.EMPLOYEE;
import static com.revature.models.UserRole.MANAGER;

public class JavalinApp {

    LoggingUtil logger = new LoggingUtil();
/*
    private Javalin app = Javalin.create().routes(() -> {

        //require a valid token for all account and customer activities
    });
*/

    public static void main(String[] args) {

              /*
        List<User> users = new ArrayList<>();
        users = test.getAllUsers();
        for (int i=0; i<users.size();i++) {
            System.out.println(users.get(i).toString());
        }



        User u = new User("Lix", "asdfghjk", "Nabiatu", "Kalokoh", "nabi@gmail.com", MANAGER);

        if(test.createUser(u)) {
            System.out.println("Database Updated Successfully");

        } else {
            System.out.println("Something went wrong...");
        }

        User u = test.getUserByUsernameAndPassword("jpatrick1", "W9PGkFtYur");
        if (u != null){
            System.out.println(u.toString());
        } else {
            System.out.println("Something went wrong");
        }

        Date d = new Date();
        Reimbursement r = new Reimbursement(2368.49, new java.sql.Date(12/31/2021), new java.sql.Date(10/25/2021), "Algoneurodystrophy, left lower leg", null);
        if(test2.createRequest(r)){
            System.out.println(r.toString());
        } else {
            System.out.println("Something went wrong :(");
        }
*/
        /*
        if(test2.createRequest(r, u)){
            System.out.println(r.toString());
        }else{
            System.out.println("Something went wrong :(");
        }


        if(test2.deleteReimbursement(1)){
            System.out.println("Database updated successfully");
        } else {
            System.out.println("Something went wrong");
        }




        UserDao test = new UserDaoImp();
        ReimbursementDao test2 = new ReimbursementDaoImp();
        User u = test.getUserById(9);
        Reimbursement r = new Reimbursement( new java.sql.Date(7/23/2021), u.getId(), 2, 6);

        if (test2.updateRequest(r, u)) {
            System.out.println("Database updated successfully");
        } else {
            System.out.println("Something went wrong");
        }

         */

        UserController uc = new UserController();
        ReimbursementController rc = new ReimbursementController();
        //AuthController auth = new AuthController();
        LoggingUtil logger = new LoggingUtil();

        /*

        private Javalin app = Javalin.create().routes(() -> {

            //require a valid token for all account and customer activities
           /*
            before("account", auth::authorizeToken);
            before("account/*", auth::authorizeToken);
            before("customer", auth::authorizeToken);
            before("customer/*", auth::authorizeToken);

            */
        /*
            post("login", cc::handleCreateCustomer);

            path("customer", () -> {
                get(cc::handleGetAll);
                delete(cc::handleDelete);
                path("{id}", () -> {
                    get(cc::handleGetById);
                });
            });
            path("account", () -> {
                get(ac::handleGetAll);
                post(ac::handleCreateAccount);
                delete(ac::handleDelete);
                path("transfer", () -> {
                    put(ac::handleTransfer);
                });
                path("deposit", () -> {
                    put(ac::handleDeposit);
                });
                path("withdraw", () -> {
                    put(ac::handleWithdraw);
                });
                path("{id}", () -> {
                    get(ac::handleGetById);
                });
            });
            path("login", () -> {
                post(auth::authenticateLogin);
            });
            before("*", logger::logRequest);


        });
*/



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
