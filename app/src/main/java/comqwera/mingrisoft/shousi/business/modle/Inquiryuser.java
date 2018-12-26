package comqwera.mingrisoft.shousi.business.modle;

public class Inquiryuser {
    private String u_id1;             //用户id
//    private int u_loinid1;        //登录账号
    private String u_nickname1;   //昵称
//    private String u_password1;   //密码
    private String u_phone1;           //电话号码
//    private String u_sex1;        //性别
//    private String u_headportrait1;//头像
//    private String u_vip1;        //是否是vip
    private String u_adress1;     //用户地址
    private String u_phone21;

    //定义有参构造函数，用来初始化用户信息实体类中的各个字段
    public Inquiryuser(String u_id1, String u_nickname1, String u_phone1,
                       String u_phone21 , String u_adress1)
    {
        super();
        this.u_id1=u_id1;                 //为用户编号赋值
//        this.u_loinid1=u_loinid1;         //为登录账号赋值
       this.u_nickname1=u_nickname1;     //为用户昵称赋值
//        this.u_password1=u_password1;     //为用户密码赋值
        this.u_phone1=u_phone1;                //为用户手机号赋值
//        this.u_sex1=u_sex1;                //为用户性别赋值
//        this.u_headportrait1=u_headportrait1;//为用户头像赋值
//        this.u_vip1=u_vip1;                //为用户vip赋值
        this.u_adress1=u_adress1;         //为用户地址赋值
        this.u_phone21=u_phone21;          //为用户预留电话号码赋值

    }
    //设置可读属性
    public String getU_id1() {
        return u_id1;
    }
//    public int getU_loinid1() {
//        return u_loinid1;
//    }

    public String getU_nickname1() {
        return u_nickname1;
    }

//    public String getU_password1() {
//        return u_password1;
//    }

    public String getU_phone1() {
        return u_phone1;
    }

//    public String getU_sex1() {
//        return u_sex1;
//    }
//
//    public String getU_headportrait1() {
//        return u_headportrait1;
//    }
//
//    public String getU_vip1() {
//        return u_vip1;
//    }

    public String getU_adress() {
        return u_adress1;
    }

    public String getU_phone21() {
        return u_phone21;
    }

    //获取函数可写属性
    public void setU_id1(String u_id1) {
        this.u_id1 = u_id1;
    }

//    public void setU_loinid1(int u_loinid1) {
//        this.u_loinid1 = u_loinid1;
//    }

    public void setU_nickname1(String u_nickname1) {
        this.u_nickname1 = u_nickname1;
    }

//    public void setU_password1(String u_password1) {
//        this.u_password1 = u_password1;
//    }

    public void setU_phone1(String u_phone1) {
        this.u_phone1 = u_phone1;
    }

//    public void setU_sex1(String u_sex1) {
//        this.u_sex1 = u_sex1;
//    }
//
//    public void setU_headportrait1(String u_headportrait1) {
//        this.u_headportrait1 = u_headportrait1;
//    }
//
//    public void setU_vip1(String u_vip1) {
//        this.u_vip1 = u_vip1;
//    }

    public void setU_adress1(String u_adress1) {
        this.u_adress1 = u_adress1;
    }

    public void setU_phone2(String u_phone21) {
        this.u_phone21 = u_phone21;
    }
}
