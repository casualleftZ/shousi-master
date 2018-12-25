package comqwera.mingrisoft.shousi.model;

public class Shopthing {
    private int t_id;    //定义商品id
    private String f_name; //定义商品名字
    private int t_num;    //定义商品数目
    private float t_money;   //定义商品价格
    private float t_money_num;  //定义商品总共价钱
    public Shopthing(){
        super();
    }
    public Shopthing(int t_id,String f_name,int t_num, float t_money,float t_money_num){
        this.t_id=t_id;   //赋值
        this.f_name=f_name;
        this.t_num=t_num;
        this.t_money=t_money;
        this.t_money_num=t_money_num;
    }
    //可读属性

    public int getT_id() {
        return t_id;
    }

    public String getF_name() {
        return f_name;
    }

    public int getT_num() {
        return t_num;
    }

    public float getT_money() {
        return t_money;
    }

    public float getT_money_num() {
        return t_money_num;
    }
    //可写属性

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public void setT_num(int t_num) {
        this.t_num = t_num;
    }

    public void setT_money(float t_money) {
        this.t_money = t_money;
    }

    public void setT_money_num(float t_money_num) {
        this.t_money_num = t_money_num;
    }
}
