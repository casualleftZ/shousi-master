package comqwera.mingrisoft.shousi.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


import comqwera.mingrisoft.shousi.model.Restaurant;

public class RestaurantDAO {
    private DBOPenHelper helper;//创建DBOpenHelper对象
    private SQLiteDatabase db;//创建SQLiteDatabase对象
    public RestaurantDAO(Context context)//定义构造函数
    {
        helper=new DBOPenHelper (context);//初始化DBOpenHelper对象
        db = helper.getWritableDatabase ();//初始化SQLiteDatabase对象
    }
    /**
     * 添加店面信息
     * @param restaurant
     */
    public void add(Restaurant restaurant){
        db=helper.getWritableDatabase ();//初始化SQLiteDatabase对象
        //执行添加用户信息操作
        db.execSQL ("insert into restaurant(r_id,r_password,r_name,r_opentime,r_address,r_phone,r_discription) values(?,?,?,?,?,?,?)",new Object[]
                {restaurant.getR_id (),restaurant.getR_password (),restaurant.getR_name (),restaurant.getR_opentime (),restaurant.getR_address (),
                        restaurant.getR_phone (),restaurant.getR_discription ()//执行添加用户信息操作

                });
    }
    /**
     * 更新店面信息
     *
     * @param restaurant
     */
    public void update(Restaurant restaurant){
        db=helper.getWritableDatabase ();//初始化SQLiteDatabase对象
        //执行修改收入信息操作
        db.execSQL ("update restaurant set r_id=?,r_password=?,r_name=?,r_opentime=?,r_address=?,r_phone=?,r_discription=? where r_id=?",

                new Object[]
                        {
                                restaurant.getR_id (),restaurant.getR_password (),restaurant.getR_name (),restaurant.getR_opentime (),restaurant.getR_address (),
                                restaurant.getR_phone (),restaurant.getR_discription ()
                        });
    }
    /**
     * 查找店面信息
     *
     * @param phone
     * @return
     */
    public  Restaurant find(String phone)
    {
        db=helper.getWritableDatabase ();//初始化SQLiteDatabase对象
        Cursor cursor=db.rawQuery ("select r_id,r_password,r_name,r_opentime,r_address," +
                        "r_phone,r_discription from restaurant where r_phone=?",
                new String[]
                        {String.valueOf (phone)});
        if (cursor.moveToNext ())
        {
            //将遍历到的收入信息存储到 Myuser类中
            return new Restaurant (cursor.getInt (cursor.getColumnIndex ("r_id")),
                    cursor.getString (cursor.getColumnIndex ("r_password")),
                    cursor.getString (cursor.getColumnIndex ("r_name")),
                    cursor.getString (cursor.getColumnIndex ("r_opentime")),
                    cursor.getString (cursor.getColumnIndex ("r_address")),
                    cursor.getString (cursor.getColumnIndex ("r_phone")),
                    cursor.getString (cursor.getColumnIndex ("r_discription")));
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
            db.execSQL ("delete from restaurant where r_id in ("+sb+")", ids);
        }
    }
    /**
     * 获取店家信息
     * @param start 起始位置
     * @param count 每页显示数量
     * @return
     */
    public List<Restaurant> getScrollData(int start, int count)
    {
        List<Restaurant> restaurant=new ArrayList<> ();//创建集合对象
        db=helper.getWritableDatabase ();          //初始化SQLiteDatabase
        Cursor cursor=db.rawQuery ("select * from restaurant limit ?,?",new String[]{String.valueOf (start),
                String.valueOf (count)});           //获取所有店家信息
        while (cursor.moveToNext ())               //遍历所有的遍历用户信息
        {
            restaurant.add (new Restaurant (cursor.getInt (cursor.getColumnIndex ("r_id")),
                    cursor.getString (cursor.getColumnIndex ("r_password")),
                    cursor.getString (cursor.getColumnIndex ("r_name")),
                    cursor.getString (cursor.getColumnIndex ("r_opentime")),
                    cursor.getString (cursor.getColumnIndex ("r_address")),
                    cursor.getString (cursor.getColumnIndex ("r_phone")),
                    cursor.getString (cursor.getColumnIndex ("r_discription"))));
        }
        return  restaurant;       //返回集合
    }
    /**
     * 获取总记录数
     *
     * @return
     */
    public long getCount() {
        db = helper.getWritableDatabase ();  //初始化SQLiteDatabase
        Cursor cursor = db.rawQuery ("select count(r_id)from restaurant", null);//获取饭店信息的记录数
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
        Cursor cursor = db.rawQuery ("select max(r_id) from restaurant", null);//获取饭店信息表中最大的编号
        while (cursor.moveToLast ())//访问Cursor中的最后一条数据
        {
            return cursor.getInt (0);//获取访问到的数据，即最大编号
        }
        return 0;
    }
}

