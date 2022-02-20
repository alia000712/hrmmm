package com.demo3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

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
                case "delete":
                    deleteBooking(request, response);
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
        String branchid = request.getParameter("branchid");
        Date bookingdate = Date.valueOf(request.getParameter("bookingdate"));
        String bookingtime =request.getParameter("bookingtime");
        int custid = Integer.parseInt(request.getParameter("custid"));
        String packageid = request.getParameter("packageid");
        booking bk = new booking();

        bk.setBranchID(branchid);
        bk.setBookingDate(bookingdate);
        bk.setBookingTime(bookingtime);
        bk.setCustID(custid);
        bk.setPackageID(packageid);

        bkd.addBooking(bk);
        response.sendRedirect("Customer/Booking/custViewBooking.jsp");
    }

    /*################################( UPDATE BOOKING )#####################################*/

    private void updateBookingCust(HttpServletRequest request,
    HttpServletResponse response) throws SQLException, IOException, ServletException
    {
        HttpSession session = request.getSession();
        String branchid = request.getParameter("branchid");
        Date bookingdate = Date.valueOf(request.getParameter("bookingdate"));
        String bookingtime =request.getParameter("bookingtime");
        int custid = Integer.parseInt(request.getParameter("custid"));
        String packageid = request.getParameter("packageid");
        int bookingid = Integer.parseInt(request.getParameter("bookingid"));
        booking bk = new booking();

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

    private void deleteBooking(HttpServletRequest request,
    HttpServletResponse response) throws SQLException, IOException
    {
        int bookingid = Integer.parseInt(request.getParameter("bookingid"));
        bkd.deleteBookingCust(bookingid);
        response.sendRedirect("Customer/Booking/custViewBooking.jsp");
    }
}
