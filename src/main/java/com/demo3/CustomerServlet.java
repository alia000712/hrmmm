package com.demo3;

import org.jetbrains.annotations.NotNull;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "CustomerServlet", value = "/CustomerServlet")
public class CustomerServlet extends HttpServlet
{
    private CustomerDao cd;
    public void init()
    {
        cd = new CustomerDao();
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
                case "signup":
                    signup(request, response);
                    break;
                case "login":
                    login(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
                case "/edit":
                    /*showEditForm(request, response);*/
                    break;
                case "update":
                    updateUser(request, response);
                    break;
                default:
                    /*listUser(request, response);*/
                    break;
            }
        }
        catch (SQLException ex) {throw new ServletException(ex);}
    }

    /*######################################################( SINGNUP )#############################################################*/

    private void signup(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException
    {
        String custname = request.getParameter("custname");
        String custphone = request.getParameter("custphone");
        String custemail = request.getParameter("custemail");
        String custpass = request.getParameter("custpass");
        String custusername = request.getParameter("custusername");
        String custaddress = request.getParameter("custaddress");
        customer cust = new customer();

        cust.setCustName(custname);
        cust.setCustPhone(custphone);
        cust.setCustEmail(custemail);
        cust.setCustPass(custpass);
        cust.setCustUsername(custusername);
        cust.setCustAddress(custaddress);

        cd.signup(cust);
        response.sendRedirect("cust-createAcc.jsp");
    }

    /*######################################################( LOGIN )#############################################################*/

    private void login(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
    {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        String custusername = request.getParameter("custusername");
        String custpass = request.getParameter("custpass");

        try
        {
            Class.forName("org.postgresql.Driver"); // ni stay
            String dbURL = "jdbc:postgresql://ec2-3-216-113-109.compute-1.amazonaws.com:5432/d2588ossjegiv9"; //ni url dri heroku database
            String user = "d2588ossjegiv9"; //ni user dri heroku database
            String pass = "ff8e836fb7a630d275b8e9109cb04b91a5fd0937b959cfa509cc007809d6d1b7"; //ni password dri heroku database
            Connection conn = DriverManager.getConnection(dbURL, user, pass);

            String sql  ="SELECT * from customer";

            if (conn != null)
            {
                DatabaseMetaData dm = conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product Name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());


                Statement statement = conn.createStatement();
                ResultSet res = statement.executeQuery(sql);

                while (res.next())
                {
                    if(custusername.equals(res.getString("custusername")) && custpass.equals(res.getString("custpass")))
                    {
                        session.setAttribute("custid",res.getString(1));
                        customer cust = new customer();

                        cust.setCustName(res.getString(2));
                        cust.setCustPhone(res.getString(3));
                        cust.setCustEmail(res.getString(4));
                        cust.setCustPass(res.getString(5));
                        cust.setCustUsername(res.getString(6));
                        cust.setCustAddress(res.getString(7));

                        session.setAttribute("cust", cust);
                        response.sendRedirect("Customer/Home/custHome.jsp");
                    }

                    else
                    {
                        out.println("User not exist");
                    }
                }
            }
        }

        catch (Exception e) {e.printStackTrace();}
    }


    /*######################################################( UPDATE )#############################################################*/

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        HttpSession session = request.getSession();
        int custid = Integer.parseInt(request.getParameter("custid"));
        String custname = request.getParameter("custname");
        String custphone = request.getParameter("custphone");
        String custemail = request.getParameter("custemail");
        String custpass = request.getParameter("custpass");
        String custusername = request.getParameter("custusername");
        String custaddress = request.getParameter("custaddress");
        customer cust = new customer();

        cust.setCustID(custid);
        cust.setCustName(custname);
        cust.setCustPhone(custphone);
        cust.setCustEmail(custemail);
        cust.setCustPass(custpass);
        cust.setCustUsername(custusername);
        cust.setCustAddress(custaddress);

        cd.updateUser(cust);

        session.removeAttribute("cust");
        session.setAttribute("cust", cust);
        response.sendRedirect("Customer/Profile/custViewProfile.jsp");
    }

    /*######################################################( DELETE )#############################################################*/

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
    {
        int custid = Integer.parseInt(request.getParameter("custid"));
        cd.deleteUser(custid);
        response.sendRedirect("index.jsp");
    }
}