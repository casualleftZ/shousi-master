package comqwera.mingrisoft.shousi.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import comqwera.mingrisoft.shousi.model.Shopping_cart;
import comqwera.mingrisoft.shousi.model.Shopthing;

public class ShopthingDAO {
    private DBOPenHelper helper;     //创建DBOpenHelper对象
    private SQLiteDatabase db;       //创建SQLiteDatabase对象
    public ShopthingDAO(Context context) {
        helper = new DBOPenHelper (context);           //初始化DBOpenHelper
        db = helper.getWritableDatabase ();            //初始化SQLiteDatabase
    }
    /**
     * 添加购物车表信息
     *
     * @param shopthing
     */
    public void add(Shopthing shopthing) {
        db = helper.getWritableDatabase ();//初始化SQLiteDatabase对象
        //执行添加购物车单信息操作
        db.execSQL ("insert into myuser(t_id,f_name,t_num" +
                "t_money,t_money_number) values(?,?,?,?,?)", new Object[]
                {
                        shopthing.getT_id(),shopthing.getF_name(),shopthing.getT_num(),
                        shopthing.getT_money(),shopthing.getT_money_num()
                });
    }
    /**
     * 更新购物车表信息
     *
     * @param shopthing
     */
    public void update(Shopthing shopthing) {
        db = helper.getWritableDatabase ();//初始化SQLiteDatabase对象
        //执行修改购物车单信息操作
        db.execSQL ("update restaurant set t_num=?,t_money=?,t_money_number=? where t_id=?",

                new Object[]
                        {
                                shopthing.getT_id(),shopthing.getF_name(),shopthing.getT_num(),
                                shopthing.getT_money(),shopthing.getT_money_num()
                        });
    }
    //查找全部
    public Shopthing findall()
    {
        int i=0;
        db=helper.getWritableDatabase ();//初始化SQLiteDatabase对象

        Cursor cursor=db.rawQuery ("select t_id,f_name,t_num,t_money,t_money_number from shopthing",null);
        Shopthing shopthing[]=new Shopthing[getMaxId()];
        while (cursor.moveToNext ())
        {

            //将遍历到的购物车单存储到 Myuser类中
                      shopthing[i]=new  Shopthing(cursor.getInt (cursor.getColumnIndex ("t_id")),
                    cursor.getString (cursor.getColumnIndex ("f_name")),
                    cursor.getInt (cursor.getColumnIndex ("T_num")),
                    cursor.getFloat (cursor.getColumnIndex ("t_money")),
                    cursor.getFloat (cursor.getColumnIndex ("t_money_number")));
                      i++;
        }
        return null;     //如果没有返回null
    }
    //通过f_name查找
    public Shopping_cart find(int id)
    {
        db=helper.getWritableDatabase ();//初始化SQLiteDatabase对象
        Cursor cursor=db.rawQuery ("select s_id,f_id,u_id,s_num,s_time where u_id=?",
                new String[]
                        {String.valueOf (id)});
        if (cursor.moveToNext ())
        {
            //将遍历到的购物车单存储到 Myuser类中
            return new Shopping_cart(cursor.getInt (cursor.getColumnIndex ("u_id")),
                    cursor.getInt (cursor.getColumnIndex ("f_id")),
                    cursor.getInt (cursor.getColumnIndex ("u_id")),
                    cursor.getInt (cursor.getColumnIndex ("s_num")),
                    cursor.getString (cursor.getColumnIndex ("s_time")));
        }
        return null;     //如果没有返回null
    }
    public int getMaxId() {
        db = helper.getWritableDatabase ();//初始化SQLiteDatabase
        Cursor cursor = db.rawQuery ("select max(t_id) from shopthing", null);//获取菜单中最大的编号
        while (cursor.moveToLast ())//访问Cursor中的最后一条数据
        {
            return cursor.getInt (0);//获取访问到的数据，即最大编号
        }
        return 0;
    }
}
