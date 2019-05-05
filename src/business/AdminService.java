package business;

import dao.AdminDao;
import po.Admin;

public class AdminService {
    //判断登录是否合法
    private AdminDao ad = new AdminDao();
    public boolean legal(Admin admin){
        return ad.isExists(admin.getName(),admin.getPassword());
    }

    public void saveAdmin(Admin admin){
        ad.saveAdmin(admin);
    }

    public void deleteAdmin(Admin admin){
        ad.deleteAdmin(admin);
    }
}
