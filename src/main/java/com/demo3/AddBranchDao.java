package com.demo3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddBranchDao
{
    public String registerBranch(AddBranch addbr)
    {
        String branchName = addbr.getBranchName();
        String branchID = addbr.getBranchID();
        String branchAddress = addbr.getBranchAddress();
        String branchPhone = addbr.getBranchPhone();
        int numOfWorker = addbr.getNumOfWorker();

        Connection con = null;
        PreparedStatement preparedStatement = null;
        try
        {
            con = DBConnection.createConnection();
            String query = "insert into branch(branchName,branchID,branchAddress,branchPhone,numOfWorker)" +
                           " values (?,?,?,?,?)"; //Insert user details into the table 'USERS'
            preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
            preparedStatement.setString(1, branchName);
            preparedStatement.setString(2, branchID);
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