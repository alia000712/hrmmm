package com.demo3;

import javax.servlet.http.HttpSession;
import java.sql.*;
import static java.lang.System.out;

public class CustomerDao
{

    String dbURL = "jdbc:postgresql://ec2-50-19-32-96.compute-1.amazonaws.com:5432/d65mb698aandvt"; //ni url dri heroku database
    String user = "ffkacpfvbcmcwa";
    String pass = "3939ef811721250f3db1595eb911cfcbac4e294a582158f13f9ef08dc63786bf";

    protected Connection getConnection()
    {
        Connection connection = null;
        try
        {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(dbURL, user, pass);
        }
        catch (SQLException e) {e.printStackTrace();}
        catch (ClassNotFoundException e) {e.printStackTrace();}
        return connection;
    }

    public void signup (customer cust) throws SQLException
    {
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into customer (custName,custPhone,custEmail,custPass,custUsername,custAddress) values(?,?,?,?,?,?)");)
        {
            preparedStatement.setString(1, cust.getCustName());
            preparedStatement.setString(2, cust.getCustPhone());
            preparedStatement.setString(3, cust.getCustEmail());
            preparedStatement.setString(4, cust.getCustPass());
            preparedStatement.setString(5, cust.getCustUsername());
            preparedStatement.setString(6, cust.getCustAddress());
            out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {printSQLException(e);}
    }

    public boolean updateUser(customer cust) throws SQLException
    {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE student set custName=?,custPhone=?,custEmail=?,custPass=?,custUsername=?,custAddress=? where custID=?");)
        {
            statement.setString(1, cust.getCustName());
            statement.setString(2, cust.getCustPhone());
            statement.setString(3, cust.getCustEmail());
            statement.setString(4, cust.getCustPass());
            statement.setString(5, cust.getCustUsername());
            statement.setString(6, cust.getCustAddress());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public boolean deleteUser(int id) throws SQLException
    {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("delete from customer where custID=?");)
        {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    private void printSQLException(SQLException ex)
    {
        for (Throwable e : ex)
        {
            if (e instanceof SQLException)
            {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null)
                {
                    out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}