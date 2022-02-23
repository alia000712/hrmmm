package com.demo3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.time.LocalDate;

@WebServlet(name = "BookingServlet", value = "/BookingServlet")
public class BookingServlet extends HttpServlet
{
    private BookingDao bkd;
    public void init()
    {
        bkd = new BookingDao();
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
                case "addbooking":
                    addBooking(request, response);
                    break;
                case "viewcust":
                    viewBookingCust(request, response);
                    break;
                case "viewworker":
                    viewBookingWorker(request, response);
                    break;
                case "deletecust":
                    deleteBookingCust(request, response);
                    break;
                case "updatecust":
                    updateBookingCust(request, response);
                    break;
                case "updateworker":
                    updateBookingWorker(request, response);
                    break;
                case "printcust":
                    printBooking(request, response);
                    break;
                default:
                    break;
            }
        }
        catch (SQLException ex) {throw new ServletException(ex);}
    }

    /*################################( ADD BOOKING )#####################################*/

    private void addBooking(HttpServletRequest request,
    HttpServletResponse response) throws SQLException, IOException
    {
        PrintWriter out = response.getWriter();
        String branchid = request.getParameter("branchid");
        LocalDate bookingdate2 = LocalDate.parse(request.getParameter("bookingdate"));
        Date bookingdate = Date.valueOf(request.getParameter("bookingdate"));
        String bookingtime =request.getParameter("bookingtime");
        int custid = Integer.parseInt(request.getParameter("custid"));
        String packageid = request.getParameter("packageid");
        booking bk = new booking();

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


                String sql  ="select branchid,count(bookingdate),bookingdate from booking " +
                        "group by bookingdate,branchid having count(bookingdate)>=8;";
                Statement statement = conn.createStatement();
                ResultSet res = statement.executeQuery(sql);


                if(bookingdate2.compareTo(java.time.LocalDate.now())>=2)
                {
                    while(res.next())
                    {
                        if(bookingdate.equals(res.getDate("bookingdate")) &&
                                branchid.equals(res.getString("branchid")))
                        {
                            out.println("<script>alert('Booking already full at chosen date and chosen branch.Please choose another date or another branch');</script>");
                            out.println("<script>window.location.href='Customer/Booking/custAddBooking.jsp'</script>");
                        }
                        else
                        {
                            bk.setBranchID(branchid);
                            bk.setBookingDate(bookingdate);
                            bk.setBookingTime(bookingtime);
                            bk.setCustID(custid);
                            bk.setPackageID(packageid);

                            bkd.addBooking(bk);
                            response.sendRedirect("Customer/Booking/custViewBooking.jsp");
                        }
                    }
                }
                else
                {
                    out.println("<script>alert('Please select at least two days early from current date to make a booking.');</script>");
                    out.println("<script>window.location.href='Customer/Booking/custAddBooking.jsp'</script>");
                }
            }
        }
        catch (Exception e) {e.printStackTrace();}
    }

    /*################################( UPDATE BOOKING )#####################################*/

    private void updateBookingCust(HttpServletRequest request,
    HttpServletResponse response) throws SQLException, IOException, ServletException
    {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String branchid = request.getParameter("branchid");
        LocalDate bookingdate2 = LocalDate.parse(request.getParameter("bookingdate"));
        Date bookingdate = Date.valueOf(request.getParameter("bookingdate"));
        String bookingtime =request.getParameter("bookingtime");
        int custid = Integer.parseInt(request.getParameter("custid"));
        String packageid = request.getParameter("packageid");
        int bookingid = Integer.parseInt(request.getParameter("bookingid"));
        booking bk = new booking();

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


                String sql  ="select branchid,count(bookingdate),bookingdate from booking " +
                        "group by bookingdate,branchid having count(bookingdate)>=8;";

                Statement statement = conn.createStatement();
                ResultSet res = statement.executeQuery(sql);

                if(bookingdate2.compareTo(java.time.LocalDate.now())>=2)
                {
                    while(res.next())
                    {
                        if(bookingdate.equals(res.getDate("bookingdate")) &&
                                branchid.equals(res.getString("branchid")))
                        {
                            out.println("<script>alert('Booking already full at chosen date and chosen branch.Please choose another date or another branch');</script>");
                            out.println("<script>window.location.href='Customer/Booking/custEditBooking.jsp'</script>");
                        }
                        else
                        {
                            bk.setBranchID(branchid);
                            bk.setBookingDate(bookingdate);
                            bk.setBookingTime(bookingtime);
                            bk.setCustID(custid);
                            bk.setPackageID(packageid);
                            bk.setBookingID(bookingid);

                            bkd.updateBookingCust(bk);

                            session.removeAttribute("bk");
                            session.setAttribute("bk",bk);
                            response.sendRedirect("Customer/Booking/custViewBooking.jsp");
                        }
                    }
                }
                else
                {
                    out.println("<script>alert('Please select at least two days early from current date to make a booking.');</script>");
                    out.println("<script>window.location.href='Customer/Booking/custEditBooking.jsp'</script>");
                }


            }
        }
        catch (Exception e) {e.printStackTrace();}
    }

    private void updateBookingWorker(HttpServletRequest request,
    HttpServletResponse response) throws SQLException, IOException, ServletException
    {
        HttpSession session = request.getSession();
        String branchid = request.getParameter("branchid");
        Date bookingdate = Date.valueOf(request.getParameter("bookingdate"));
        String bookingtime =request.getParameter("bookingtime");
        int custid = Integer.parseInt(request.getParameter("custid"));
        String packageid = request.getParameter("packageid");
        int bookingid = Integer.parseInt(request.getParameter("bookingid"));
        int workerid = Integer.parseInt(request.getParameter("workerid"));
        booking bk = new booking();

        bk.setBranchID(branchid);
        bk.setBookingDate(bookingdate);
        bk.setBookingTime(bookingtime);
        bk.setCustID(custid);
        bk.setPackageID(packageid);
        bk.setWorkerID(workerid);
        bk.setBookingID(bookingid);

        bkd.updateBookingWorker(bk);

        session.removeAttribute("bk");
        session.setAttribute("bk",bk);
        response.sendRedirect("Worker/Booking/workerViewBooking.jsp");
    }

    /*################################( VIEW BOOKING )#####################################*/

    private void viewBookingCust(HttpServletRequest request,
    HttpServletResponse response) throws SQLException, IOException, ServletException
    {
        HttpSession session = request.getSession();
        String branchid = request.getParameter("branchid");
        Date bookingdate = Date.valueOf(request.getParameter("bookingdate"));
        String bookingtime =request.getParameter("bookingtime");
        int custid = Integer.parseInt(request.getParameter("custid"));
        String packageid = request.getParameter("packageid");
        int bookingid = Integer.parseInt(request.getParameter("bookingid"));

        String branchname = request.getParameter("branchname");
        String packagename = request.getParameter("packagename");

        booking bk = new booking();
        branch br = new branch();
        Package pk = new Package();

        bk.setBranchID(branchid);
        bk.setBookingDate(bookingdate);
        bk.setBookingTime(bookingtime);
        bk.setCustID(custid);
        bk.setPackageID(packageid);
        bk.setBookingID(bookingid);
        br.setBranchName(branchname);
        pk.setPackageName(packagename);

        session.setAttribute("bk",bk);
        session.setAttribute("br",br);
        session.setAttribute("pk",pk);
        response.sendRedirect("Customer/Booking/custEditBooking.jsp");
    }

    /*################################( VIEW BOOKING )#####################################*/

    private void viewBookingWorker(HttpServletRequest request,
    HttpServletResponse response) throws SQLException, IOException, ServletException
    {
        HttpSession session = request.getSession();
        String branchid = request.getParameter("branchid");
        Date bookingdate = Date.valueOf(request.getParameter("bookingdate"));
        String bookingtime =request.getParameter("bookingtime");
        int custid = Integer.parseInt(request.getParameter("custid"));
        String packageid = request.getParameter("packageid");
        int bookingid = Integer.parseInt(request.getParameter("bookingid"));

        String branchname = request.getParameter("branchname");
        String packagename = request.getParameter("packagename");

        booking bk = new booking();
        branch br = new branch();
        Package pk = new Package();

        bk.setBranchID(branchid);
        bk.setBookingDate(bookingdate);
        bk.setBookingTime(bookingtime);
        bk.setCustID(custid);
        bk.setPackageID(packageid);
        bk.setBookingID(bookingid);
        br.setBranchName(branchname);
        pk.setPackageName(packagename);

        session.setAttribute("bk",bk);
        session.setAttribute("br",br);
        session.setAttribute("pk",pk);
        response.sendRedirect("Worker/Booking/workerEditBooking.jsp");
    }

    private void printBooking(HttpServletRequest request,
    HttpServletResponse response) throws SQLException, IOException, ServletException
    {
        HttpSession session = request.getSession();
        String branchid = request.getParameter("branchid");
        Date bookingdate = Date.valueOf(request.getParameter("bookingdate"));
        String bookingtime =request.getParameter("bookingtime");
        int custid = Integer.parseInt(request.getParameter("custid"));
        String packageid = request.getParameter("packageid");
        double packageprice = Double.parseDouble(request.getParameter("packageprice"));
        String packagename = request.getParameter("packagename");
        int bookingid = Integer.parseInt(request.getParameter("bookingid"));
        int workerid = Integer.parseInt(request.getParameter("workerid"));
        String branchname = request.getParameter("branchname");

        booking bk = new booking();
        branch br = new branch();
        Package pk = new Package();

        bk.setBranchID(branchid);
        bk.setBookingDate(bookingdate);
        bk.setBookingTime(bookingtime);
        bk.setCustID(custid);
        bk.setPackageID(packageid);
        bk.setBookingID(bookingid);
        bk.setWorkerID(workerid);
        br.setBranchName(branchname);
        pk.setPackageName(packagename);
        pk.setPackagePrice(packageprice);

        session.setAttribute("bk",bk);
        session.setAttribute("br",br);
        session.setAttribute("pk",pk);
        response.sendRedirect("Customer/Booking/custBookingPrint.jsp");
    }

    /*################################( DELETE BOOKING )#####################################*/

    private void deleteBookingCust(HttpServletRequest request,
    HttpServletResponse response) throws SQLException, IOException
    {
        int bookingid = Integer.parseInt(request.getParameter("bookingid"));
        bkd.deleteBookingCust(bookingid);
        response.sendRedirect("Customer/Booking/custViewBooking.jsp");
    }
}
