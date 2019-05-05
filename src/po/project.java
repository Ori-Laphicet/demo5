package po;

import java.text.SimpleDateFormat;
import java.util.Date;

public class project {//11个
    private String name;//项目名称
    private String person;//申请联系人
    private String tel;//固定电话
    private String motel;//移动电话
    private String email;//电子邮箱

    SimpleDateFormat dateFormat = new SimpleDateFormat(" yyyy-MM-dd ");
    private String date = dateFormat.format( new Date() );//申请日期

    private int money;//项目总资产
    private int gmoney;//已获得投资
    private String stage;//项目所处阶段
    private String content;//项目主要内容
    private boolean del = false;//false代表未删除,true代表已删除
    private String exp ="";//项目分配专家


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMotel() {
        return motel;
    }

    public void setMotel(String motel) {
        this.motel = motel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getGmoney() {
        return gmoney;
    }

    public void setGmoney(int gmoney) {
        this.gmoney = gmoney;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean getDel() {
        return del;
    }

    public void setDel(boolean del) {
        this.del = del;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }
}
