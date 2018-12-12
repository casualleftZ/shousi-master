package comqwera.mingrisoft.shousi.model;

public class Food {
    private int f_id;    //定义菜品id
    private String f_name;//定义菜品名称
    private String f_url; //定义菜品图片;
    private float f_price;//定义菜品价格
    private float f_dprice;//定义优惠价
    private int f_sellcount;// 定义销售量
public Food(){
    super();
        }
//定义有参构造函数，用来初始化菜品信息实体类中的各个字段
public Food(int f_id,String f_name,String f_url,float f_price,float f_dprice,int f_sellcount){
    this.f_id=f_id;    //为菜品id赋值
    this.f_name=f_name; //为菜品名称赋值
    this.f_url=f_url;   //为菜品图片赋值
    this.f_price=f_price; //为菜品价格赋值
    this.f_sellcount=f_sellcount;//为销售量赋值
}
//设置可读属性

    public int getF_id() {
        return f_id;
    }

    public String getF_name() {
        return f_name;
    }

    public String getF_url() {
        return f_url;
    }

    public float getF_price() {
        return f_price;
    }

    public float getF_dprice() {
        return f_dprice;
    }

    public int getF_sellcount() {
        return f_sellcount;
    }
//设置可写属性

    public void setF_id(int f_id) {
        this.f_id = f_id;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public void setF_url(String f_url) {
        this.f_url = f_url;
    }

    public void setF_price(float f_price) {
        this.f_price = f_price;
    }

    public void setF_dprice(float f_dprice) {
        this.f_dprice = f_dprice;
    }

    public void setF_sellcount(int f_sellcount) {
        this.f_sellcount = f_sellcount;
    }
}