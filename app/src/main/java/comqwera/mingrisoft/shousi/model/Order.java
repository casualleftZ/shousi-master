package comqwera.mingrisoft.shousi.model;

public class Order {
    private String use_name;
    private String use_dingdanxinxi;
    private int dingdan_id;
    private float dingdan_money;
    private String user_address;
    public Order(int dingdan_id, String use_name, String use_dingdanxinxi,
                 String user_address, float dingdan_money){

        this.dingdan_id=dingdan_id;
        this.use_name=use_name;
        this.use_dingdanxinxi=use_dingdanxinxi;
        this.user_address=user_address;
        this.dingdan_money=dingdan_money;
    }

    public String getUse_name() {
        return use_name;
    }

    public String getUse_dingdanxinxi() {
        return use_dingdanxinxi;
    }

    public int getDingdan_id() {
        return dingdan_id;
    }

    public float getDingdan_money() {
        return dingdan_money;
    }

    public String getUser_address() {
        return user_address;
    }
}
