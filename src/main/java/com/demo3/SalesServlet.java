package com.demo3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "SalesServlet", value = "/SalesServlet")
public class SalesServlet extends HttpServlet {
    private SalesDao sd;
    public void init()
    {
        sd = new SalesDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
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
                case "/edit":
                    /*showEditForm(request, response);*/
                    break;
                case "updatesalesadmin":
                    updateSalesAdmin(request, response);
                    break;
                case "updatesalesworker":
                    updateSalesWorker(request, response);
                    break;
                default:
                    /*listUser(request, response);*/
                    break;
            }
        }
        catch (SQLException ex) {throw new ServletException(ex);}
    }

    /*######################################################( SINGNUP )#############################################################*/

    private void addSalesAdmin(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException
    {
        Date salesdate = Date.valueOf(request.getParameter("salesdate"));
        double saleswalkin = Double.parseDouble(request.getParameter("saleswalkin"));
        double salesbooking = Double.parseDouble(request.getParameter("salesbooking"));
        String branchid = request.getParameter("branchid");
        int adminid = Integer.parseInt(request.getParameter("adminid"));
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


    private void addSalesWorker(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException
    {
        Date salesdate = Date.valueOf(request.getParameter("salesdate"));
        double saleswalkin = Double.parseDouble(request.getParameter("saleswalkin"));
        double salesbooking = Double.parseDouble(request.getParameter("salesbooking"));
        String branchid = request.getParameter("branchid");
        int workerid = Integer.parseInt(request.getParameter("workerid"));
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


    /*######################################################( UPDATE )#############################################################*/

    private void updateSalesAdmin(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException
    {
        HttpSession session = request.getSession();
        int salesid = Integer.parseInt(request.getParameter("salesid"));
        Date salesdate = Date.valueOf(request.getParameter("salesdate"));
        double saleswalkin = Double.parseDouble(request.getParameter("saleswalkin"));
        double salesbooking = Double.parseDouble(request.getParameter("salesbooking"));
        String branchid = request.getParameter("branchid");
        int adminid = Integer.parseInt(request.getParameter("adminid"));
        int workerid = Integer.parseInt(request.getParameter("workerid"));
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


    private void updateSalesWorker(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException
    {
        HttpSession session = request.getSession();
        int salesid = Integer.parseInt(request.getParameter("salesid"));
        Date salesdate = Date.valueOf(request.getParameter("salesdate"));
        double saleswalkin = Double.parseDouble(request.getParameter("saleswalkin"));
        double salesbooking = Double.parseDouble(request.getParameter("salesbooking"));
        String branchid = request.getParameter("branchid");
        int adminid = Integer.parseInt(request.getParameter("adminid"));
        int workerid = Integer.parseInt(request.getParameter("workerid"));
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

    /*######################################################( VIEW )#############################################################*/

    private void viewSalesAdmin(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException
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

    private void viewSalesWorker(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException
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
