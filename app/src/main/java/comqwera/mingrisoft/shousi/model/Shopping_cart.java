package comqwera.mingrisoft.shousi.model;

public class Shopping_cart {
    private int s_id;   //定义订单编号
    private int u_id;   //定义用户id编号
    private int f_id;   //定义菜品id编号
    private int s_num;  //定义菜品数量
    private String s_time; //定义购买时间
    public Shopping_cart(){
        super();
    }
//定义有参构造函数，用来初始化购物车单实体类的各个字段
    public Shopping_cart(int s_id,int u_id,int f_id,int s_num,String s_time){
        this.s_id=s_id;   //为订单编号赋值
        this.f_id=f_id;    //为用户id编号赋值
        this.u_id=u_id;    //为菜品id编号赋值
        this.s_num=s_num;  //为菜品数量赋值
        this.s_time=s_time;  //为购买时间赋值
    }
//设置可读属性

    public int getS_id() {
        return s_id;
    }

    public int getU_id() {
        return u_id;
    }

    public int getF_id() {
        return f_id;
    }

    public int getS_num() {
        return s_num;
    }

    public String getS_time() {
        return s_time;
    }
//设置编号可写属性

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public void setF_id(int f_id) {
        this.f_id = f_id;
    }

    public void setS_num(int s_num) {
        this.s_num = s_num;
    }

    public void setS_time(String s_time) {
        this.s_time = s_time;
    }
}
