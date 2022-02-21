package com.demo3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.time.LocalDate;

@WebServlet(name = "SalesServlet", value = "/SalesServlet")
public class SalesServlet extends HttpServlet {
    private SalesDao sd;
    public void init()
    {
        sd = new SalesDao();
    }

    @Override
    protected void doGet(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {}

    @Override
    protected void doPost(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");
        try
        {
            switch (action)
            {
                case "addsalesadmin":
                    addSalesAdmin(request, response);
                    break;
                case "addsalesworker":
                    addSalesWorker(request, response);
                    break;
                case "viewsalesadmin":
                    viewSalesAdmin(request, response);
                    break;
                case "viewsalesworker":
                    viewSalesWorker(request, response);
                    break;
                case "updatesalesadmin":
                    updateSalesAdmin(request, response);
                    break;
                case "updatesalesworker":
                    updateSalesWorker(request, response);
                    break;
                default:
                    break;
            }
        }
        catch (SQLException ex) {throw new ServletException(ex);}
    }

    /*################################( ADD SALES )#####################################*/

    private void addSalesAdmin(HttpServletRequest request,
    HttpServletResponse response) throws SQLException, IOException
    {
        PrintWriter out = response.getWriter();
        int adminid = Integer.parseInt(request.getParameter("adminid"));
        LocalDate bookingdate = LocalDate.parse(request.getParameter("salesdate"));
        Date salesdate = Date.valueOf(request.getParameter("salesdate"));
        double saleswalkin = Double.parseDouble(request.getParameter("saleswalkin"));
        String branchid = request.getParameter("branchid");

        try
        {
            Class.forName("org.postgresql.Driver");
            String dbURL = "jdbc:postgresql://ec2-50-19-32-96.compute-1.amazonaws.com:5432/d65mb698aandvt"; //ni url dri heroku database
            String user = "ffkacpfvbcmcwa";
            String pass = "3939ef811721250f3db1595eb911cfcbac4e294a582158f13f9ef08dc63786bf"; //ni password dri heroku database
            Connection conn = DriverManager.getConnection(dbURL, user, pass);

            if (conn != null)
            {
                DatabaseMetaData dm = conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product Name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());

                String sql  ="select b.bookingdate,b.branchid, sum(pk.packageprice) as packageprice " +
                        "from booking b join package pk on (b.packageid=pk.packageid) " +
                        "where b.workerid is not null " +
                        "group by b.bookingdate,b.branchid " +
                        "order by b.bookingdate;";

                Statement statement = conn.createStatement();
                ResultSet res = statement.executeQuery(sql);

                while(res.next())
                {
                    if(bookingdate.equals(LocalDate.parse(res.getString("bookingdate"))) &&
                            branchid.equals(res.getString("branchid")))
                    {
                        double salesbooking = res.getDouble("packageprice");
                        double salesamount = saleswalkin+salesbooking;

                        sales sl = new sales();

                        sl.setSalesDate(salesdate);
                        sl.setSalesWalkin(saleswalkin);
                        sl.setSalesBooking(salesbooking);
                        sl.setBranchID(branchid);
                        sl.setSalesAmount(salesamount);
                        sl.setAdminID(adminid);
                        sd.addSalesAdmin(sl);

                        response.sendRedirect("Admin/Sales/adminViewSales.jsp");
                    }
                    else
                    {
                        out.println("<script>alert('Cannot  insert sales.');</script>");
                        out.println("<script>window.location.href='Admin/Sales/adminViewSales.jsp'</script>");
                    }
                }
            }
        }
        catch (Exception e) {e.printStackTrace();}
    }

    /*################################( ADD SALES )#####################################*/

    private void addSalesWorker(HttpServletRequest request,
    HttpServletResponse response) throws SQLException, IOException
    {
        PrintWriter out = response.getWriter();
        LocalDate bookingdate = LocalDate.parse(request.getParameter("salesdate"));
        Date salesdate = Date.valueOf(request.getParameter("salesdate"));
        double saleswalkin = Double.parseDouble(request.getParameter("saleswalkin"));
        String branchid = request.getParameter("branchid");
        int workerid = Integer.parseInt(request.getParameter("workerid"));

        try
        {
            Class.forName("org.postgresql.Driver");
            String dbURL = "jdbc:postgresql://ec2-50-19-32-96.compute-1.amazonaws.com:5432/d65mb698aandvt"; //ni url dri heroku database
            String user = "ffkacpfvbcmcwa";
            String pass = "3939ef811721250f3db1595eb911cfcbac4e294a582158f13f9ef08dc63786bf"; //ni password dri heroku database
            Connection conn = DriverManager.getConnection(dbURL, user, pass);

            if (conn != null)
            {
                DatabaseMetaData dm = conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product Name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());

                String sql  ="select b.bookingdate,b.branchid, sum(pk.packageprice) as packageprice " +
                        "from booking b join package pk on (b.packageid=pk.packageid) " +
                        "where b.workerid is not null " +
                        "group by b.bookingdate,b.branchid " +
                        "order by b.bookingdate;";

                Statement statement = conn.createStatement();
                ResultSet res = statement.executeQuery(sql);

                while(res.next())
                {
                    if(bookingdate.equals(LocalDate.parse(res.getString("bookingdate"))) &&
                            branchid.equals(res.getString("branchid")))
                    {
                        double salesbooking = res.getDouble("packageprice");
                        double salesamount = saleswalkin+salesbooking;

                        sales sl = new sales();

                        sl.setSalesDate(salesdate);
                        sl.setSalesWalkin(saleswalkin);
                        sl.setSalesBooking(salesbooking);
                        sl.setBranchID(branchid);
                        sl.setSalesAmount(salesamount);
                        sl.setWorkerID(workerid);
                        sd.addSalesWorker(sl);

                        response.sendRedirect("Worker/Sales/workerViewSales.jsp");
                    }
                    else
                    {
                        out.println("<script>alert('Cannot  insert sales.');</script>");
                        out.println("<script>window.location.href='Worker/Sales/workerViewSales.jsp'</script>");
                    }
                }
            }
        }
        catch (Exception e) {e.printStackTrace();}
    }

    /*################################( UPDATE SALES )#####################################*/

    private void updateSalesAdmin(HttpServletRequest request,
    HttpServletResponse response) throws SQLException, IOException, ServletException
    {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        int salesid = Integer.parseInt(request.getParameter("salesid"));
        LocalDate bookingdate = LocalDate.parse(request.getParameter("salesdate"));
        Date salesdate = Date.valueOf(request.getParameter("salesdate"));
        double saleswalkin = Double.parseDouble(request.getParameter("saleswalkin"));
        String branchid = request.getParameter("branchid");
        int adminid = Integer.parseInt(request.getParameter("adminid"));
        int workerid = Integer.parseInt(request.getParameter("workerid"));

        try
        {
            Class.forName("org.postgresql.Driver");
            String dbURL = "jdbc:postgresql://ec2-50-19-32-96.compute-1.amazonaws.com:5432/d65mb698aandvt"; //ni url dri heroku database
            String user = "ffkacpfvbcmcwa";
            String pass = "3939ef811721250f3db1595eb911cfcbac4e294a582158f13f9ef08dc63786bf"; //ni password dri heroku database
            Connection conn = DriverManager.getConnection(dbURL, user, pass);

            if (conn != null)
            {
                DatabaseMetaData dm = conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product Name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());

                String sql  ="select b.bookingdate,b.branchid, sum(pk.packageprice) as packageprice " +
                        "from booking b join package pk on (b.packageid=pk.packageid) " +
                        "where b.workerid is not null " +
                        "group by b.bookingdate,b.branchid " +
                        "order by b.bookingdate;";

                Statement statement = conn.createStatement();
                ResultSet res = statement.executeQuery(sql);

                while(res.next())
                {
                    if(bookingdate.equals(LocalDate.parse(res.getString("bookingdate"))) &&
                            branchid.equals(res.getString("branchid")))
                    {
                        double salesbooking = res.getDouble("packageprice");
                        double salesamount = saleswalkin+salesbooking;

                        sales sl = new sales();

                        sl.setSalesID(salesid);
                        sl.setSalesDate(salesdate);
                        sl.setSalesWalkin(saleswalkin);
                        sl.setSalesBooking(salesbooking);
                        sl.setBranchID(branchid);
                        sl.setAdminID(adminid);
                        sl.setWorkerID(workerid);
                        sl.setSalesAmount(salesamount);

                        sd.updateSalesAdmin(sl);

                        session.removeAttribute("sl");
                        session.setAttribute("sl",sl);
                        response.sendRedirect("Admin/Sales/adminViewSales.jsp");
                    }
                    else
                    {
                        out.println("<script>alert('Cannot update sales.');</script>");
                        out.println("<script>window.location.href='Admin/Sales/adminViewSales.jsp'</script>");
                    }
                }
            }
        }
        catch (Exception e) {e.printStackTrace();}
    }

    /*################################( UPDATE SALES )#####################################*/

    private void updateSalesWorker(HttpServletRequest request,
    HttpServletResponse response) throws SQLException, IOException, ServletException
    {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        int salesid = Integer.parseInt(request.getParameter("salesid"));
        LocalDate bookingdate = LocalDate.parse(request.getParameter("salesdate"));
        Date salesdate = Date.valueOf(request.getParameter("salesdate"));
        double saleswalkin = Double.parseDouble(request.getParameter("saleswalkin"));
        String branchid = request.getParameter("branchid");
        int adminid = Integer.parseInt(request.getParameter("adminid"));
        int workerid = Integer.parseInt(request.getParameter("workerid"));

        try
        {
            Class.forName("org.postgresql.Driver");
            String dbURL = "jdbc:postgresql://ec2-50-19-32-96.compute-1.amazonaws.com:5432/d65mb698aandvt"; //ni url dri heroku database
            String user = "ffkacpfvbcmcwa";
            String pass = "3939ef811721250f3db1595eb911cfcbac4e294a582158f13f9ef08dc63786bf"; //ni password dri heroku database
            Connection conn = DriverManager.getConnection(dbURL, user, pass);

            if (conn != null)
            {
                DatabaseMetaData dm = conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product Name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());

                String sql  ="select b.bookingdate,b.branchid, sum(pk.packageprice) as packageprice " +
                        "from booking b join package pk on (b.packageid=pk.packageid) " +
                        "where b.workerid is not null " +
                        "group by b.bookingdate,b.branchid " +
                        "order by b.bookingdate;";

                Statement statement = conn.createStatement();
                ResultSet res = statement.executeQuery(sql);

                while(res.next())
                {
                    if(bookingdate.equals(LocalDate.parse(res.getString("bookingdate"))) &&
                            branchid.equals(res.getString("branchid")))
                    {
                        double salesbooking = res.getDouble("packageprice");
                        double salesamount = saleswalkin+salesbooking;

                        sales sl = new sales();

                        sl.setSalesID(salesid);
                        sl.setSalesDate(salesdate);
                        sl.setSalesWalkin(saleswalkin);
                        sl.setSalesBooking(salesbooking);
                        sl.setBranchID(branchid);
                        sl.setAdminID(adminid);
                        sl.setWorkerID(workerid);
                        sl.setSalesAmount(salesamount);

                        sd.updateSalesWorker(sl);

                        session.removeAttribute("sl");
                        session.setAttribute("sl",sl);
                        response.sendRedirect("Worker/Sales/workerViewSales.jsp");
                    }
                    else
                    {
                        out.println("<script>alert('Cannot update sales.');</script>");
                        out.println("<script>window.location.href='Worker/Sales/workerViewSales.jsp'</script>");
                    }
                }
            }
        }
        catch (Exception e) {e.printStackTrace();}
    }

    /*################################( VIEW SALES )#####################################*/

    private void viewSalesAdmin(HttpServletRequest request,
    HttpServletResponse response) throws SQLException, IOException, ServletException
    {
        HttpSession session = request.getSession();

        int salesid = Integer.parseInt(request.getParameter("salesid"));
        Date salesdate = Date.valueOf(request.getParameter("salesdate"));
        double saleswalkin = Double.parseDouble(request.getParameter("saleswalkin"));
        double salesbooking = Double.parseDouble(request.getParameter("salesbooking"));
        String branchid = request.getParameter("branchid");
        double salesamount = Double.parseDouble(request.getParameter("salesamount"));
        int adminid = Integer.parseInt(request.getParameter("adminid"));
        int workerid = Integer.parseInt(request.getParameter("workerid"));
        String branchName= request.getParameter("branchname");

        sales sl = new sales();
        branch br = new branch();

        sl.setSalesID(salesid);
        sl.setSalesDate(salesdate);
        sl.setSalesWalkin(saleswalkin);
        sl.setSalesBooking(salesbooking);
        sl.setBranchID(branchid);
        sl.setAdminID(adminid);
        sl.setSalesAmount(salesamount);
        sl.setWorkerID(workerid);
        br.setBranchName(branchName);

        session.setAttribute("sl",sl);
        session.setAttribute("br",br);
        response.sendRedirect("Admin/Sales/adminEditSales.jsp");
    }

    /*################################( VIEW SALES )#####################################*/

    private void viewSalesWorker(HttpServletRequest request,
    HttpServletResponse response) throws SQLException, IOException, ServletException
    {
        HttpSession session = request.getSession();

        int salesid = Integer.parseInt(request.getParameter("salesid"));
        Date salesdate = Date.valueOf(request.getParameter("salesdate"));
        double saleswalkin = Double.parseDouble(request.getParameter("saleswalkin"));
        double salesbooking = Double.parseDouble(request.getParameter("salesbooking"));
        String branchid = request.getParameter("branchid");
        double salesamount = Double.parseDouble(request.getParameter("salesamount"));
        int adminid = Integer.parseInt(request.getParameter("adminid"));
        int workerid = Integer.parseInt(request.getParameter("workerid"));

        sales sl = new sales();

        sl.setSalesID(salesid);
        sl.setSalesDate(salesdate);
        sl.setSalesWalkin(saleswalkin);
        sl.setSalesBooking(salesbooking);
        sl.setBranchID(branchid);
        sl.setAdminID(adminid);
        sl.setSalesAmount(salesamount);
        sl.setWorkerID(workerid);

        session.setAttribute("sl",sl);
        response.sendRedirect("Worker/Sales/workerEditSales.jsp");
    }
}
