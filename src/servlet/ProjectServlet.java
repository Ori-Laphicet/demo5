package servlet;

import business.ExpSevice;
import business.ProService;
import po.expert;
import po.project;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProjectServlet extends HttpServlet {
    private ProService proService = new ProService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String param = req.getParameter("param");
        if (param.equals("add")){
            project pro = new project();
            pro.setName(req.getParameter("name"));
            pro.setPerson(req.getParameter("person"));
            pro.setTel(req.getParameter("tel"));
            pro.setMotel(req.getParameter("motel"));
            pro.setEmail(req.getParameter("email"));
            pro.setMoney(Integer.parseInt(req.getParameter("money")));
            pro.setGmoney(Integer.parseInt(req.getParameter("gmoney")));
            pro.setStage(req.getParameter("stage"));
            pro.setContent(req.getParameter("content"));
            proService.savePro(pro);
            resp.sendRedirect("Project?param=gotomanage");

        }else if (param.equals("update")){
            project pro = new project();
            String Name = req.getParameter("name");
            pro.setName(req.getParameter("name"));
            pro.setPerson(req.getParameter("person"));
            pro.setTel(req.getParameter("tel"));
            pro.setMotel(req.getParameter("motel"));
            pro.setEmail(req.getParameter("email"));
            pro.setMoney(Integer.parseInt(req.getParameter("money")));
            pro.setGmoney(Integer.parseInt(req.getParameter("gmoney")));
            pro.setStage(req.getParameter("stage"));
            pro.setContent(req.getParameter("content"));
            proService.updatePro(pro);
            resp.sendRedirect("Project?param=gotomanage");
        }else if (param.equals("del")){
            String Name = req.getParameter("name");
            proService.deletePro(Name);
            resp.sendRedirect("Project?param=gotomanage");
        }else if (param.equals("findUndis")){
            ProService proService = new ProService();
            List<project> list = proService.findAllPro();
            req.setAttribute("List",list);
            req.getRequestDispatcher("undistributed.jsp").forward(req,resp);
        }else if (param.equals("show")){
            String identity = req.getParameter("ID");
            ExpSevice expSevice = new ExpSevice();
            List<project> list = expSevice.showPro(identity);
            req.setAttribute("List",list);
            req.setAttribute("id",identity);
            req.getRequestDispatcher("showPro.jsp").forward(req,resp);
        }else if (param.equals("gotomanage")){
            ProService proService = new ProService();
            List<project> list = proService.findAllPro();
            req.setAttribute("List",list);
            req.getRequestDispatcher("ProManager.jsp").forward(req,resp);
        }

    }


}
