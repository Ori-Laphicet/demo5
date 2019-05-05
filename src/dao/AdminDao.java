package dao;

import Util.DButil;
import po.Admin;
import po.project;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao {
    //判断指定账号密码是否存在
    public boolean isExists(String account,String pwd){
        String sql = "select * from admin where 帐号 =? and 密码=?";
        boolean is = false;
        //连接数据库
        PreparedStatement pstmt = DButil.getPreparedStatement(sql);
        try {
            pstmt.setString(1,account);
            pstmt.setString(2,pwd);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                is = true;
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButil.closeDBResources();
        }
        return is;
    }

    //保存用户
    public void saveAdmin(Admin admin){
        String sql = "insert into admin values(null,?,?,?)";//3个值
        PreparedStatement ptmst = DButil.getPreparedStatement(sql);

        try {
            ptmst.setString(1,admin.getName());
            ptmst.setString(2,admin.getPassword());
            ptmst.setBoolean(3,false);
            ptmst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButil.closeDBResources();
        }
    }

    //删除用户
    public void deleteAdmin(Admin admin){
        String sql = "update project set del=? where name=?";
        PreparedStatement ptmst = DButil.getPreparedStatement(sql);
        try {
            ptmst.setBoolean(1,true);
            ptmst.setString(2,admin.getName());
            ptmst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButil.closeDBResources();
        }
    }

}
