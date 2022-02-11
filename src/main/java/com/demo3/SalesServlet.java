package com.demo3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;

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
                case "addsales":
                    addSales(request, response);
                    break;
                case "viewsales":
                    viewSales(request, response);
                    break;
                case "/edit":
                    /*showEditForm(request, response);*/
                    break;
                case "updatesales":
                    updateSales(request, response);
                    break;
                default:
                    /*listUser(request, response);*/
                    break;
            }
        }
        catch (SQLException ex) {throw new ServletException(ex);}
    }

    /*######################################################( SINGNUP )#############################################################*/

    private void addSales(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException
    {
        String salesdate = request.getParameter("salesdate");
        double saleswalkin = Double.parseDouble(request.getParameter("saleswalkin"));
        double salesbooking = Double.parseDouble(request.getParameter("salesbooking"));
        String branchid = request.getParameter("branchid");
        double salesamount = saleswalkin+salesbooking;

        sales sl = new sales();

        sl.setSalesDate(salesdate);
        sl.setSalesWalkin(saleswalkin);
        sl.setSalesBooking(salesbooking);
        sl.setBranchID(branchid);
        sl.setSalesAmount(salesamount);
        sd.addSales(sl);

        response.sendRedirect("Admin/Sales/adminViewSales.jsp");
    }


    /*######################################################( UPDATE )#############################################################*/

    private void updateSales(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException
    {
        HttpSession session = request.getSession();
        int salesid = Integer.parseInt(request.getParameter("salesid"));
        String salesdate = request.getParameter("salesdate");
        double saleswalkin = Double.parseDouble(request.getParameter("saleswalkin"));
        double salesbooking = Double.parseDouble(request.getParameter("salesbooking"));
        String branchid = request.getParameter("branchid");
        double salesamount = saleswalkin+salesbooking;

        sales sl = new sales();

        sl.setSalesID(salesid);
        sl.setSalesDate(salesdate);
        sl.setSalesWalkin(saleswalkin);
        sl.setSalesBooking(salesbooking);
        sl.setBranchID(branchid);
        sl.setSalesAmount(salesamount);

        sd.updateSales(sl);

        session.removeAttribute("sl");
        session.setAttribute("sl",sl);
        response.sendRedirect("Admin/Sales/adminViewSales.jsp");
    }

    /*######################################################( VIEW )#############################################################*/

    private void viewSales(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException
    {
        HttpSession session = request.getSession();
        int salesid = Integer.parseInt(request.getParameter("salesid"));
        String salesdate = request.getParameter("salesdate");
        double saleswalkin = Double.parseDouble(request.getParameter("saleswalkin"));
        double salesbooking = Double.parseDouble(request.getParameter("salesbooking"));
        String branchid = request.getParameter("branchid");
        double salesamount = Double.parseDouble(request.getParameter("salesamount"));
        String branchName= request.getParameter("branchname");

        sales sl = new sales();
        branch br = new branch();

        sl.setSalesID(salesid);
        sl.setSalesDate(salesdate);
        sl.setSalesWalkin(saleswalkin);
        sl.setSalesBooking(salesbooking);
        sl.setBranchID(branchid);
        sl.setSalesAmount(salesamount);
        br.setBranchName(branchName);

        session.setAttribute("sl",sl);
        session.setAttribute("br",br);
        response.sendRedirect("Admin/Sales/adminEditSales.jsp");
    }
}
