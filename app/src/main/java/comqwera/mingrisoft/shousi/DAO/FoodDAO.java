package comqwera.mingrisoft.shousi.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


import comqwera.mingrisoft.shousi.model.Food;

public class FoodDAO {
    private DBOPenHelper helper;     //创建DBOpenHelper对象
    private SQLiteDatabase db;       //创建SQLiteDatabase对象
    public FoodDAO(Context context)
    {
        helper=new DBOPenHelper (context);           //初始化DBOpenHelper
        db=helper.getWritableDatabase ();            //初始化SQLiteDatabase
    }
/**
 * 添加食物信息
 *
 * @param food
 */
public void add(Food food)
{
    db=helper.getWritableDatabase ();         //初始化SQLiteDatabase
    //执行添加食物信息操作
    db.execSQL ("insert into food (f_id,f_name,f_url,f_price,f_dprice,f_sellcount) values (?,?,?,?,?,?)",
            new Object[]
                    {
                            food.getF_id (),food.getF_name (),food.getF_url (),food.getF_price (),food.getF_dprice (),
                            food.getF_sellcount ()
                    });
}
/**
 * 更新食物信息
 *
 * @param food
 */
public void update(Food food)
{
    db=helper.getWritableDatabase ();            //初始化SQLiteDatabase对象
    //执行修改食物信息操作
    db.execSQL ("update food set f_id=?,f_name=?,f_url=?,f_price=?,f_dprice=?,f_sellcount=? where _id=?",
    new Object[]
            {
                    food.getF_id (),food.getF_name (),food.getF_url (),food.getF_price (),food.getF_dprice ()
                    ,food.getF_sellcount ()
            });
}
/**
 * 查找食物信息
 *
 * @param id
 * @param name
 * @return
 */
public  Food find(int id,String name)
{
    db=helper.getWritableDatabase ();     //初始化SQLiteDatabase对象
    Cursor cursor=db.rawQuery ("select f_id,f_name,f_url,f_price,f_dprice,f_sellcount from food where f_name=? or f_id ",
            new String[]{
            String.valueOf (id),String.valueOf (name)        //更具食物名称,或者编号,查找食物信息，并存储
            });
    if (cursor.moveToNext ())
    {
        //将遍历到的收入信息存储到food类中
        return new Food (cursor.getInt (cursor.getColumnIndex ("f_id")),
                cursor.getString (cursor.getColumnIndex ("f_name")),
                cursor.getString (cursor.getColumnIndex ("f_url")),
                cursor.getFloat (cursor.getColumnIndex ("f_price")),
                cursor.getFloat (cursor.getColumnIndex ("f_dprice")),
                cursor.getInt (cursor.getColumnIndex ("f_sellcount")));
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
            db.execSQL ("delete from food where f_id in ("+sb+")", ids);
        }
    }
/**
 * 获取食物信息
 * @param start 起始位置
 * @param count 每页显示数量
 * @return
 */
public List<Food>getScrollData(int start,int count)
{
    List<Food>food=new ArrayList<Food> (); //创建集合对象
    db=helper.getWritableDatabase ();     //初始化SQLiteDatabase
    Cursor cursor=db.rawQuery ("select * from food limit ?,?", new String[]{
            String.valueOf (start),String.valueOf (count)
    });
    while (cursor.moveToNext ())
    {
        food.add (new Food (cursor.getInt (cursor.getColumnIndex ("f_id")),
                cursor.getString (cursor.getColumnIndex ("f_name")),
                cursor.getString (cursor.getColumnIndex ("f_url")),
                cursor.getFloat (cursor.getColumnIndex ("f_price")),
                cursor.getFloat (cursor.getColumnIndex ("f_dprice")),
                cursor.getInt (cursor.getColumnIndex ("f_sellcount"))));
    }
    return food;
}
    /**
     * 获取总记录数
     *
     * @return
     */
    public long getCount() {
        db = helper.getWritableDatabase ();  //初始化SQLiteDatabase
        Cursor cursor = db.rawQuery ("select count(f_id)from food", null);//获取菜单信息的记录数
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
        Cursor cursor = db.rawQuery ("select max(f_id) from food", null);//获取菜单中最大的编号
        while (cursor.moveToLast ())//访问Cursor中的最后一条数据
        {
            return cursor.getInt (0);//获取访问到的数据，即最大编号
        }
        return 0;
    }
}

