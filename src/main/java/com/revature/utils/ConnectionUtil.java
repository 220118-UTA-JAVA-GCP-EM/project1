package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    public static Connection getConnection() throws SQLException {

        String url = "jdbc:postgresql://34.85.240.249:5432/postgres";
        String user = "postgres";
        String password = "123456";

        //use this to fix classpath issues on different platforms
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return DriverManager.getConnection(url, user, password);

    }

}
