package com.revature.utils;

import io.javalin.Javalin;

import java.util.Scanner;

public class JavalinApp {

    LoggingUtil logger = new LoggingUtil();
/*
    private Javalin app = Javalin.create().routes(() -> {

        //require a valid token for all account and customer activities
    });
*/

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
