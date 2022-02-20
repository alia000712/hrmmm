package com.demo3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "BranchServlet", value = "/BranchServlet")

public class BranchServlet extends HttpServlet
{
    private BranchDao bd;
    public void init()
    {
        bd = new BranchDao();
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
                    addBranch(request, response);
                    break;
                case "view":
                    viewBranch(request, response);
                    break;
                case "delete":
                    deleteBranch(request, response);
                    break;
                case "update":
                    updateBranch(request, response);
                    break;
                default:
                    break;
            }
        }
        catch (SQLException ex) {throw new ServletException(ex);}
    }

    /*################################( ADD BRANCH )#####################################*/

    private void addBranch(HttpServletRequest request,
    HttpServletResponse response) throws SQLException, IOException
    {
        String branchid = request.getParameter("branchid");
        String branchname = request.getParameter("branchname");
        String branchaddress = request.getParameter("branchaddress");
        String branchphone = request.getParameter("branchphone");
        int numofworker = Integer.parseInt(request.getParameter("numofworker"));
        branch br = new branch();

        br.setBranchID(branchid);
        br.setBranchName(branchname);
        br.setBranchAddress(branchaddress);
        br.setBranchPhone(branchphone);
        br.setNumOfWorker(numofworker);

        bd.addBranch(br);
        response.sendRedirect("Admin/Branch/adminViewBranch.jsp");
    }

    /*################################( UPDATE BRANCH )#####################################*/

    private void updateBranch(HttpServletRequest request,
    HttpServletResponse response) throws SQLException, IOException, ServletException
    {
        HttpSession session = request.getSession();
        String branchid = request.getParameter("branchid");
        String branchname = request.getParameter("branchname");
        String branchaddress = request.getParameter("branchaddress");
        String branchphone = request.getParameter("branchphone");
        int numofworker = Integer.parseInt(request.getParameter("numofworker"));

        branch br = new branch();

        br.setBranchID(branchid);
        br.setBranchName(branchname);
        br.setBranchAddress(branchaddress);
        br.setBranchPhone(branchphone);
        br.setNumOfWorker(numofworker);

        bd.updateBranch(br);

        session.removeAttribute("br");
        session.setAttribute("br",br);
        response.sendRedirect("Admin/Branch/adminViewBranchDetail.jsp");
    }

    /*################################( VIEW BRANCH )#####################################*/

    private void viewBranch(HttpServletRequest request,
    HttpServletResponse response) throws SQLException, IOException, ServletException
    {
        HttpSession session = request.getSession();
        String branchid = request.getParameter("branchid");
        String branchname = request.getParameter("branchname");
        String branchaddress = request.getParameter("branchaddress");
        String branchphone = request.getParameter("branchphone");
        int numofworker = Integer.parseInt(request.getParameter("numofworker"));

        branch br = new branch();

        br.setBranchID(branchid);
        br.setBranchName(branchname);
        br.setBranchAddress(branchaddress);
        br.setBranchPhone(branchphone);
        br.setNumOfWorker(numofworker);

        session.setAttribute("br",br);
        response.sendRedirect("Admin/Branch/adminViewBranchDetail.jsp");
    }

    /*################################( DELETE BRANCH )#####################################*/

    private void deleteBranch(HttpServletRequest request,
    HttpServletResponse response) throws SQLException, IOException
    {
        String branchid = request.getParameter("branchid");
        bd.deleteBranch(branchid);
        response.sendRedirect("Admin/Branch/adminViewBranch.jsp");
    }
}