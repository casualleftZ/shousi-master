package comqwera.mingrisoft.shousi.model;

public class Evaluate {
   private int e_id;      //定义评价id编号
   private int o_id;
   private int u_id;      //定义用户id编号
   private int f_id;      //定义菜品id编号
   private String e_allrating;  //定义用户评价
   private String e_imgurl;  //定义评论中附带图片
   private String e_statue;      //定义审核是否通过

public Evaluate(){
    super();
}
//定义有参构造函数，用来初始化评价实体类中的各个字段
public Evaluate(int e_id,int o_id,int u_id,int f_id,String e_allrating,String imgurl,String e_statue){
    this.e_id=e_id;               //给评价id号赋值
    this.o_id=o_id;
    this.u_id=u_id;               //给用户id号赋值
    this.f_id=f_id;               //给菜品id号赋值
    this.e_allrating=e_allrating;//给用户评论id号赋值
    this.e_imgurl=e_imgurl;//给评论中附带图片赋值
    this.e_statue=e_statue;      //定义审核是否通过
}
//设置可读属性

    public int getE_id() {
        return e_id;
    }

    public int getO_id() {
        return o_id;
    }

    public int getU_id() {
        return u_id;
    }

    public int getF_id() {
        return f_id;
    }

    public String getE_allrating() {
        return e_allrating;
    }

    public String getE_imgurl() {
        return e_imgurl;
    }

    public String getE_statue() {
        return e_statue;
    }
    //设置可写属性

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public void setO_id(int o_id) {
        this.o_id = o_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public void setF_id(int f_id) {
        this.f_id = f_id;
    }

    public void setE_allrating(String e_allrating) {
        this.e_allrating = e_allrating;
    }

    public void setE_imgurl(String e_imgurl) {
        this.e_imgurl = e_imgurl;
    }

    public void setE_statue(String e_statue) {
        this.e_statue = e_statue;
    }
}

