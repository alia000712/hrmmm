package com.demo3;

import org.jetbrains.annotations.NotNull;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "WorkerServlet", value = "/WorkerServlet")
public class WorkerServlet extends HttpServlet
{
    private WorkerDao wd;
    public void init()
    {
        wd = new WorkerDao();
    }

    private BranchDao bd;
    public void init2()
    {
        bd = new BranchDao();
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
                case "register":
                    register(request, response);
                    break;
                case "login":
                    login(request, response);
                    break;
                case "delete":
                    deleteWorker(request, response);
                    break;
                case "/edit":
                    /*showEditForm(request, response);*/
                    break;
                case "update":
                    updateWorker(request, response);
                    break;
                case "view":
                    viewWorker(request, response);
                    break;
                default:
                    /*listUser(request, response);*/
                    break;
            }
        }
        catch (SQLException ex) {throw new ServletException(ex);}
    }

    /*######################################################( REGISTER )#############################################################*/

    private void register(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException
    {
        String workername = request.getParameter("workername");
        String workerphone = request.getParameter("workerphone");
        String workeremail = request.getParameter("workeremail");
        String workeraddress = request.getParameter("workeraddress");
        String workeric = request.getParameter("workeric");
        String branchid = request.getParameter("branchid");
        worker wk = new worker();

        wk.setWorkerName(workername);
        wk.setWorkerEmail(workeremail);
        wk.setWorkerAddress(workeraddress);
        wk.setWorkerIC(workeric);
        wk.setBranchID(branchid);
        wk.setWorkerPhone(workerphone);

        wd.register(wk);
        response.sendRedirect("Admin/Worker/adminViewWorker.jsp");
    }

    /*######################################################( LOGIN )#############################################################*/

    private void login(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
    {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        String workeremail = request.getParameter("workeremail");
        String workeric = request.getParameter("workeric");

        try
        {
            Class.forName("org.postgresql.Driver"); // ni stay
            String dbURL = "jdbc:postgresql://ec2-50-19-32-96.compute-1.amazonaws.com:5432/d65mb698aandvt"; //ni url dri heroku database
            String user = "ffkacpfvbcmcwa"; //ni user dri heroku database
            String pass = "3939ef811721250f3db1595eb911cfcbac4e294a582158f13f9ef08dc63786bf"; //ni password dri heroku database
            Connection conn = DriverManager.getConnection(dbURL, user, pass);

            String sql  ="SELECT * from worker";
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
                    if(workeremail.equals(res.getString("workeremail")) && workeric.equals(res.getString("workeric")))
                    {
                        notFound=false;
                        session.setAttribute("workerid",res.getString(1));
                        worker wk = new worker();

                        wk.setWorkerID(res.getInt(1));
                        wk.setWorkerName(res.getString(2));
                        wk.setWorkerEmail(res.getString(3));
                        wk.setWorkerAddress(res.getString(4));
                        wk.setWorkerIC(res.getString(5));
                        wk.setBranchID(res.getString(6));
                        wk.setWorkerPhone(res.getString(7));

                        session.setAttribute("wk", wk);
                        response.sendRedirect("Worker/Home/workerHome.jsp");
                    }
                }
                if(notFound)
                {
                    out.println("<script>alert('User not found');</script>");
                    out.println("<script>window.location.href='worker-createAcc.jsp'</script>");
                }
            }
        }

        catch (Exception e) {e.printStackTrace();}
    }


    /*######################################################( UPDATE )#############################################################*/

    private void updateWorker(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException
    {
        HttpSession session = request.getSession();
        int workerid = Integer.parseInt(request.getParameter("workerid"));
        String workername = request.getParameter("workername");
        String workeremail = request.getParameter("workeremail");
        String workeraddress = request.getParameter("workeraddress");
        String workeric = request.getParameter("workeric");
        String branchid = request.getParameter("branchid");
        String workerphone = request.getParameter("workerphone");
        worker wk = new worker();

        wk.setWorkerID(workerid);
        wk.setWorkerName(workername);
        wk.setWorkerEmail(workeremail);
        wk.setWorkerAddress(workeraddress);
        wk.setWorkerIC(workeric);
        wk.setBranchID(branchid);
        wk.setWorkerPhone(workerphone);

        wd.updateWorker(wk);

        session.removeAttribute("wk");
        session.setAttribute("wk", wk);
        response.sendRedirect("Admin/Worker/adminViewWorker.jsp");
    }

    /*######################################################( VIEW )#############################################################*/

    private void viewWorker(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException
    {
        HttpSession session = request.getSession();
        int workerid = Integer.parseInt(request.getParameter("workerid"));
        String workername = request.getParameter("workername");
        String workeremail = request.getParameter("workeremail");
        String workeraddress = request.getParameter("workeraddress");
        String workeric = request.getParameter("workeric");
        String branchid = request.getParameter("branchid");
        String workerphone = request.getParameter("workerphone");
        String branchname = request.getParameter("branchname");

        worker wk = new worker();
        branch br = new branch();

        wk.setWorkerID(workerid);
        wk.setWorkerName(workername);
        wk.setWorkerEmail(workeremail);
        wk.setWorkerAddress(workeraddress);
        wk.setWorkerIC(workeric);
        wk.setBranchID(branchid);
        wk.setWorkerPhone(workerphone);
        br.setBranchName(branchname);

        session.setAttribute("wk", wk);
        session.setAttribute("br", br);
        response.sendRedirect("Admin/Worker/adminEditWorker.jsp");
    }

    /*######################################################( DELETE )#############################################################*/

    private void deleteWorker(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
    {
        int workerid = Integer.parseInt(request.getParameter("workerid"));
        wd.deleteWorker(workerid);
        response.sendRedirect("Admin/Worker/adminViewWorker.jsp");
    }
}
