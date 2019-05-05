package business;


import dao.ExpDao;
import po.expert;
import po.project;
import java.util.List;

public class ExpSevice  {

    private ExpDao expDao = new ExpDao();
    //保存专家
    public void saveExp(expert exp){
        expDao.saveExp(exp);

    }



    //修改专家
    public void updateExp(expert exp){
        expDao.updateExp(exp);

    }


    //删除专家
    public void deleteExp(String id){
        expDao.deleteExp(id);

    }


    //分配项目
    public void proToExp(expert exp, project pro){
        expDao.proToExp(exp,pro);

    }

    //根据专家身份证查询项目
    public List<project> showPro(String ID){
        return expDao.showPro(ID);
    }


    //删除专家所拥有的项目
    public void Unassign(String identity,String name){
        expDao.Unassign(identity,name);
    }



    //根据身份证号查询专家
    public expert findExpByIdentity(String inentity){
       return expDao.findExpByIdentity(inentity);


    }


    //查询所有专家
    public List<expert> findAllExp(){
        return expDao.findAllExp();

    }
}
