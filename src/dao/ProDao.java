package dao;

import Util.DButil;
import po.expert;
import po.project;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ProDao {
    //保存项目
    public void savePro(project pro){
        String sql = "insert into project values(null,?,?,?,?,?,?,?,?,?,?,?,null)";//11个值
        PreparedStatement ptmst = DButil.getPreparedStatement(sql);

        try {
            ptmst.setString(1,pro.getName());
            ptmst.setString(2,pro.getPerson());
            ptmst.setString(3,pro.getTel());
            ptmst.setString(4,pro.getMotel());
            ptmst.setString(5,pro.getEmail());
            ptmst.setString(6,pro.getDate());
            ptmst.setInt(7,pro.getMoney());
            ptmst.setInt(8,pro.getGmoney());
            ptmst.setString(9,pro.getStage());
            ptmst.setString(10,pro.getContent());
            ptmst.setBoolean(11,pro.getDel());
            ptmst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButil.closeDBResources();

        }


    }


    //修改项目
    public void updatePro(project pro){
        String sql = "update project set person=?,tel=?,motel=?,email=?,date=?," +
                "money=?,gmoney=?,stage=?,content=?,del=? where name=?";//11个值
        PreparedStatement ptmst = DButil.getPreparedStatement(sql);
        try {
            ptmst.setString(1,pro.getPerson());
            ptmst.setString(2,pro.getTel());
            ptmst.setString(3,pro.getMotel());
            ptmst.setString(4,pro.getEmail());
            ptmst.setString(5,pro.getDate());
            ptmst.setInt(6,pro.getMoney());
            ptmst.setInt(7,pro.getGmoney());
            ptmst.setString(8,pro.getStage());
            ptmst.setString(9,pro.getContent());
            ptmst.setBoolean(10,pro.getDel());
            ptmst.setString(11,pro.getName());
            ptmst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButil.closeDBResources();
        }

    }


    //根据名称删除项目
    public void deletePro(String  name){
        String sql = "update project set del=? where name=?";
        PreparedStatement ptmst = DButil.getPreparedStatement(sql);
        try {
            ptmst.setBoolean(1,true);
            ptmst.setString(2,name);
            ptmst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButil.closeDBResources();
        }

    }



    //查询项目
    public project findProByName(String name){
        project pro = new project();
        String sql = "select * from project where name=?";
        PreparedStatement ptmst = DButil.getPreparedStatement(sql);
        try {
            ptmst.setString(1,name);
            ResultSet rs = ptmst.executeQuery();
            if (rs.next() ){
                pro.setName(rs.getString("name"));
                pro.setPerson(rs.getString("person"));
                pro.setTel(rs.getString("tel"));
                pro.setMotel(rs.getString("motel"));
                pro.setEmail(rs.getString("email"));
                pro.setDate(rs.getString("date"));
                pro.setMoney(rs.getInt("money"));
                pro.setGmoney(rs.getInt("gmoney"));
                pro.setStage(rs.getString("stage"));
                pro.setContent(rs.getString("content"));
                pro.setDel(rs.getBoolean("del"));
                pro.setExp(rs.getString("exp"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButil.closeDBResources();
        }

        return pro;

    }


    //查询所有项目
    public List<project> findAllPro(){
        List<project> list = new LinkedList<>();
        String sql = "select * from project";
        PreparedStatement ptmst = DButil.getPreparedStatement(sql);
        try {
            ResultSet rs = ptmst.executeQuery();
            while (rs.next()){
                project pro = new project();
                if(rs.getBoolean("del") == false){
                    pro.setName(rs.getString("name"));
                    pro.setPerson(rs.getString("person"));
                    pro.setTel(rs.getString("tel"));
                    pro.setMotel(rs.getString("motel"));
                    pro.setEmail(rs.getString("email"));
                    pro.setDate(rs.getString("date"));
                    pro.setMoney(rs.getInt("money"));
                    pro.setGmoney(rs.getInt("gmoney"));
                    pro.setStage(rs.getString("stage"));
                    pro.setContent(rs.getString("content"));
                    pro.setDel(rs.getBoolean("del"));
                    pro.setExp(rs.getString("exp"));

                    list.add(pro);
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
