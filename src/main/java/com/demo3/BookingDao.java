package com.demo3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.lang.System.out;

public class BookingDao
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

    public void addBooking(booking bk) throws SQLException
    {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into booking (branchid,bookingdate,bookingtime,workerid,custid,packageid) values(?,?,?,null,?,?)");)
        {
            preparedStatement.setString(1, bk.getBranchID());
            preparedStatement.setDate(2, bk.getBookingDate());
            preparedStatement.setString(3, bk.getBookingTime());
            preparedStatement.setInt(4, bk.getCustID());
            preparedStatement.setString(5,bk.getPackageID());
            out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {printSQLException(e);}
    }

    public boolean updateBookingCust(booking bk) throws SQLException
    {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE booking set branchid=?,bookingdate=?,bookingtime=?, custid=?, packageid=? where bookingid=?");)
        {
            statement.setString(1, bk.getBranchID());
            statement.setDate(2, bk.getBookingDate());
            statement.setString(3, bk.getBookingTime());
            statement.setInt(4, bk.getCustID());
            statement.setString(5, bk.getPackageID());
            statement.setInt(6, bk.getBookingID());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public boolean updateBookingWorker(booking bk) throws SQLException
    {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE booking set branchid=?,bookingdate=?,bookingtime=?, custid=?, packageid=?, workerid=? where bookingid=?");)
        {
            statement.setString(1, bk.getBranchID());
            statement.setDate(2, bk.getBookingDate());
            statement.setString(3, bk.getBookingTime());
            statement.setInt(4, bk.getCustID());
            statement.setString(5, bk.getPackageID());
            statement.setInt(6, bk.getWorkerID());
            statement.setInt(7, bk.getBookingID());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public boolean deleteBookingCust(int id) throws SQLException
    {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("delete from booking where bookingid=?");)
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
