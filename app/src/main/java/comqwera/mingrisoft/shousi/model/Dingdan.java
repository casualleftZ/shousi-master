package comqwera.mingrisoft.shousi.model;

public class Dingdan {
    private int d_id;
    private int u_id;
    private String d_thing;
    private String d_address;
    public Dingdan(){
        super();
    }
    public Dingdan(int d_id,int u_id,String d_thing,String d_address){
       this.d_id=d_id;
       this.u_id=u_id;
       this.d_thing=d_thing;
       this.d_address=d_address;
    }

    public int getD_id() {
        return d_id;
    }

    public int getU_id() {
        return u_id;
    }

    public String getD_thing() {
        return d_thing;
    }

    public String getD_address() {
        return d_address;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public void setD_thing(String d_thing) {
        this.d_thing = d_thing;
    }

    public void setD_address(String d_address) {
        this.d_address = d_address;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }
}
