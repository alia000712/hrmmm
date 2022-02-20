package com.demo3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "AdminServlet", value = "/AdminServlet")
public class AdminServlet extends HttpServlet {
    private AdminDao ad;
    public void init()
    {
        ad = new AdminDao();
    }

    protected void doGet(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {}

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
                case "login":
                    login(request, response);
                    break;
                case "update":
                    updateAdmin(request, response);
                    break;
                default:
                    break;
            }
        }
        catch (SQLException ex) {throw new ServletException(ex);}
    }

    /*################################( LOGIN )#####################################*/

    private void login(HttpServletRequest request,
    HttpServletResponse response) throws SQLException, IOException
    {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        String adminusername = request.getParameter("adminusername");
        String adminpass = request.getParameter("adminpass");

        try
        {
            Class.forName("org.postgresql.Driver");
            String dbURL = "jdbc:postgresql://ec2-50-19-32-96.compute-1.amazonaws.com:5432/d65mb698aandvt";
            String user = "ffkacpfvbcmcwa";
            String pass = "3939ef811721250f3db1595eb911cfcbac4e294a582158f13f9ef08dc63786bf";
            Connection conn = DriverManager.getConnection(dbURL, user, pass);

            String sql  ="SELECT * from admin";

            boolean notFound = true;

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
                    if(adminusername.equals(res.getString("adminusername")) &&
                            adminpass.equals(res.getString("adminpass")))
                    {
                        notFound = false;
                        session.setAttribute("adminid",res.getInt(1));
                        admin adm = new admin();

                        adm.setAdminID(res.getInt(1));
                        adm.setAdminPass(res.getString(2));
                        adm.setAdminUsername(res.getString(3));

                        session.setAttribute("adm", adm);
                        response.sendRedirect("Admin/Home/adminHome.jsp");
                    }
                }

                if(notFound)
                {
                    out.println("<script>alert('User not found');</script>");
                    out.println("<script>window.location.href='admin-createAcc.jsp'</script>");
                }
            }
        }
        catch (Exception e) {e.printStackTrace();}
    }

    /*################################( UPDATE )#####################################*/

    private void updateAdmin(HttpServletRequest request,
    HttpServletResponse response) throws SQLException, IOException, ServletException
    {
        HttpSession session = request.getSession();
        int adminid = Integer.parseInt(request.getParameter("adminid"));
        String adminpass = request.getParameter("adminpass");
        String adminusername = request.getParameter("adminusername");
        admin adm = new admin();

        adm.setAdminID(adminid);
        adm.setAdminPass(adminpass);
        adm.setAdminUsername(adminusername);

        ad.updateAdmin(adm);

        session.removeAttribute("adm");
        session.setAttribute("adm", adm);
        response.sendRedirect("Admin/Profile/adminViewProfile.jsp");
    }
}
