package po;

public class Admin {
     private String name;
     private String password;
     private boolean del = false;//false代表未删除,true代表已删除
     public  Admin(){}
     public  Admin(String name,String password){
         this.name = name;
         this.password  = password;
     }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getDel() {
        return del;
    }

    public void setDel(boolean del) {
        this.del = del;
    }
}
