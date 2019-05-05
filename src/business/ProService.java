package business;

import dao.ExpDao;
import dao.ProDao;
import po.expert;
import po.project;

import java.util.List;

public class ProService {
    private ProDao proDao = new ProDao();
    //保存项目
    public void savePro(project pro){
        proDao.savePro(pro);

    }


    //修改项目
    public void updatePro(project pro){
        proDao.updatePro(pro);

    }


    //删除项目
    public void deletePro(String name){
        proDao.deletePro(name);

    }



    //根据姓名查询项目
    public project findProByName(String name){
        return proDao.findProByName(name);


    }


    //查询所有项目
    public List<project> findAllPro(){
        return proDao.findAllPro();

    }
}
