package comqwera.mingrisoft.shousi.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import comqwera.mingrisoft.shousi.model.Dingdan;
import comqwera.mingrisoft.shousi.model.Evaluate;
import comqwera.mingrisoft.shousi.model.Food;

public class DingdanDAO {
    private DBOPenHelper helper;     //创建DBOpenHelper对象
    private SQLiteDatabase db;       //创建SQLiteDatabase对象
    public DingdanDAO(Context context){
        helper=new DBOPenHelper (context);           //初始化DBOpenHelper
        db=helper.getWritableDatabase ();            //初始化SQLiteDatabase
    }
    public void add(Dingdan dingdan)
    {
        db=helper.getWritableDatabase ();         //初始化SQLiteDatabase
        //执行添加食物信息操作
        db.execSQL ("insert into dingdan(d_id,u_id,d_thing,d_address) values (?,?,?,?)",
                new Object[]
                        {
                                dingdan.getD_id(),dingdan.getU_id(),dingdan.getD_thing(),
                                dingdan.getD_address()
                        });
    }
    public void update(Dingdan dingdan)
    {
        db=helper.getWritableDatabase ();            //初始化SQLiteDatabase对象
        //执行修改评论信息操作
        db.execSQL ("update dingdan set u_id=?,d_thing=?,d_address=? where d_id=?",
                new Object[]
                        {
                                dingdan.getD_id(),dingdan.getU_id(),dingdan.getD_thing(),
                                dingdan.getD_address()
                        });
    }
    public Dingdan find(int id)
    {
        db=helper.getWritableDatabase ();     //初始化SQLiteDatabase对象
        Cursor cursor=db.rawQuery ("select d_id,u_id,d_thing,d_address from dingdan where d_id ",
                new String[]{
                        String.valueOf (id)        //更具食物名称,或者编号,查找食物信息，并存储
                });
        if (cursor.moveToNext ())
        {
            //将遍历到的评论信息存储到evaluate类中
            return new Dingdan (cursor.getInt (cursor.getColumnIndex ("d_id")),
                    cursor.getInt (cursor.getColumnIndex ("u_id")),
                    cursor.getString (cursor.getColumnIndex ("d_thing")),
                    cursor.getString (cursor.getColumnIndex ("d_address")));
        }
        return null;
    }

    public int getMaxId() {
        db = helper.getWritableDatabase ();//初始化SQLiteDatabase
        Cursor cursor = db.rawQuery ("select max(d_id) from dingdan", null);//获取收入信息表中最大的编号
        while (cursor.moveToLast ())//访问Cursor中的最后一条数据
        {
            return cursor.getInt (0);//获取访问到的数据，即最大编号
        }
        return 0;
    }
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
            db.execSQL ("delete from dingdan where d_id in ("+sb+")", ids);
        }
    }

}
