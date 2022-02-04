package com.revature.utils;

import com.revature.daos.UserDao;
import com.revature.daos.UserDaoImp;
import com.revature.models.User;
import com.revature.models.UserRole;
import io.javalin.Javalin;

import java.util.ArrayList;
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

       /*
        List<User> users = new ArrayList<>();
        users = test.getAllUsers();
        for (int i=0; i<users.size();i++) {
            System.out.println(users.get(i).toString());
        }

        */
        User u = new User("test", "test", "Ray", "Mabbs",
                "test@test.com", EMPLOYEE);

        if(test.createUser(u)){
            System.out.println("Database Updated Successfully");
        }
        else {
            System.out.println("Something went wrong...");
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
