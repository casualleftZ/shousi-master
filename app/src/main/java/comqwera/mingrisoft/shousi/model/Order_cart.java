package comqwera.mingrisoft.shousi.model;

public class Order_cart {
    private int o_id;        //定义订单id
    private int u_id;         //定义用户id
    private String o_orderdate;      //定义下单时间
    private String o_memo;    //定义用户备注
    private String o_statue;  //定义订单状态
    private String o_phone;     //定义下单电话
    private float o_totle;   //定义总金额
    private float o_dis;     //定义优惠价
    private String o_paymethod; //定义支付方式
    private String o_paytime; //定义支付时间
    private String o_paystatue; //定义支付状态
    private String o_address;   //定义收货地址
    public Order_cart(){
        super();
    }
   //定义有参构造函数，用来初始化订单实体类中的各个字段
public Order_cart(int o_int,int u_id,String o_orderdate,String o_memo,String o_statue,String o_phone,float o_totle,
                  float o_dis,String o_paytime,String o_paymethod,String o_paystatue,String o_address){
        this.o_id=o_id;               //给订单号赋值
        this.u_id=u_id;                 //给用户id赋值
        this.o_orderdate=o_orderdate;  //给用户下单时间赋值
        this.o_memo=o_memo;             //给用户备注赋值
        this.o_statue=o_statue;         //给订单状态赋值
        this.o_phone=o_phone;           //给下单电话赋值
        this.o_totle=o_totle;           //给总金额赋值
        this.o_dis=o_dis;               //给优惠价赋值
        this.o_paytime=o_paytime;      //给支付时间赋值
        this.o_paymethod=o_paymethod; //给支付方式赋值
        this.o_address=o_address;     //给支付地址赋值
        this.o_paystatue=o_paystatue; //给支付状态赋值
}
//设置可读属性

    public int getO_id() {
        return o_id;
    }

    public int getU_id() {
        return u_id;
    }

    public String getO_orderdate() {
        return o_orderdate;
    }

    public String getO_memo() {
        return o_memo;
    }

    public String getO_statue() {
        return o_statue;
    }

    public String getO_phone() {
        return o_phone;
    }

    public float getO_totle() {
        return o_totle;
    }

    public float getO_dis() {
        return o_dis;
    }

    public String getO_paymethod() {
        return o_paymethod;
    }

    public String getO_paytime() {
        return o_paytime;
    }

    public String getO_paystatue() {
        return o_paystatue;
    }

    public String getO_address() {
        return o_address;
    }
    //设置可写属性

    public void setO_id(int o_int) {
        this.o_id = o_int;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public void setO_orderdate(String o_orderdate) {
        this.o_orderdate = o_orderdate;
    }

    public void setO_memo(String o_memo) {
        this.o_memo = o_memo;
    }

    public void setO_statue(String o_statue) {
        this.o_statue = o_statue;
    }

    public void setO_phone(String o_phone) {
        this.o_phone = o_phone;
    }

    public void setO_totle(float o_totle) {
        this.o_totle = o_totle;
    }

    public void setO_dis(float o_dis) {
        this.o_dis = o_dis;
    }

    public void setO_paymethod(String o_paymethod) {
        this.o_paymethod = o_paymethod;
    }

    public void setO_paytime(String o_paytime) {
        this.o_paytime = o_paytime;
    }

    public void setO_paystatue(String o_paystatue) {
        this.o_paystatue = o_paystatue;
    }

    public void setO_address(String o_address) {
        this.o_address = o_address;
    }
}
