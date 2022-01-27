package com.demo3;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection createConnection()
    {
        Connection con = null;
        String url = "jdbc:postgresql://ec2-3-216-113-109.compute-1.amazonaws.com:5432/d2588ossjegiv9"; //MySQL URL followed by the database name
        String username = "onjnznphtpvlzb"; //MySQL username
        String password = "ff8e836fb7a630d275b8e9109cb04b91a5fd0937b959cfa509cc007809d6d1b7"; //MySQL password
        System.out.println("In DBConnection.java class ");

        try
        {
            try
            {
                Class.forName("org.postgresql.Driver"); //loading MySQL drivers. This differs for database servers
            }
            catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
            con = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
            System.out.println("Printing connection object "+con);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return con;
    }
}