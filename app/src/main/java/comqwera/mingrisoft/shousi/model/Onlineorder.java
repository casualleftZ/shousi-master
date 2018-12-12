package comqwera.mingrisoft.shousi.model;

public class Onlineorder {
    private int or_id;    //定义订单编号
    private int u_id;     //定义用户id编号
    private String or_phone;  //定义用户电话
    private int d_id;     //定义座位id编号
    private int or_sum;  //定义用餐人数
    private String or_memo; //定义用户备注
    public Onlineorder(){
        super();
    }
//定义有参构造函数，用来初始化在线预订表实体类中的各个字段
    public Onlineorder(int or_id,int u_id,String or_phone,int d_id,int or_sum,String or_memo){
        this.or_id=or_id;      //为订单编号赋值
        this.u_id=u_id;        //为座位id编号赋值
        this.or_phone=or_phone; //定义用户电话
        this.d_id=d_id;        //为用餐人数赋值
        this.or_sum=or_sum;    //为用户id编号赋值
        this.or_memo=or_memo;  //为用户备注赋值
    }
    //设置可读属性

    public String getOr_phone() {
        return or_phone;
    }

    public int getOr_id() {
        return or_id;
    }

    public int getU_id() {
        return u_id;
    }

    public int getD_id() {
        return d_id;
    }

    public int getOr_sum() {
        return or_sum;
    }

    public String getOr_memo() {
        return or_memo;
    }
    //设置可写属性

    public void setOr_phone(String  or_phone) {
        this.or_phone = or_phone;
    }

    public void setOr_id(int or_id) {
        this.or_id = or_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public void setOr_sum(int or_sum) {
        this.or_sum = or_sum;
    }

    public void setOr_memo(String or_memo) {
        this.or_memo = or_memo;
    }
}
