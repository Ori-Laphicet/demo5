package dao;

import Util.DButil;
import po.expert;
import po.project;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ExpDao {
    //保存专家
    public void saveExp(expert exp){
        String sql = "insert into expert values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,null)";//18个值
        PreparedStatement ptmst = DButil.getPreparedStatement(sql);

        try {
            ptmst.setString(1,exp.getName());
            ptmst.setString(2,exp.getIdentity());
            ptmst.setString(3,exp.getSex());
            ptmst.setString(4,exp.getNation());
            ptmst.setString(5,exp.getBirth());
            ptmst.setString(6,exp.getCompany());
            ptmst.setString(7,exp.getDepartment());
            ptmst.setString(8,exp.getSub());
            ptmst.setString(9,exp.getJob());
            ptmst.setString(10,exp.getRearch_dirction());
            ptmst.setString(11,exp.getClassification_of_industry());
            ptmst.setString(12,exp.getAchievements());
            ptmst.setString(13,exp.getHonors());
            ptmst.setString(14,exp.getTel());
            ptmst.setString(15,exp.getEmail());
            ptmst.setString(16,exp.getAdd());
            ptmst.setBoolean(17,exp.getDel());
            ptmst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButil.closeDBResources();

        }


    }


    //修改专家
    public void updateExp(expert exp){
        String sql = "update expert set name=?,sex=?,nation=?," +
                "birth=?,company=?,department=?,sub=?,job=?,rearch_dirction=?," +
                "classification_of_industry=?,tel=?,email=?,`add`=?,achievements=?," +
                "honors=? where identity=?";//16个值
        PreparedStatement ptmst = DButil.getPreparedStatement(sql);
        try {
            ptmst.setString(1,exp.getName());
            ptmst.setString(2,exp.getSex());
            ptmst.setString(3,exp.getNation());
            ptmst.setString(4,exp.getBirth());
            ptmst.setString(5,exp.getCompany());
            ptmst.setString(6,exp.getDepartment());
            ptmst.setString(7,exp.getSub());
            ptmst.setString(8,exp.getJob());
            ptmst.setString(9,exp.getRearch_dirction());
            ptmst.setString(10,exp.getClassification_of_industry());
            ptmst.setString(11,exp.getTel());
            ptmst.setString(12,exp.getEmail());
            ptmst.setString(13,exp.getAdd());
            ptmst.setString(14,exp.getAchievements());
            ptmst.setString(15,exp.getHonors());
            ptmst.setString(16,exp.getIdentity());
            ptmst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButil.closeDBResources();
        }

    }


    //删除专家
    public void deleteExp(String  id){
        String sql = "update expert set del=? where identity=?";
        PreparedStatement ptmst = DButil.getPreparedStatement(sql);
        try {
            ptmst.setBoolean(1,true);
            ptmst.setString(2,id);
            ptmst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButil.closeDBResources();
        }

    }




    //分配项目
    public void proToExp(expert exp, project pro){
        String expIdentity = exp.getIdentity();
        String proId = pro.getName();
        String prolist = proId+",";
        //拼接expert表中Pro段的字符串
        String sql1 = "select * from expert where identity=?";
        PreparedStatement ptmst1 = DButil.getPreparedStatement(sql1);
        try {
            ptmst1.setString(1,expIdentity);
            ResultSet rs = ptmst1.executeQuery();
            if (rs.next()){
                String temp = rs.getString("pro");
                prolist = prolist.concat(temp);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButil.closeDBResources();
        }

        //将上一步得到的字符串写入expert表中Pro段
        String sql2 = "update expert set pro=? where identity=?";
        PreparedStatement ptmst2 = DButil.getPreparedStatement(sql2);
        try {
            ptmst2.setString(1,prolist);
            ptmst2.setString(2,expIdentity);
            ptmst2.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButil.closeDBResources();
        }

        //将expert的identity写入project的exp段
        String sql3 = "update project set exp=? where name=?";
        PreparedStatement ptmst3 = DButil.getPreparedStatement(sql3);
        try {
            ptmst3.setString(1,expIdentity);
            ptmst3.setString(2,proId);
            ptmst3.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButil.closeDBResources();
        }

    }



    //展示专家所管理的项目
    public List<project> showPro(String ID){
        //拼接expert表中Pro段的字符串
        String sql1 = "select * from expert where identity=?";
        String temp = "";
        PreparedStatement ptmst1 = DButil.getPreparedStatement(sql1);
        try {
            ptmst1.setString(1,ID);
            ResultSet rs = ptmst1.executeQuery();
            if (rs.next()){
                temp = rs.getString("pro");
            }
            if (temp == null){
                temp = "";
                String sql2 = "update expert set pro=? where identity=?";
                PreparedStatement ptmst2 = DButil.getPreparedStatement(sql2);
                ptmst2.setString(1,"");
                ptmst2.setString(2,ID);
                ptmst2.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButil.closeDBResources();
        }

        //将得到的字符串分割为数组
        String[] arr = temp.split(",");

        //按数组元素从project表中取出项目信息
        List<project> list= new LinkedList<>();
        ProDao proDao = new ProDao();
        for (String s:arr){
            project pro = proDao.findProByName(s);
            list.add(pro);
        }
        return list;

    }



    //删除专家所拥有的项目
    public void Unassign(String identity,String name){
        String expIdentity = identity;
        String proId = name;
        String prolist = "";
        //获得并处理expert表中Pro段的字符串
        String sql1 = "select * from expert where identity=?";
        PreparedStatement ptmst1 = DButil.getPreparedStatement(sql1);
        try {
            ptmst1.setString(1,expIdentity);
            ResultSet rs = ptmst1.executeQuery();
            if (rs.next()){
                String temp = rs.getString("pro");
                prolist = temp.replace(name+",","");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButil.closeDBResources();
        }

        //将上一步得到的字符串写入expert表中Pro段
        String sql2 = "update expert set pro=? where identity=?";
        PreparedStatement ptmst2 = DButil.getPreparedStatement(sql2);
        try {
            ptmst2.setString(1,prolist);
            ptmst2.setString(2,expIdentity);
            ptmst2.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButil.closeDBResources();
        }

        //将expert的identity写入project的exp段
        String sql3 = "update project set exp=? where name=?";
        PreparedStatement ptmst3 = DButil.getPreparedStatement(sql3);
        try {
            ptmst3.setString(1,"");
            ptmst3.setString(2,proId);
            ptmst3.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButil.closeDBResources();
        }


    }








    //根据身份证号查询专家
    public expert findExpByIdentity(String ID){
        expert exp = new expert();
        String sql = "select * from expert where identity =?";
        PreparedStatement ptmst = DButil.getPreparedStatement(sql);
        try {
            ptmst.setString(1,ID);
            ResultSet rs = ptmst.executeQuery();
            if (rs.next() ){
                exp.setAchievements(rs.getString("achievements"));
                exp.setAdd(rs.getString("add"));
                exp.setBirth(rs.getString("birth"));
                exp.setClassification_of_industry(rs.getString("classification_of_industry"));
                exp.setCompany(rs.getString("company"));
                exp.setDel(false);
                exp.setDepartment(rs.getString("department"));
                exp.setEmail(rs.getString("email"));
                exp.setHonors(rs.getString("honors"));
                exp.setJob(rs.getString("job"));
                exp.setName(rs.getString("name"));
                exp.setNation(rs.getString("nation"));
                exp.setRearch_dirction(rs.getString("rearch_dirction"));
                exp.setSex(rs.getString("sex"));
                exp.setSub(rs.getString("sub"));
                exp.setTel(rs.getString("tel"));
                exp.setIdentity(rs.getString("identity"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButil.closeDBResources();
        }

        return exp;

    }


    //查询所有专家
    public List<expert> findAllExp(){
        List<expert> list = new LinkedList<>();
        String sql = "select * from expert";
        PreparedStatement ptmst = DButil.getPreparedStatement(sql);
        try {
            ResultSet rs = ptmst.executeQuery();
            while (rs.next()){
                expert exp = new expert();
                if(rs.getBoolean("del") == false){
                    exp.setAchievements(rs.getString("achievements"));
                    exp.setAdd(rs.getString("add"));
                    exp.setBirth(rs.getString("birth"));
                    exp.setClassification_of_industry(rs.getString("classification_of_industry"));
                    exp.setCompany(rs.getString("company"));
                    exp.setDel(false);
                    exp.setDepartment(rs.getString("department"));
                    exp.setEmail(rs.getString("email"));
                    exp.setHonors(rs.getString("honors"));
                    exp.setJob(rs.getString("job"));
                    exp.setName(rs.getString("name"));
                    exp.setNation(rs.getString("nation"));
                    exp.setRearch_dirction(rs.getString("rearch_dirction"));
                    exp.setSex(rs.getString("sex"));
                    exp.setSub(rs.getString("sub"));
                    exp.setTel(rs.getString("tel"));
                    exp.setIdentity(rs.getString("identity"));
                    list.add(exp);

                }else{
                    continue;
                }


            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButil.closeDBResources();
        }

        return list;

    }
}
