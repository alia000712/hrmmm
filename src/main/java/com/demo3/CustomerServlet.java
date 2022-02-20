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
                case "signup":
                    signup(request, response);
                    break;
                case "login":
                    login(request, response);
                    break;
                case "delete":
                    deleteCust(request, response);
                    break;
                case "update":
                    updateCust(request, response);
                    break;
                default:
                    break;
            }
        }
        catch (SQLException ex) {throw new ServletException(ex);}
    }

    /*################################( SIGN UP )#####################################*/

    private void signup(HttpServletRequest request,
    HttpServletResponse response) throws SQLException, IOException
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

    /*################################( LOGIN )#####################################*/

    private void login(HttpServletRequest request,
    HttpServletResponse response) throws SQLException, IOException
    {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        String custusername = request.getParameter("custusername");
        String custpass = request.getParameter("custpass");

        try
        {
            Class.forName("org.postgresql.Driver");
            String dbURL = "jdbc:postgresql://ec2-50-19-32-96.compute-1.amazonaws.com:5432/d65mb698aandvt";
            String user = "ffkacpfvbcmcwa";
            String pass = "3939ef811721250f3db1595eb911cfcbac4e294a582158f13f9ef08dc63786bf";
            Connection conn = DriverManager.getConnection(dbURL, user, pass);

            String sql  ="SELECT * from customer";

            boolean notFound=true;

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
                    if(custusername.equals(res.getString("custusername"))
                            && custpass.equals(res.getString("custpass")))
                    {
                        notFound=false;
                        session.setAttribute("custid",res.getString(1));
                        customer cust = new customer();

                        cust.setCustID(res.getInt(1));
                        cust.setCustName(res.getString(2));
                        cust.setCustPhone(res.getString(3));
                        cust.setCustEmail(res.getString(4));
                        cust.setCustPass(res.getString(5));
                        cust.setCustUsername(res.getString(6));
                        cust.setCustAddress(res.getString(7));

                        session.setAttribute("cust", cust);
                        response.sendRedirect("Customer/Home/custHome.jsp");
                    }
                }

                if(notFound)
                {
                    out.println("<script>alert('User not found');</script>");
                    out.println("<script>window.location.href='cust-createAcc.jsp'</script>");
                }
            }
        }
        catch (Exception e) {e.printStackTrace();}
    }


    /*################################( UPDATE )#####################################*/

    private void updateCust(HttpServletRequest request,
    HttpServletResponse response) throws SQLException, IOException, ServletException
    {
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

    /*################################( DELETE )#####################################*/

    private void deleteCust(HttpServletRequest request,
    HttpServletResponse response) throws SQLException, IOException
    {
        PrintWriter out = response.getWriter();
        int custid = Integer.parseInt(request.getParameter("custid"));

        try
        {
            Class.forName("org.postgresql.Driver"); // ni stay
            String dbURL = "jdbc:postgresql://ec2-50-19-32-96.compute-1.amazonaws.com:5432/d65mb698aandvt";
            String user = "ffkacpfvbcmcwa";
            String pass = "3939ef811721250f3db1595eb911cfcbac4e294a582158f13f9ef08dc63786bf";
            Connection conn = DriverManager.getConnection(dbURL, user, pass);

            String sql  ="select custid from customer except " +
                         "select c.custid from customer c join booking b on (c.custid=b.custid);";

            boolean notDelete = true;

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
                    if(custid==(res.getInt("custid")))
                    {
                        notDelete = false;
                        cd.deleteUser(custid);
                        out.println("<script>alert('User had been deleted');</script>");
                        out.println("<script>window.location.href='Admin/Cust/adminViewCust.jsp'</script>");
                    }
                }
                if(notDelete)
                {
                    out.println("<script>alert('Cannot delete the user because the user is an active user');</script>");
                    out.println("<script>window.location.href='Admin/Cust/adminViewCust.jsp'</script>");
                }
            }
        }
        catch (Exception e) {e.printStackTrace();}
    }
}