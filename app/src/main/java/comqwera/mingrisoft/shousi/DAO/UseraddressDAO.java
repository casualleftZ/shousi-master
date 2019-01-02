package comqwera.mingrisoft.shousi.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import comqwera.mingrisoft.shousi.model.Useraddress;

public class UseraddressDAO {
    private DBOPenHelper helper;     //创建DBOpenHelper对象
    private SQLiteDatabase db;       //创建SQLiteDatabase对象

    public UseraddressDAO(Context context) {
        helper = new DBOPenHelper (context);           //初始化DBOpenHelper
        db = helper.getWritableDatabase ();            //初始化SQLiteDatabase
    }
    /**
     * 添加购物车表信息
     *
     * @param useraddress
     */
    public void add(Useraddress useraddress) {
        db = helper.getWritableDatabase ();//初始化SQLiteDatabase对象
        //执行添加购物车单信息操作
        db.execSQL ("insert into useraddress(a_id,u_id,a_name," +
                "a_phone,a_weizhi,a_menhao) values(?,?,?,?,?,?)", new Object[]
                {
                 useraddress.getA_id(),useraddress.getU_id(),useraddress.getA_name(),
                        useraddress.getA_phone(),useraddress.getA_weizhi(),
                        useraddress.getA_menhao()
                });
    }
    /**
     * 更新购物车表信息
     *
     * @param useraddress
     */
    public void update(Useraddress useraddress) {
        db = helper.getWritableDatabase ();//初始化SQLiteDatabase对象
        //执行修改购物车单信息操作
        db.execSQL ("update restaurant set a_id=?,u_id=?,a_name=?,a_phone=?,a_weizhi=?,a_menhao=? where u_id=?",

                new Object[]
                        {
                             useraddress.getA_id(),useraddress.getU_id(),useraddress.getA_name(),
                             useraddress.getA_phone(),useraddress.getA_weizhi(),useraddress.getA_menhao()
                        });
    }

    //通过f_name查找
    public Useraddress find(int i)
    {
        db=helper.getWritableDatabase ();//初始化SQLiteDatabase对象
        Cursor cursor=db.rawQuery ("select a_id,u_id,a_name,a_phone,a_weizhi,a_menhao from useraddress where u_id=?",
                new String[]
                        {String.valueOf (i)});
        if (cursor.moveToNext ())
        {
            //将遍历到的购物车单存储到 Myuser类中
            return new Useraddress(cursor.getInt (cursor.getColumnIndex ("a_id")),
                    cursor.getInt (cursor.getColumnIndex ("u_id")),
                    cursor.getString (cursor.getColumnIndex ("a_name")),
                    cursor.getString (cursor.getColumnIndex ("a_phone")),
                    cursor.getString (cursor.getColumnIndex ("a_weizhi")),
                    cursor.getString (cursor.getColumnIndex ("a_menhao")));
        }
        return null;     //如果没有返回null
    }
    public int getMaxId() {
        db = helper.getWritableDatabase ();//初始化SQLiteDatabase
        Cursor cursor = db.rawQuery ("select max(a_id) from useraddress", null);//获取菜单中最大的编号
        while (cursor.moveToLast ())//访问Cursor中的最后一条数据
        {
            return cursor.getInt (0);//获取访问到的数据，即最大编号
        }
        return 0;
    }
}