package comqwera.mingrisoft.shousi.model;

public class Useraddress {
    private int a_id;
    private int u_id;
    private String a_name;
    private String a_phone;
    private String a_weizhi;
    private String a_menhao;
    private Useraddress(){
        super();
    }
    public Useraddress(int a_id, int u_id, String a_name, String a_phone, String a_weizhi, String a_menhao){
        this.a_id=a_id;
        this.a_name=a_name;
        this.u_id=u_id;
        this.a_phone=a_phone;
        this.a_weizhi=a_weizhi;
        this.a_menhao=a_menhao;

    }

    public int getA_id() {
        return a_id;
    }

    public int getU_id() {
        return u_id;
    }

    public String getA_name() {
        return a_name;
    }

    public String getA_phone() {
        return a_phone;
    }

    public String getA_weizhi() {
        return a_weizhi;
    }

    public String getA_menhao() {
        return a_menhao;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }
}

