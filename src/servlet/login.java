package servlet;


import business.AdminService;
import po.Admin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class login extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdminService adminService = new AdminService();
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String param = req.getParameter("param");
        if (param.equals("is")){
            String account = req.getParameter("account");
            String password = req.getParameter("password");
            Admin admin = new Admin(account, password);
            //判断管理员是否合法
            boolean legal = adminService.legal(admin);
            if (legal) {//合法
                req.getSession().setAttribute("admin",admin);
                resp.sendRedirect("Expert?param=gotomanage");
            } else {//非法
                req.getSession().setAttribute("LoginError",true);
                resp.sendRedirect("index.jsp");
            }
        }

    }
}


