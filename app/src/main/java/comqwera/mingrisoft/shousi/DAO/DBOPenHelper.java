package comqwera.mingrisoft.shousi.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOPenHelper extends SQLiteOpenHelper {
    private static final int VERISON = 1;       //定义数据库版本号
    private static final String DBNAME = "account.db";//定义数据库名字

    public DBOPenHelper(Context context)    //定义构造函数
    {
        super (context, DBNAME, null, VERISON);//重写基类的构造函数
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL ("create table myuser(u_id int primary key,u_loginid int,u_nickname varchar(30),u_password varchar(31),u_phone varchar(11)," +
                "u_sex bit,u_headportrait varchar(100),u_vip bit,u_address varchar(100))");//创建用户信息表
        db.execSQL ("create table restaurant(r_id int primary key,r_password varchar(20),r_name varchar(12),r_opentime date,r_address varchar(30),r_phone varchar(11)," +
                "r_discription varchar(100))");//创建商家信息表
        db.execSQL ("create table food(f_id int primary key,f_name varchar(12),f_url varchar(100),f_price float,f_dprice float,f_sellcount float)");//菜品表
        db.execSQL ("create table shopping_cart(s_id integer primary key,f_id int,u_id int,s_num int,s_time date)");//购物车表
        db.execSQL ("create table order_cart(o_id int primary key,u_id int,o_orderdate date,o_memo varchar(100),o_statue varchar(12),o_phone varchar(11),o_totle float," +
                "o_dis float,o_paymethod varchar(20),o_paytime date,o_paystatue bit,o_adress verchar(100))");//订单表
        db.execSQL ("create table evaluate(e_id int primary key,o_id int,u_id int,f_id int,e_allrating,e_imgurl varchar(100),e_statue bit)");//评价表
        db.execSQL ("create table recommend(re_id int primary key,re_begintime date,re_endtime date,re_url varchar(100),re_img varchar(100)" +
                ",re_contect varchar(100))");//推荐说明
        db.execSQL ("create table onlineorder(or_id int primary key,u_id int,or_phone String,d_id int,or_sum string,or_time varchar(20),or_memo varchar(30))");//在线预订表
        db.execSQL("create table login(zt_id int primary key,ZT int)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}