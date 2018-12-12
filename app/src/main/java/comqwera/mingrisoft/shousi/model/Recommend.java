package comqwera.mingrisoft.shousi.model;

public class Recommend {
    private int re_id;     //定义商家推荐表编号
    private String re_begintime;//定义推荐开始的时间
    private String re_endtime;     //定义推荐结束的时间
    private String re_url;      //定义推荐链接
    private String re_img;      //定义推荐图片
    private String re_contect; //定义推荐说明
    public Recommend(int re_id, int re_begintime, String re_endtime, String re_url, String re_img, String re_contect){
        super();
    }
    //定义有参构造函数，用来初始化商家推荐表实体类中的各个字段
    public Recommend(int re_id,int re_fid,String re_begintime,String re_endtime,
                     String re_url,String re_img,String re_contect){
        this.re_id=re_id;                   //给商家推荐表编号赋值
        this.re_begintime=re_begintime;    //给推荐开始的时间赋值
        this.re_endtime=re_endtime;        //给推荐结束的时间赋值
        this.re_url=re_url;                 //给商家推荐链接赋值
        this.re_img=re_img;                 //给商家推荐图片赋值
        this.re_contect=re_contect;         //给商家推荐说明赋值
    }
    //设置可读属性

    public int getRe_id() {
        return re_id;
    }

    public String getRe_begintime() {
        return re_begintime;
    }

    public String getRe_endtime() {
        return re_endtime;
    }

    public String getRe_url() {
        return re_url;
    }

    public String getRe_img() {
        return re_img;
    }

    public String getRe_contect() {
        return re_contect;
    }
    //设置可写属性

    public void setRe_id(int re_id) {
        this.re_id = re_id;
    }

    public void setRe_begintime(String re_begintime) {
        this.re_begintime = re_begintime;
    }

    public void setRe_endtime(String re_endtime) {
        this.re_endtime = re_endtime;
    }

    public void setRe_url(String re_url) {
        this.re_url = re_url;
    }

    public void setRe_img(String re_img) {
        this.re_img = re_img;
    }

    public void setRe_contect(String re_contect) {
        this.re_contect = re_contect;
    }
}
