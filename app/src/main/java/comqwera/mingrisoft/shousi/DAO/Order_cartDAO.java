package comqwera.mingrisoft.shousi.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


import comqwera.mingrisoft.shousi.model.Order_cart;

public class Order_cartDAO {
    private DBOPenHelper helper;     //创建DBOpenHelper对象
    private SQLiteDatabase db;       //创建SQLiteDatabase对象
    public Order_cartDAO(Context context)
    {
        helper=new DBOPenHelper (context);           //初始化DBOpenHelper
        db=helper.getWritableDatabase ();            //初始化SQLiteDatabase
    }
    /**
     * 添加食物信息
     *
     * @param order_cart
     */
    public void add(Order_cart order_cart)
        {
        db=helper.getWritableDatabase ();         //初始化SQLiteDatabase
        //执行添加食物信息操作
        db.execSQL ("insert into order_cart(o_id,u_id,o_orderdate,o_memo,o_statue,o_phone," +
                        "o_totle,o_dis,o_paymethod,o_paytime,o_paystatue,o_address) values (?,?,?,?,?,?,?,?,?,?,?,?)",
                new Object[]
                        {
                                order_cart.getO_id (),order_cart.getU_id (),order_cart.getO_orderdate (),
                                order_cart.getO_memo (),order_cart.getO_statue (), order_cart.getO_phone (),
                                order_cart.getO_dis (),order_cart.getO_totle (),order_cart.getO_paymethod (),
                                order_cart.getO_paytime (),order_cart.getO_paystatue (),order_cart.getO_address ()});
    }
    /**
     * 更新食物信息
     *
     * @param order_cart
     */
    public void update(Order_cart order_cart)
    {
        db=helper.getWritableDatabase ();            //初始化SQLiteDatabase对象
        //执行修改食物信息操作
        db.execSQL ("update order_cart set o_id=?,u_id=?,o_orderdate=?,o_memo=?,o_statue=?,o_phone=?,o_totle=?," +
                        "o_dis=?,o_paymethod=?,o_paytime=?,o_paystatue=?,o_address=? where _id=?",
                new Object[]
                        {
                                order_cart.getO_id (),order_cart.getU_id (),order_cart.getO_orderdate (),
                                order_cart.getO_memo (),order_cart.getO_statue (), order_cart.getO_phone (),
                                order_cart.getO_dis (),order_cart.getO_totle (),order_cart.getO_paymethod (),
                                order_cart.getO_paytime (),order_cart.getO_paystatue (),order_cart.getO_address ()
                        });
    }
    /**
     * 查找食物信息
     *
     * @param id
     * @return
     */
    public Order_cart find(int id)
    {
        db=helper.getWritableDatabase ();     //初始化SQLiteDatabase对象
        Cursor cursor=db.rawQuery ("select o_id,u_id,o_orderdate,o_memo,o_statue,o_phone," +
                        "o_dis=?,o_paymethod=?,o_paytime=?,o_paystatue=?,o_address=? from order_cart where o_id ",
                new String[]{
                        String.valueOf (id),        //更具食物名称,或者编号,查找食物信息，并存储
                });
        if (cursor.moveToNext ())
        {
            //将遍历到的收入信息存储到food类中
            return new Order_cart (cursor.getInt (cursor.getColumnIndex ("o_id")),
                    cursor.getInt (cursor.getColumnIndex ("u_id")),
                    cursor.getString (cursor.getColumnIndex ("o_orderdate")),
                    cursor.getString (cursor.getColumnIndex ("o_memo")),
                    cursor.getString (cursor.getColumnIndex ("o_statue")),
                    cursor.getString (cursor.getColumnIndex ("o_phone")),
                    cursor.getFloat (cursor.getColumnIndex ("o_totle")),
                    cursor.getFloat (cursor.getColumnIndex ("o_dis")),
                    cursor.getString (cursor.getColumnIndex ("o_paymethod")),
                    cursor.getString (cursor.getColumnIndex ("o_paytime")),
                    cursor.getString (cursor.getColumnIndex ("o_paystatue")),
                    cursor.getString (cursor.getColumnIndex ("o_address")));
        }
        return null;
    }

    /**
     * 删除食物信息
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
            db.execSQL ("delete from order_cart where o_id in ("+sb+")", ids);
        }
    }
    /**
     * 获取食物信息
     * @param start 起始位置
     * @param count 每页显示数量
     * @return
     */
    public List<Order_cart>getScrollData(int start,int count)
    {
        List<Order_cart>order_cart=new ArrayList<Order_cart> (); //创建集合对象
        db=helper.getWritableDatabase ();     //初始化SQLiteDatabase
        Cursor cursor=db.rawQuery ("select * from order_cart limit ?,?", new String[]{
                String.valueOf (start),String.valueOf (count)
        });
        while (cursor.moveToNext ())
        {
            order_cart.add (new Order_cart(cursor.getInt (cursor.getColumnIndex ("o_id")),
                    cursor.getInt (cursor.getColumnIndex ("u_id")),
                    cursor.getString (cursor.getColumnIndex ("o_orderdate")),
                    cursor.getString (cursor.getColumnIndex ("o_memo")),
                    cursor.getString (cursor.getColumnIndex ("o_statue")),
                    cursor.getString (cursor.getColumnIndex ("o_phone")),
                    cursor.getFloat (cursor.getColumnIndex ("o_totle")),
                    cursor.getFloat (cursor.getColumnIndex ("o_dis")),
                    cursor.getString (cursor.getColumnIndex ("o_paymethod")),
                    cursor.getString (cursor.getColumnIndex ("o_paytime")),
                    cursor.getString (cursor.getColumnIndex ("o_paystatue")),
                    cursor.getString (cursor.getColumnIndex ("o_address"))));
        }
        return order_cart;
    }
    /**
     * 获取总记录数
     *
     * @return
     */
    public long getCount() {
        db = helper.getWritableDatabase ();  //初始化SQLiteDatabase
        Cursor cursor = db.rawQuery ("select count(o_id)from order_cart", null);//获取订单表的记录数
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
        Cursor cursor = db.rawQuery ("select max(o_id) from order_cart", null);//获取订单表中最大的编号
        while (cursor.moveToLast ())//访问Cursor中的最后一条数据
        {
            return cursor.getInt (0);//获取访问到的数据，即最大编号
        }
        return 0;
    }
}