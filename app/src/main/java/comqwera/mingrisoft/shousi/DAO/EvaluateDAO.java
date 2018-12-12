package comqwera.mingrisoft.shousi.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


import comqwera.mingrisoft.shousi.model.Evaluate;

public class EvaluateDAO {
        private DBOPenHelper helper;     //创建DBOpenHelper对象
        private SQLiteDatabase db;       //创建SQLiteDatabase对象
        public EvaluateDAO(Context context){
            helper=new DBOPenHelper (context);           //初始化DBOpenHelper
            db=helper.getWritableDatabase ();            //初始化SQLiteDatabase
        }
        /**
         * 添加评论信息
         *
         * @param evaluate
         */
        public void add(Evaluate evaluate)
        {
            db=helper.getWritableDatabase ();         //初始化SQLiteDatabase
            //执行添加评论信息操作
            db.execSQL ("insert into evaluate(e_id,o_id,u_id,f_id,e_allrating,e_imgurl,e_statue)values (?,?,?,?,?,?,?)",
                    new Object[]
                            {
                                    evaluate.getE_id (),evaluate.getO_id (),evaluate.getU_id (),evaluate.getF_id (),evaluate.getE_allrating ()
                                    ,evaluate.getE_imgurl ()
                            });
        }
        /**
         * 更新评论信息
         *
         * @param evaluate
         */
        public void update(Evaluate evaluate)
        {
            db=helper.getWritableDatabase ();            //初始化SQLiteDatabase对象
            //执行修改评论信息操作
            db.execSQL ("update evaluate set e_id=?,o_id=?,u_id=?,f_id=?,e_allrating=?,e_imgurl=?,e_statue=? where e_id=?",
                    new Object[]
                            {
                                    evaluate.getE_id (),evaluate.getO_id (),evaluate.getU_id (),evaluate.getF_id (),evaluate.getE_allrating ()
                                    ,evaluate.getE_imgurl ()
                            });
        }
        /**
         * 查找评论信息
         *
         * @param id
         * @return
         */
        public Evaluate find(int id)
        {
            db=helper.getWritableDatabase ();     //初始化SQLiteDatabase对象
            Cursor cursor=db.rawQuery ("select e_id,o_id,u_id,f_id,e_allrating,e_imgurl,e_statue from evaluate where e_id ",
                    new String[]{
                            String.valueOf (id)        //更具食物名称,或者编号,查找食物信息，并存储
                    });
            if (cursor.moveToNext ())
            {
                //将遍历到的评论信息存储到evaluate类中
                return new Evaluate (cursor.getInt (cursor.getColumnIndex ("e_id")),
                        cursor.getInt (cursor.getColumnIndex ("o_id")),
                        cursor.getInt (cursor.getColumnIndex ("u_id")),
                        cursor.getInt (cursor.getColumnIndex ("f_id")),
                        cursor.getString (cursor.getColumnIndex ("e_allrating")),
                        cursor.getString (cursor.getColumnIndex ("e_imgurl")),
                        cursor.getString (cursor.getColumnIndex ("e_statue")));
            }
            return null;
        }

        /**
         * 删除评论信息
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
                db.execSQL ("delete from evaluate where e_id in ("+sb+")", ids);
            }
        }
        /**
         * 获取评论信息
         * @param start 起始位置
         * @param count 每页显示数量
         * @return
         */
        public List<Evaluate> getScrollData(int start, int count)
        {
            List<Evaluate>evaluate=new ArrayList<Evaluate> (); //创建集合对象
            db=helper.getWritableDatabase ();     //初始化SQLiteDatabase
            Cursor cursor=db.rawQuery ("select * from evaluate limit ?,?", new String[]{
                    String.valueOf (start),String.valueOf (count)
            });
            while (cursor.moveToNext ())
            {
                evaluate.add (new Evaluate(cursor.getInt (cursor.getColumnIndex ("e_id")),
                        cursor.getInt (cursor.getColumnIndex ("o_id")),
                        cursor.getInt (cursor.getColumnIndex ("u_id")),
                        cursor.getInt (cursor.getColumnIndex ("f_id")),
                        cursor.getString (cursor.getColumnIndex ("e_allrating")),
                        cursor.getString (cursor.getColumnIndex ("e_imgurl")),
                        cursor.getString (cursor.getColumnIndex ("e_statur"))));
            }
            return evaluate;
        }
        /**
         * 获取总记录数
         *
         * @return
         */
        public long getCount() {
            db = helper.getWritableDatabase ();  //初始化SQLiteDatabase
            Cursor cursor = db.rawQuery ("select count(e_id)from evaluate", null);//获取评论信息的记录数
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
            Cursor cursor = db.rawQuery ("select max(e_id) from  evaluate", null);//获取评论信息表中最大的编号
            while (cursor.moveToLast ())//访问Cursor中的最后一条数据
            {
                return cursor.getInt (0);//获取访问到的数据，即最大编号
            }
            return 0;
        }
}

