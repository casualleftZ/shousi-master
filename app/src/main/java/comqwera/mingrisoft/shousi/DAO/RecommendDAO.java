package comqwera.mingrisoft.shousi.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


import comqwera.mingrisoft.shousi.model.Recommend;

public class RecommendDAO {
    private DBOPenHelper helper;     //创建DBOpenHelper对象
    private SQLiteDatabase db;       //创建SQLiteDatabase对象
    public RecommendDAO(Context context){
        helper=new DBOPenHelper (context);           //初始化DBOpenHelper
        db=helper.getWritableDatabase ();            //初始化SQLiteDatabase
    }
/**
 * 添加商家推荐信息
 *
 * @param recommend
 */
public void add(Recommend recommend)
{
    db=helper.getWritableDatabase ();         //初始化SQLiteDatabase
    //执行添加商家推荐操作
    db.execSQL ("insert into recommend(re_id,re_begintime,re_endtime,re_url,re_img,re_contect)values (?,?,?,?,?,?)",
            new Object[]
                    {
                            recommend.getRe_id (),recommend.getRe_begintime (),
                            recommend.getRe_endtime (),recommend.getRe_url (),recommend.getRe_img (),
                            recommend.getRe_contect ()
                    });
}
    /**
     * 更新商家推荐信息
     *
     * @param recommend
     */
    public void update(Recommend recommend)
    {
        db=helper.getWritableDatabase ();            //初始化SQLiteDatabase对象
        //执行修改商家推荐信息操作
        db.execSQL ("update recommend set re_id=?,re_begintime=?,re_endtime=?,re_url=?,re_img=?,re_contect=?",
                new Object[]
                        {
                                recommend.getRe_id (),recommend.getRe_begintime (),
                                recommend.getRe_endtime (),recommend.getRe_url (),recommend.getRe_img (),
                                recommend.getRe_contect ()
                        });
    }
    /**
     * 查找商家推荐信息
     *
     * @param id
     * @return
     */
    public Recommend find(int id)
    {
        db=helper.getWritableDatabase ();     //初始化SQLiteDatabase对象
        Cursor cursor=db.rawQuery ("select re_id,re_begintime,re_endtime,re_url,re_img,re_contect from recommend where re_id ",
                new String[]{
                        String.valueOf (id)        //更具商家推荐编号,查找商家推荐信息
                });
        if (cursor.moveToNext ())
        {
            //将遍历到的商家推荐信息存储到food类中
            return new Recommend (cursor.getInt (cursor.getColumnIndex ("re_id")),
                    cursor.getInt (cursor.getColumnIndex ("re_begintime")),
                    cursor.getString (cursor.getColumnIndex ("re_endtime")),
                    cursor.getString (cursor.getColumnIndex ("re_url")),
                    cursor.getString (cursor.getColumnIndex ("re_img")),
                    cursor.getString (cursor.getColumnIndex ("re_contect")));
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
            db.execSQL ("delete from recommend  where re_id in ("+sb+")", ids);
        }
    }
    /**
     * 获取食物信息
     * @param start 起始位置
     * @param count 每页显示数量
     * @return
     */
    public List<Recommend> getScrollData(int start, int count) {
        List<Recommend> recommend = new ArrayList<Recommend> (); //创建集合对象
        db = helper.getWritableDatabase ();     //初始化SQLiteDatabase
        Cursor cursor = db.rawQuery ("select * from recommend limit ?,?", new String[]{
                String.valueOf (start), String.valueOf (count)
        });
        while (cursor.moveToNext ()) {
            recommend.add (new Recommend (cursor.getInt (cursor.getColumnIndex ("re_id")),
                    cursor.getInt (cursor.getColumnIndex ("re_begintime")),
                    cursor.getString (cursor.getColumnIndex ("re_endtime")),
                    cursor.getString (cursor.getColumnIndex ("re_url")),
                    cursor.getString (cursor.getColumnIndex ("re_img")),
                    cursor.getString (cursor.getColumnIndex ("re_contect"))));
        }
        return recommend;
    }
    /**
     * 获取总记录数
     *
     * @return
     */
    public long getCount(){
        db = helper.getWritableDatabase ();  //初始化SQLiteDatabase
        Cursor cursor = db.rawQuery ("select count(re_id)from recommend", null);//获取推荐菜单的记录数
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
        Cursor cursor = db.rawQuery ("select max(re_id) from  recommend", null);//获取推荐菜单中最大的编号
        while (cursor.moveToLast ())//访问Cursor中的最后一条数据
        {
            return cursor.getInt (0);//获取访问到的数据，即最大编号
        }
        return 0;
    }
}

