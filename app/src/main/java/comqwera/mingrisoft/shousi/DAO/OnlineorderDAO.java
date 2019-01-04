package comqwera.mingrisoft.shousi.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


import comqwera.mingrisoft.shousi.model.Food;
import comqwera.mingrisoft.shousi.model.Onlineorder;

public class OnlineorderDAO {
    private DBOPenHelper helper;     //创建DBOpenHelper对象
    private SQLiteDatabase db;       //创建SQLiteDatabase对象
    public OnlineorderDAO(Context context){
        helper=new DBOPenHelper (context);           //初始化DBOpenHelper
        db=helper.getWritableDatabase ();            //初始化SQLiteDatabase
    }
    /**
     * 添加用户信息
     * @param onlineorder
     */
    public void add(Onlineorder onlineorder){
        db=helper.getWritableDatabase ();//初始化SQLiteDatabase对象
        //执行添加用户信息操作
        db.execSQL ("insert into onlineorder(or_id,u_id,or_phone,d_id,or_sum,or_time,or_memo) values(?,?,?,?,?,?,?)",new Object[]
                {
                        onlineorder.getOr_id (),
                        onlineorder.getU_id (),
                        onlineorder.getOr_phone(),
                        onlineorder.getD_id (),
                        onlineorder.getOr_sum (),
                        onlineorder.getOr_time(),
                        onlineorder.getOr_memo ()
                });
    }
    /**
     * 更新用户信息
     *
     * @param onlineorder
     */
    public void update(Onlineorder onlineorder){
        db=helper.getWritableDatabase ();//初始化SQLiteDatabase对象
        //执行修改收入信息操作
        db.execSQL ("update onlineorder set or_id=?,u_id=?,or_phone=?,d_id=?,or_sum=?,or_time=?,or_memo=? where or_id=?",
                new Object[]
                        {
                                onlineorder.getOr_id (),onlineorder.getU_id (),onlineorder.getOr_phone(),onlineorder.getD_id (),onlineorder.getOr_sum (),onlineorder.getOr_memo ()
                        });
    }
    /**
     * 查找用户信息
     *
     * @param
     * @return
     */
    public Onlineorder[] find2()
    {
        db=helper.getWritableDatabase ();     //初始化SQLiteDatabase对象
        Cursor cursor=db.rawQuery ("select * from onlineorder",
                null);
        Onlineorder onlineorder[]=new  Onlineorder[cursor.getCount()];
        int i=0;
        while (cursor.moveToNext ())

        {
            //将遍历到的收入信息存储到food类中
            onlineorder[i]=new  Onlineorder (cursor.getInt (cursor.getColumnIndex ("or_id")),
                    cursor.getInt (cursor.getColumnIndex ("u_id")),
                    cursor.getString (cursor.getColumnIndex ("or_phone")),
                    cursor.getInt (cursor.getColumnIndex ("d_id")),
                    cursor.getString (cursor.getColumnIndex ("or_sum")),
                    cursor.getString (cursor.getColumnIndex ("or_time")),
                    cursor.getString (cursor.getColumnIndex ("or_memo")));
            i++;
        }
        return onlineorder;
    }
    public  Onlineorder find(int id)
    {
        db=helper.getWritableDatabase ();//初始化SQLiteDatabase对象
        Cursor cursor=db.rawQuery ("select * from onlineorder where or_id=? ",
                new String[]
                        {String.valueOf (id)});
        if (cursor.moveToNext ())
        {
            //将遍历到的收入信息存储到 Myuser类中
            return new Onlineorder (cursor.getInt (cursor.getColumnIndex ("or_id")),
                    cursor.getInt (cursor.getColumnIndex ("u_id")),
                    cursor.getString (cursor.getColumnIndex ("or_phone")),
                    cursor.getInt (cursor.getColumnIndex ("d_id")),
                    cursor.getString (cursor.getColumnIndex ("or_sum")),
                    cursor.getString (cursor.getColumnIndex ("or_time")),
                    cursor.getString (cursor.getColumnIndex ("or_memo")));
        }
        return null;     //如果没有返回null
    }
    /**
     * 查找用户信息
     *
     * @param id
     * @return
     */
    public  Onlineorder find2(int id)
    {
        db=helper.getWritableDatabase ();//初始化SQLiteDatabase对象
        Cursor cursor=db.rawQuery ("select * from onlineorder where u_id=? ",
                new String[]
                        {String.valueOf (id)});
        if (cursor.moveToNext ())
        {
            //将遍历到的收入信息存储到 Myuser类中
            return new Onlineorder (cursor.getInt (cursor.getColumnIndex ("or_id")),
                    cursor.getInt (cursor.getColumnIndex ("u_id")),
                    cursor.getString (cursor.getColumnIndex ("or_phone")),
                    cursor.getInt (cursor.getColumnIndex ("d_id")),
                    cursor.getString (cursor.getColumnIndex ("or_sum")),
                    cursor.getString (cursor.getColumnIndex ("or_time")),
                    cursor.getString (cursor.getColumnIndex ("or_memo")));
        }
        return null;     //如果没有返回null
    }
    /**
     * 删除在线订单信息
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
            db.execSQL ("delete from onlineorder where or_id in ("+sb+")", ids);
        }
    }
    /**
     * 获取用户信息
     * @param start 起始位置
     * @param count 每页显示数量
     * @return
     */
    public List<Onlineorder> getScrollData(int start, int count)
    {
        List<Onlineorder>onlineorder=new ArrayList<Onlineorder> ();//创建集合对象
        db=helper.getWritableDatabase ();          //初始化SQLiteDatabase
        Cursor cursor=db.rawQuery ("select * from onlineorder limit ?,?",new String[]{String.valueOf (start),
                String.valueOf (count)});           //获取所有用户信息
        while (cursor.moveToNext ())               //遍历所有的遍历用户信息
        {
            onlineorder.add (new Onlineorder (cursor.getInt (cursor.getColumnIndex ("or_id")),
                    cursor.getInt (cursor.getColumnIndex ("u_id")),
                    cursor.getString (cursor.getColumnIndex ("or_phone")),
                    cursor.getInt (cursor.getColumnIndex ("d_id")),
                    cursor.getString (cursor.getColumnIndex ("or_sum")),
                    cursor.getString (cursor.getColumnIndex ("or_time")),
                    cursor.getString (cursor.getColumnIndex ("or_memo"))));
        }
        return  onlineorder;       //返回集合
    }
    /**
     * 获取总记录数
     *
     * @return
     */
    public long getCount() {
        db = helper.getWritableDatabase ();  //初始化SQLiteDatabase
        Cursor cursor = db.rawQuery ("select count(or_id)from onlineorder", null);//获取收入信息的记录数
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
        Cursor cursor = db.rawQuery ("select max(or_id) from onlineorder", null);//获取收入信息表中最大的编号
        while (cursor.moveToLast ())//访问Cursor中的最后一条数据
        {
            return cursor.getInt (0);//获取访问到的数据，即最大编号
        }
        return 0;
    }
}