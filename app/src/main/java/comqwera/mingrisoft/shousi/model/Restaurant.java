package comqwera.mingrisoft.shousi.model;


public class Restaurant {
    private int r_id;       //定义商家编号
    private String r_password;
    private String r_name;  //定义商家名称
    private String r_opentime;//定义营业时间
    private String r_address; //定义商家地址
    private String r_phone;   //定义商家的联系方式
    private String r_discription;//定义商家描述
    public Restaurant(){
        super();
    }
//定义有参构造函数，用来初始化饭店入信息实体类中的各个字段
    public Restaurant(int r_id,String password,String r_name,String r_opentime,String r_address,
                      String r_phone,String r_discription){
        super();
        this.r_id=r_id;            //为商家编号赋值
        this.r_password=r_password;
        this.r_name=r_name;        //为商家名称赋值
        this.r_opentime=r_opentime;//为商家营业时间赋值
        this.r_address=r_address;  //为商家地址赋值
        this.r_phone=r_phone;      //为商家电话赋值
        this.r_discription=r_discription; //为商家描述赋值
    }
    //设置可读属性
    public int getR_id() {
        return r_id;
    }

    public String getR_password() {
        return r_password;
    }

    public String getR_name() {
        return r_name;
    }

    public String getR_opentime() {
        return r_opentime;
    }

    public String getR_address() {
        return r_address;
    }

    public String getR_phone() {
        return r_phone;
    }

    public String getR_discription() {
        return r_discription;
    }
    //设置可写属性

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public void setR_password(String r_password) {
        this.r_password = r_password;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }

    public void setR_opentime(String r_opentime) {
        this.r_opentime = r_opentime;
    }

    public void setR_address(String r_address) {
        this.r_address = r_address;
    }

    public void setR_phone(String r_phone) {
        this.r_phone = r_phone;
    }

    public void setR_discription(String r_discription) {
        this.r_discription = r_discription;
    }
}
