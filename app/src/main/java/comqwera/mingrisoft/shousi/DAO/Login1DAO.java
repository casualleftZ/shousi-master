package comqwera.mingrisoft.shousi.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import comqwera.mingrisoft.shousi.model.Login1;

public class Login1DAO {
    private DBOPenHelper helper;     //创建DBOpenHelper对象
    private SQLiteDatabase db;       //创建SQLiteDatabase对象

    public Login1DAO(Context context) {
        helper = new DBOPenHelper(context);           //初始化DBOpenHelper
        db = helper.getWritableDatabase();            //初始化SQLiteDatabase
    }
    /**
     * 添加登录信息
     *
     * @param login1
     */
    public void add(Login1 login1) {
        db = helper.getWritableDatabase();         //初始化SQLiteDatabase
        //执行添加食物信息操作
        db.execSQL("insert into login1 (zt_id,zt,u_id,or_id) values (?,?,?,?)",
                new Object[]
                        {
                         login1.getZt_id(),login1.getZt(),
                                login1.getOr_id(),login1.getZt_id()
                        });
    }
    /**
     * 添加登录信息
     *
     * @param login1
     */
    public void update(Login1 login1)
    {
        db=helper.getWritableDatabase ();            //初始化SQLiteDatabase对象
        //执行修改食物信息操作
        db.execSQL ("update login1 set zt=?,u_id=?,or_id=? where zt_id=?",
                new Object[]
                        {
                                login1.getZt_id(),login1.getZt(),
                                login1.getOr_id(),login1.getU_id()
                        });
    }

    /**
     * 获取最大编号
     *
     * @return
     */
    public int getMaxId() {
        db = helper.getWritableDatabase ();//初始化SQLiteDatabase
        Cursor cursor = db.rawQuery ("select max(zt_id) from login1", null);//获取菜单中最大的编号
        while (cursor.moveToLast ())//访问Cursor中的最后一条数据
        {
            return cursor.getInt (0);//获取访问到的数据，即最大编号
        }
        return 0;
    }
    public Login1 find(int id) {
        db = helper.getWritableDatabase ();//初始化SQLiteDatabase对象
        Cursor cursor = db.rawQuery("select zt_id,zt,u_id,or_id from login1 where zt_id=?",
                new String[]{String.valueOf (id)});
        if (cursor.moveToNext ()) {
            //将遍历到的收入信息存储到Tb_inaccount类中
            return new Login1 (cursor.getInt (cursor.getColumnIndex ("zt_id")),
                    cursor.getInt(cursor.getColumnIndex ("zt")),
                    cursor.getInt (cursor.getColumnIndex ("u_id")),
                    cursor.getInt (cursor.getColumnIndex ("or_id")));
        }
        cursor.close();//关闭游标
        return null;           //如果没有返回值返回null
    }
}