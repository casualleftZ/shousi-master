package comqwera.mingrisoft.shousi.model;

public class Myuser {                 //用户信息实体类
    private int u_id;             //用户id
    private int u_loinid;        //登录账号
    private String u_nickname;   //昵称
    private String u_password;   //密码
    private String u_phone;           //电话号码
    private String u_sex;        //性别
    private String u_headportrait;//头像
    private String u_vip;        //是否是vip
    private String u_adress;     //用户地址
    public Myuser(int r_id, String r_name, String r_opentime, String r_address, String r_phone, String r_discription){
    super();
    }

//定义有参构造函数，用来初始化用户信息实体类中的各个字段
    public Myuser(int u_id, int u_loinid,String u_nickname,String u_password, String u_phone, String u_sex, String u_headportrait,
                   String u_vip,String u_adress)
    {
        super();
        this.u_id=u_id;                 //为用户编号赋值
        this.u_loinid=u_loinid;         //为登录账号赋值
        this.u_nickname=u_nickname;     //为用户昵称赋值
        this.u_password=u_password;     //为用户密码赋值
        this.u_phone=u_phone;                //为用户手机号赋值
        this.u_sex=u_sex;                //为用户性别赋值
        this.u_headportrait=u_headportrait;//为用户头像赋值
        this.u_vip=u_vip;                //为用户vip赋值
        this.u_adress=u_adress;         //为用户地址赋值
    }
    //设置可读属性
    public int getU_id() {
        return u_id;
    }
    public int getU_loinid() {
        return u_loinid;
    }

    public String getU_nickname() {
        return u_nickname;
    }

    public String getU_password() {
        return u_password;
    }

    public String getU_phone() {
        return u_phone;
    }

    public String getU_sex() {
        return u_sex;
    }

    public String getU_headportrait() {
        return u_headportrait;
    }

    public String getU_vip() {
        return u_vip;
    }

    public String getU_adress() {
        return u_adress;
    }
    //获取函数可写属性
    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public void setU_loinid(int u_loinid) {
        this.u_loinid = u_loinid;
    }

    public void setU_nickname(String u_nickname) {
        this.u_nickname = u_nickname;
    }

    public void setU_password(String u_password) {
        this.u_password = u_password;
    }

    public void setU_phone(String phone) {
        this.u_phone = u_phone;
    }

    public void setU_sex(String u_sex) {
        this.u_sex = u_sex;
    }

    public void setU_headportrait(String u_headportrait) {
        this.u_headportrait = u_headportrait;
    }

    public void setU_vip(String u_vip) {
        this.u_vip = u_vip;
    }

    public void setU_adress(String u_adress) {
        this.u_adress = u_adress;
    }
}
