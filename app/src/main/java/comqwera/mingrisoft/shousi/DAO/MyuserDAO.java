package comqwera.mingrisoft.shousi.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


import comqwera.mingrisoft.shousi.model.Myuser;


public class MyuserDAO {
    private DBOPenHelper helper;//创建DBOpenHelper对象
    private SQLiteDatabase db;//创建SQLiteDatabase对象
    public MyuserDAO(Context context)//定义构造函数
    {
        helper=new DBOPenHelper (context);//初始化DBOpenHelper对象
        db = helper.getWritableDatabase ();//初始化SQLiteDatabase对象
    }
/**
 * 添加用户信息
 * @param myuser
  */
public void add(Myuser myuser){
    db=helper.getWritableDatabase ();//初始化SQLiteDatabase对象
    //执行添加用户信息操作
    db.execSQL ("insert into myuser(u_id,u_loginid,u_nickname,u_password,u_phone," +
            "u_sex,u_headportrait,u_vip,u_address) values(?,?,?,?,?,?,?,?,?)",new Object[]
            {myuser.getU_id(),myuser.getU_loinid(),myuser.getU_nickname(), myuser.getU_password (),
                    myuser.getU_phone (),myuser.getU_adress (),myuser.getU_headportrait (),myuser.getU_sex (),
                    myuser.getU_vip ()//执行添加用户信息操作

    });
}
/**
 * 更新用户信息
 *
 * @param myuser
 */
public void update(Myuser myuser){
    db=helper.getWritableDatabase ();//初始化SQLiteDatabase对象
    //执行修改收入信息操作
    db.execSQL ("update myuser set u_id=?,u_loginid=?,u_nickname=?,u_password=?,u_phone=?," +
            "u_sex=?,u_headportrait=?,u_vip=?,u_address=?",
    new Object[]
    {
        myuser.getU_id(),myuser.getU_loinid(),myuser.getU_nickname(), myuser.getU_password (),
                myuser.getU_phone (),myuser.getU_adress (),myuser.getU_headportrait (),myuser.getU_sex (),
                myuser.getU_vip ()
    });
}
/**
 * 查找用户信息
 *
 * @param
 * @return
 */
public Myuser find(String phone)
{
    db=helper.getWritableDatabase ();//初始化SQLiteDatabase对象
    Cursor cursor=db.rawQuery ("select u_id,u_loginid,u_nickname,u_password,u_phone,"+
            " u_sex,u_headportrait,u_vip,u_address from Myuser where u_phone=?",
            new String[]
                    {String.valueOf (phone)});

    if (cursor.moveToNext ())
    {
        //将遍历到的收入信息存储到 Myuser类中
        return new Myuser (cursor.getInt (cursor.getColumnIndex ("u_id")),
                cursor.getInt (cursor.getColumnIndex ("u_loginid")),
                cursor.getString (cursor.getColumnIndex ("u_nickname")),
                cursor.getString (cursor.getColumnIndex ("u_password")),
                cursor.getString (cursor.getColumnIndex ("u_phone")),
                cursor.getString (cursor.getColumnIndex ("u_sex")),
                cursor.getString (cursor.getColumnIndex ("u_vip")),
                cursor.getString (cursor.getColumnIndex ("u_headportrait")),
                cursor.getString (cursor.getColumnIndex ("u_address")));
    }
           return null;     //如果没有返回null
}
/**
 * 删除用户信息
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
        db.execSQL ("delete from myuser where u_id in ("+sb+")", ids);
    }
}
/**
 * 获取用户信息
 * @param start 起始位置
 * @param count 每页显示数量
 * @return
 */
public List<Myuser>getScrollData(int start,int count)
{
     List<Myuser>myuser=new ArrayList<Myuser> ();//创建集合对象
     db=helper.getWritableDatabase ();          //初始化SQLiteDatabase
     Cursor cursor=db.rawQuery ("select * from myuser limit ?,?",new String[]{String.valueOf (start),
             String.valueOf (count)});           //获取所有用户信息
     while (cursor.moveToNext ())               //遍历所有的遍历用户信息
     {
         myuser.add (new Myuser (cursor.getInt (cursor.getColumnIndex ("u_id")),
                 cursor.getInt (cursor.getColumnIndex ("u_loginid")),
                 cursor.getString (cursor.getColumnIndex ("u_nickname")),
                 cursor.getString (cursor.getColumnIndex ("u_password")),
                 cursor.getString (cursor.getColumnIndex ("u_phone")),
                 cursor.getString (cursor.getColumnIndex ("u_sex")),
                 cursor.getString (cursor.getColumnIndex ("u_vip")),
                 cursor.getString (cursor.getColumnIndex ("u_headportrait")),
                 cursor.getString (cursor.getColumnIndex ("u_address"))));
     }
     return  myuser;       //返回集合
}
    /**
     * 获取总记录数
     *
     * @return
     */
    public long getCount() {
        db = helper.getWritableDatabase ();  //初始化SQLiteDatabase
        Cursor cursor = db.rawQuery ("select count(u_id)from myuser", null);//获取收入信息的记录数
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
        Cursor cursor = db.rawQuery ("select max(u_id) from myuser", null);//获取收入信息表中最大的编号
        while (cursor.moveToLast ())//访问Cursor中的最后一条数据
        {
            return cursor.getInt (0);//获取访问到的数据，即最大编号
        }
        return 0;
    }

}
