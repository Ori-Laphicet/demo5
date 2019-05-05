package po;

import java.util.List;

public class expert {
    private String name;//姓名
    private String identity;//身份证
    private String sex;//
    private String nation;//民族
    private String birth;//出生年月
    private String department;//工作部门
    private String sub;//学科
    private String job;//职务职称
    private String rearch_dirction;//研究方向
    private String achievements;//主要成就
    private String honors;//荣誉奖励
    private String tel;//联系电话
    private String email;//邮箱
    private String add;//地址
    private String classification_of_industry;//行业分类
    private String company;//单位
    private Boolean del = false;//false代表未删除，true代表已删除
    private String pro;//已分配项目

    public String getClassification_of_industry() {
        return classification_of_industry;
    }

    public void setClassification_of_industry(String classification_of_industry) {
        this.classification_of_industry = classification_of_industry;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String deoartment) {
        this.department = deoartment;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getRearch_dirction() {
        return rearch_dirction;
    }

    public void setRearch_dirction(String rearch_dirction) {
        this.rearch_dirction = rearch_dirction;
    }

    public String getAchievements() {
        return achievements;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }

    public String getHonors() {
        return honors;
    }

    public void setHonors(String honors) {
        this.honors = honors;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public Boolean getDel() {
        return del;
    }

    public void setDel(Boolean del) {
        this.del = del;
    }

    public String getPro() {
        return pro;
    }

    public void setPro(String pro) {
        this.pro = pro;
    }
}
