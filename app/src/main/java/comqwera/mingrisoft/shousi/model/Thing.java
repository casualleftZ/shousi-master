package comqwera.mingrisoft.shousi.model;

public class Thing {
    private int f_url;  //定义图片
    private String f_name;  //定义食物名称
    private float f_price;  //定义食物价格
    private int f_sellcount; //定义食物销量
    public Thing(int f_url,String f_name,float f_price,int f_sellcount){
        this.f_url=f_url;
        this.f_name=f_name;
        this.f_price=f_price;
        this.f_sellcount=f_sellcount;
    }

    public int getF_url() {
        return f_url;
    }

    public String getF_name() {
        return f_name;
    }

    public float getF_price() {
        return f_price;
    }

    public int getF_sellcount() {
        return f_sellcount;
    }
}
