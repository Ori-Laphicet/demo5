package servlet;

import business.AdminService;
import business.ExpSevice;
import business.ProService;
import po.Admin;
import po.expert;
import po.project;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class Expert extends HttpServlet {
    private ExpSevice expService = new ExpSevice();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("GBK");
        String param = req.getParameter("param");
        if (param.equals("add")){//新增专家
            po.expert exp = new expert();
            po.Admin admin = new Admin();
            AdminService ads = new AdminService();
            //身份证校验
            String iden = req.getParameter("identity");
            if (expService.findExpByIdentity(iden) != null){
                exp = expService.findExpByIdentity(iden);
                if (exp.getDel() == false) {
                    PrintWriter out = resp.getWriter();
                    out.println("<script>");
                    out.println("alert('该专家已在库中!');");
                    out.println("</script>");
                    out.close();
                    resp.sendRedirect("Expert?param=gotomanage");
                }
            }

            //设置账户内容
            admin.setName(req.getParameter("identity"));
            admin.setPassword(req.getParameter("identity"));
            ads.saveAdmin(admin);

            //设置专家内容
            exp.setAchievements(req.getParameter("achievements"));
            exp.setAdd(req.getParameter("add"));
            exp.setBirth(req.getParameter("birth"));
            exp.setClassification_of_industry(req.getParameter("classification_of_industry"));
            exp.setCompany(req.getParameter("company"));
            exp.setDel(false);
            exp.setDepartment(req.getParameter("department"));
            exp.setEmail(req.getParameter("email"));
            exp.setHonors(req.getParameter("honors"));
            exp.setIdentity(req.getParameter("identity"));
            exp.setJob(req.getParameter("job"));
            exp.setName(req.getParameter("name"));
            exp.setNation(req.getParameter("nation"));
            exp.setRearch_dirction(req.getParameter("rearch_dirction"));
            exp.setSex(req.getParameter("sex"));
            exp.setSub(req.getParameter("sub"));
            exp.setTel(req.getParameter("tel"));
            expService.saveExp(exp);
            //重定向到专家管理
            resp.sendRedirect("Expert?param=gotomanage");
        }else if (param.equals("update")){
            po.expert exp = new expert();
            //设置专家内容
            exp.setAchievements(req.getParameter("achievements"));
            exp.setAdd(req.getParameter("add"));
            exp.setBirth(req.getParameter("birth"));
            exp.setClassification_of_industry(req.getParameter("classification_of_industry"));
            exp.setCompany(req.getParameter("company"));
            exp.setDel(false);
            exp.setDepartment(req.getParameter("department"));
            exp.setEmail(req.getParameter("email"));
            exp.setHonors(req.getParameter("honors"));
            exp.setIdentity(req.getParameter("id"));
            exp.setJob(req.getParameter("job"));
            exp.setName(req.getParameter("name"));
            exp.setNation(req.getParameter("nation"));
            exp.setRearch_dirction(req.getParameter("rearch_dirction"));
            exp.setSex(req.getParameter("sex"));
            exp.setSub(req.getParameter("sub"));
            exp.setTel(req.getParameter("tel"));
            expService.updateExp(exp);
            //重定向到专家管理
            resp.sendRedirect("Expert?param=gotomanage");
        }else if (param.equals("del")) {
            po.Admin admin = new Admin();
            AdminService ads = new AdminService();

            //删除专家
            String ID = req.getParameter("ID");
            expService.deleteExp(ID);
            //删除账户
            ads.deleteAdmin(admin);
            //重定向
            resp.sendRedirect("Expert?param=gotomanage");
        }else if (param.equals("addpro")){
            String identity = req.getParameter("ID");
            String name = req.getParameter("name");
            expert exp = expService.findExpByIdentity(identity);
            ProService proService = new ProService();
            project pro = proService.findProByName(name);
            expService.proToExp(exp,pro);
            resp.sendRedirect("Expert?param=gotomanage");
        }else if (param.equals("unassign")){
            String name = req.getParameter("name");
            String identity = req.getParameter("identity");
            expService.Unassign(identity,name);
            resp.sendRedirect("Expert?param=gotomanage");
        }else if (param.equals("gotomanage")){
            ExpSevice experts = new ExpSevice();
            List<expert> list = experts.findAllExp();
            req.setAttribute("List",list);
            req.getRequestDispatcher("ExpManeger.jsp").forward(req,resp);
        }


    }
}









