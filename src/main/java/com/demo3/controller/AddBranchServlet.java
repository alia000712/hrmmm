package com.demo3.controller;

import com.demo3.bean.AddBranch;
import com.demo3.dao.AddBranchDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddBranchServlet", value = "/AddBranchServlet")

public class AddBranchServlet extends HttpServlet {

    public AddBranchServlet() {}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Copying all the input parameters in to local variables
        String branchName = request.getParameter("branchname");
        String branchID = request.getParameter("branchid");
        String branchAddress = request.getParameter("branchaddress");
        String branchPhone = request.getParameter("branchphone");
        int numOfWorker = Integer.parseInt(request.getParameter("numofworker"));

        AddBranch addbr = new AddBranch();
        //Using Java Beans - An easiest way to play with group of related data
        addbr.setBranchName(branchName);
        addbr.setBranchID(branchID);
        addbr.setBranchAddress(branchAddress);
        addbr.setBranchPhone(branchPhone);
        addbr.setNumOfWorker(numOfWorker);

        AddBranchDao addBranchDao = new AddBranchDao();

        //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
        String branchRegistered = addBranchDao.registerBranch(addbr);

        if(branchRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
        {
//            request.getRequestDispatcher("/Admin/Branch/ViewBranch.jsp").forward(request, response);
            response.sendRedirect("Admin/Branch/ViewBranch.jsp");
        }
        else   //On Failure, display a meaningful message to the User.
        {
            request.setAttribute("errMessage", branchRegistered);
            request.getRequestDispatcher("Admin/Branch/AddBranch.jsp").forward(request, response);
        }
    }
}
