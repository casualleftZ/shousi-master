package comqwera.mingrisoft.shousi.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import comqwera.mingrisoft.shousi.model.Shopthing;
import comqwera.mingrisoft.shousi.model.Shopthing1;

public class Shopthing1DAO {
    private DBOPenHelper helper;     //创建DBOpenHelper对象
    private SQLiteDatabase db;       //创建SQLiteDatabase对象
    public Shopthing1DAO(Context context) {
        helper = new DBOPenHelper (context);           //初始化DBOpenHelper
        db = helper.getWritableDatabase ();            //初始化SQLiteDatabase
    }
    /**
     * 添加购物车表信息
     *
     * @param shopthing1
     */
    public void add(Shopthing1 shopthing1) {
        db = helper.getWritableDatabase ();//初始化SQLiteDatabase对象
        //执行添加购物车单信息操作
        db.execSQL ("insert into shopthing1(t_id,f_name,t_num," +
                "t_money,t_money_num) values(?,?,?,?,?)", new Object[]
                {
                        shopthing1.getT_id(),shopthing1.getF_name(),shopthing1.getT_num(),
                        shopthing1.getT_money(),shopthing1.getT_money_num()
                });
    }
    /**
     * 更新购物车表信息
     *
     * @param shopthing1
     */
    public void update(Shopthing1 shopthing1) {
        db = helper.getWritableDatabase ();//初始化SQLiteDatabase对象
        //执行修改购物车单信息操作
        db.execSQL ("update shopthing1 set t_id=?,t_num=?,t_money=?,t_money_num=? where f_name=?",

                new Object[]
                        {
                                shopthing1.getT_id(),shopthing1.getT_num(),shopthing1.getT_money(),
                                shopthing1.getT_money_num(),shopthing1.getF_name()
                        });
    }

    //通过f_name查找
    public Shopthing1 find(String i)
    {
        db=helper.getWritableDatabase ();//初始化SQLiteDatabase对象
        Cursor cursor=db.rawQuery ("select t_id,f_name,t_num,t_money,t_money_num from shopthing1 where f_name=?",
                new String[]
                        {String.valueOf (i)});
        if (cursor.moveToNext ())
        {
            //将遍历到的购物车单存储到 Myuser类中
            return new Shopthing1(cursor.getInt (cursor.getColumnIndex ("t_id")),
                    cursor.getString (cursor.getColumnIndex ("f_name")),
                    cursor.getInt (cursor.getColumnIndex ("t_num")),
                    cursor.getFloat (cursor.getColumnIndex ("t_money")),
                    cursor.getFloat (cursor.getColumnIndex ("t_money_num")));
        }
        return null;     //如果没有返回null
    }
    public Shopthing1 find2(int i)
    {
        db=helper.getWritableDatabase ();//初始化SQLiteDatabase对象
        Cursor cursor=db.rawQuery ("select t_id,f_name,t_num,t_money,t_money_num from shopthing1 where t_id=?",
                new String[]
                        {String.valueOf (i)});
        if (cursor.moveToNext ())
        {
            //将遍历到的购物车单存储到 Myuser类中
            return new Shopthing1(cursor.getInt (cursor.getColumnIndex ("t_id")),
                    cursor.getString (cursor.getColumnIndex ("f_name")),
                    cursor.getInt (cursor.getColumnIndex ("t_num")),
                    cursor.getFloat (cursor.getColumnIndex ("t_money")),
                    cursor.getFloat (cursor.getColumnIndex ("t_money_num")));
        }
        return null;     //如果没有返回null
    }
    public Shopthing1[] shopthingall(){
        db=helper.getWritableDatabase ();     //初始化SQLiteDatabase
        String sql="select * from shopthing1";
        Cursor cursor=db.rawQuery (sql, null);
        Shopthing1 shopthing1[]=new Shopthing1[cursor.getCount()];
        int i=0;
        while (cursor.moveToNext()){
            shopthing1[i]=new Shopthing1(cursor.getInt (cursor.getColumnIndex ("t_id")),
                    cursor.getString (cursor.getColumnIndex ("f_name")),
                    cursor.getInt (cursor.getColumnIndex ("t_num")),
                    cursor.getFloat (cursor.getColumnIndex ("t_money")),
                    cursor.getFloat (cursor.getColumnIndex ("t_money_num")));
            i++;
        }
        return shopthing1;
    }
    public int getMaxId() {
        db = helper.getWritableDatabase ();//初始化SQLiteDatabase
        Cursor cursor = db.rawQuery ("select max(t_id) from shopthing1", null);//获取菜单中最大的编号
        while (cursor.moveToLast ())//访问Cursor中的最后一条数据
        {
            return cursor.getInt (0);//获取访问到的数据，即最大编号
        }
        return 0;
    }
    public void detele(){
        db=helper.getWritableDatabase ();//初始化SQLiteDatabase对象
        Cursor cursor=db.rawQuery ("delete  from shopthing1 ",
                null);

    }
    public void detele2(Integer... ids)
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
            db.execSQL ("delete from shopthing1 where t_id in ("+sb+")", ids);
        }
    }
}
