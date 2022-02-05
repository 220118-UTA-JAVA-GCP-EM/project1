package com.revature.utils;

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

        Javalin app = Javalin.create().start(8080);

        UserDao test = new UserDaoImp();
        ReimbursementDao test2 = new ReimbursementDaoImp();

       /*
        List<User> users = new ArrayList<>();
        users = test.getAllUsers();
        for (int i=0; i<users.size();i++) {
            System.out.println(users.get(i).toString());
        }

        */
        //User u = new User("testtt", "testtt", "Rayy", "Mabbsy", "test4@test4.com",17);
/*
        if(test.getUserById(6)) {
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
*/
        Date d = new Date();
        Reimbursement r = new Reimbursement(2368.49, new java.sql.Date(12/31/2021), new java.sql.Date(10/25/2021), "Algoneurodystrophy, left lower leg", null);
        if(test2.createRequest(r)){
            System.out.println(r.toString());
        } else {
            System.out.println("Something went wrong :(");
        }


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
