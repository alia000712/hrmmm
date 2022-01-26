package com.demo3.dao;

import com.demo3.util.DBconnection;
import com.demo3.bean.branch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddBranchDao
{
    public AddBranchDao() {}

    public String registerBranch(branch addbr)
    {
        String branchID = addbr.getBranchID();
        String branchName = addbr.getBranchName();
        String branchAddress = addbr.getBranchAddress();
        String branchPhone = addbr.getBranchPhone();
        int numOfWorker = addbr.getNumOfWorker();

        Connection con = null;
        PreparedStatement preparedStatement = null;
        try
        {
            con = DBconnection.createConnection();
            String query = "insert into branch(branchID,branchName,branchAddress,branchPhone,numOfWorker)" +
                    " values (?,?,?,?,?)"; //Insert user details into the table 'USERS'
            preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
            preparedStatement.setString(1, branchID);
            preparedStatement.setString(2, branchName);
            preparedStatement.setString(3, branchAddress);
            preparedStatement.setString(4, branchPhone);
            preparedStatement.setInt(5, numOfWorker);

            int i= preparedStatement.executeUpdate();

            if (i!=0)  //Just to ensure data has been inserted into the database
                return "SUCCESS";
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
    }
}