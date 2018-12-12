package comqwera.mingrisoft.shousi.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import comqwera.mingrisoft.shousi.model.Shopping_cart;

public class Shopping_cartDAO {
    private DBOPenHelper helper;     //创建DBOpenHelper对象
    private SQLiteDatabase db;       //创建SQLiteDatabase对象

    public Shopping_cartDAO(Context context) {
        helper = new DBOPenHelper (context);           //初始化DBOpenHelper
        db = helper.getWritableDatabase ();            //初始化SQLiteDatabase
    }

    /**
     * 添加购物车表信息
     *
     * @param shopping_cart
     */
    public void add(Shopping_cart shopping_cart) {
        db = helper.getWritableDatabase ();//初始化SQLiteDatabase对象
        //执行添加购物车单信息操作
        db.execSQL ("insert into myuser(s_id,f_id,u_id" +
                "s_num,s_time) values(?,?,?,?,?)", new Object[]
                {
                        shopping_cart.getS_id (), shopping_cart.getF_id (), shopping_cart.getU_id (),
                        shopping_cart.getS_num (), shopping_cart.getS_time ()
                });
    }

    /**
     * 更新购物车表信息
     *
     * @param shopping_cart
     */
    public void update(Shopping_cart shopping_cart) {
        db = helper.getWritableDatabase ();//初始化SQLiteDatabase对象
        //执行修改购物车单信息操作
        db.execSQL ("update restaurant set s_id=?,f_id=?,u_id=?,s_num=?,s_time=? where s_id=?",

                new Object[]
                        {
                                shopping_cart.getS_id (), shopping_cart.getF_id (), shopping_cart.getU_id (),
                                shopping_cart.getS_num (), shopping_cart.getS_time ()
                        });
    }
/**
 *查找购物车单信息
 *
 * @param id
 *
 */
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
/**
 * 删除购物车信息
 *
 * @param ids
 */
public void detele(Integer... ids)
{                                                   //判断是否纯在要删除的id
    if(ids.length>0)
    {
        StringBuffer sb=new StringBuffer ();        //创建StringBuffer对象
        for(int i=0;i<ids.length;i++)              //遍历要删除的id集合
        {
            sb.append ('?').append (',');           //将删除条件添加到StringBuffer对象中
        }
        sb.deleteCharAt (sb.length ()-1);            //去掉最后一个","字符
        db=helper.getWritableDatabase ();           //初始化SQLiteDatabase对象
        //执行删除用户信息操作
        db.execSQL ("delete from shopping_cart where r_id in ("+sb+")", ids);
    }
}
    /**
     * 获取购物车单信息
     * @param start 起始位置
     * @param count 每页显示数量
     * @return
     */
    public List<Shopping_cart> getScrollData(int start, int count)
    {
        List<Shopping_cart> shopping_cart=new ArrayList<> ();//创建集合对象
        db=helper.getWritableDatabase ();          //初始化SQLiteDatabase
        Cursor cursor=db.rawQuery ("select * from restaurant limit ?,?",new String[]{String.valueOf (start),
                String.valueOf (count)});           //获取所有店家信息
        while (cursor.moveToNext ())               //遍历所有的遍历用户信息
        {
            shopping_cart.add (new Shopping_cart(cursor.getInt (cursor.getColumnIndex ("s_id")),
                    cursor.getInt(cursor.getColumnIndex ("f_id")),
                    cursor.getInt(cursor.getColumnIndex ("u_id")),
                    cursor.getInt(cursor.getColumnIndex ("s_num")),
                    cursor.getString (cursor.getColumnIndex ("s_time"))));
        }
        return shopping_cart;       //返回集合
    }
    /**
     * 获取总记录数
     *
     * @return
     */
    public long getCount() {
        db = helper.getWritableDatabase ();  //初始化SQLiteDatabase
        Cursor cursor = db.rawQuery ("select count(s_id)from shopping_cart", null);//获取购物车单信息的记录数
        if (cursor.moveToNext ()) {
            return cursor.getLong (0);
        }
        return 0;
    }

    /**
     * 获取最大编号
     *
     * @return
     */
    public int getMaxId() {
        db = helper.getWritableDatabase ();//初始化SQLiteDatabase
        Cursor cursor = db.rawQuery ("select max(s_id) from shopping_cart", null);//获取购物车单中最大的编号
        while (cursor.moveToLast ())//访问Cursor中的最后一条数据
        {
            return cursor.getInt (0);//获取访问到的数据，即最大编号
        }
        return 0;
    }
}