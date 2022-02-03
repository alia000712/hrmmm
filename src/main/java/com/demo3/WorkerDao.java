package com.demo3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.lang.System.out;

public class WorkerDao
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

    public void register(worker wk) throws SQLException
    {
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into worker (workername,workeremail,workeraddress,workeric,branchid,workerphone) values(?,?,?,?,?,?)");)
        {
            preparedStatement.setString(1, wk.getWorkerName());
            preparedStatement.setString(2, wk.getWorkerEmail());
            preparedStatement.setString(3, wk.getWorkerAddress());
            preparedStatement.setString(4, wk.getWorkerIC());
            preparedStatement.setString(5, wk.getBranchID());
            preparedStatement.setString(6, wk.getWorkerPhone());
            out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {printSQLException(e);}
    }

    public boolean updateWorker(worker wk) throws SQLException
    {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE worker set workername=?,workeremail=?,workeraddress=?, workeric=?,branchid=?,workerphone=? where workerid=?");)
        {
            statement.setString(1, wk.getWorkerName());
            statement.setString(2, wk.getWorkerEmail());
            statement.setString(3, wk.getWorkerAddress());
            statement.setString(4, wk.getWorkerIC());
            statement.setString(5, wk.getBranchID());
            statement.setString(6, wk.getWorkerPhone());
            statement.setInt(7, wk.getWorkerID());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public boolean deleteWorker(int id) throws SQLException
    {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("delete from worker where workerid=?");)
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
