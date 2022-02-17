package com.demo3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.lang.System.out;

public class PackageDao
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

    public void addPackage(Package pk) throws SQLException
    {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into package (packageid,packagename,packageprice) values(?,?,?)");)
        {
            preparedStatement.setString(1, pk.getPackageID());
            preparedStatement.setString(2, pk.getPackageName());
            preparedStatement.setDouble(3, pk.getPackagePrice());
            out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {printSQLException(e);}
    }

    public boolean updatePackage(Package pk) throws SQLException
    {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE package set packagename=?,packageprice=? where packageid=?");)
        {
            statement.setString(1, pk.getPackageName());
            statement.setDouble(2, pk.getPackagePrice());
            statement.setString(3, pk.getPackageID());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public boolean deletePackage(String id) throws SQLException
    {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("delete from package where packageid=?");)
        {
            statement.setString(1, id);
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
