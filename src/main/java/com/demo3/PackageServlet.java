package com.demo3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "PackageServlet", value = "/PackageServlet")
public class PackageServlet extends HttpServlet
{
    private PackageDao pd;
    public void init()
    {
        pd = new PackageDao();
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
                case "add":
                    addPackage(request, response);
                    break;
                case "view":
                    viewPackage(request, response);
                    break;
                case "delete":
                    deletePackage(request, response);
                    break;
                case "edit":
                    updatePackage(request, response);
                    break;
                default:
                    break;
            }
        }
        catch (SQLException ex) {throw new ServletException(ex);}
    }

    /*################################( ADD PACKAGE )#####################################*/

    private void addPackage(HttpServletRequest request,
    HttpServletResponse response) throws SQLException, IOException
    {
        String packageid = request.getParameter("packageid");
        String packagename = request.getParameter("packagename");
        double packageprice = Double.parseDouble(request.getParameter("packageprice"));
        Package pk = new Package();

        pk.setPackageID(packageid);
        pk.setPackageName(packagename);
        pk.setPackagePrice(packageprice);

        pd.addPackage(pk);
        response.sendRedirect("Admin/Package/adminViewPackage.jsp");
    }


    /*################################( UPDATE PACKAGE )#####################################*/

    private void updatePackage(HttpServletRequest request,
    HttpServletResponse response) throws SQLException, IOException, ServletException
    {
        HttpSession session = request.getSession();
        String packageid = request.getParameter("packageid");
        String packagename = request.getParameter("packagename");
        double packageprice = Double.parseDouble(request.getParameter("packageprice"));
        Package pk = new Package();

        pk.setPackageID(packageid);
        pk.setPackageName(packagename);
        pk.setPackagePrice(packageprice);

        pd.updatePackage(pk);

        session.removeAttribute("pk");
        session.setAttribute("pk",pk);
        response.sendRedirect("Admin/Package/adminViewPackageDetail.jsp");
    }

    /*################################( VIEW PACKAGE )#####################################*/

    private void viewPackage(HttpServletRequest request,
    HttpServletResponse response) throws SQLException, IOException, ServletException
    {
        HttpSession session = request.getSession();
        String packageid = request.getParameter("packageid");
        String packagename = request.getParameter("packagename");
        double packageprice = Double.parseDouble(request.getParameter("packageprice"));
        Package pk = new Package();

        pk.setPackageID(packageid);
        pk.setPackageName(packagename);
        pk.setPackagePrice(packageprice);

        session.setAttribute("pk",pk);
        response.sendRedirect("Admin/Package/adminViewPackageDetail.jsp");
    }

    /*################################( DELETE PACKAGE )#####################################*/

    private void deletePackage(HttpServletRequest request,
    HttpServletResponse response) throws SQLException, IOException
    {
        String packageid = request.getParameter("packageid");
        pd.deletePackage(packageid);
        response.sendRedirect("Admin/Package/adminViewPackage.jsp");
    }
}
