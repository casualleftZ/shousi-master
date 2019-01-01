package comqwera.mingrisoft.shousi.business.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import comqwera.mingrisoft.shousi.DAO.Login1DAO;
import comqwera.mingrisoft.shousi.activity.activity.Login;
import comqwera.mingrisoft.shousi.activity.activity.R;
import comqwera.mingrisoft.shousi.business.Adapter.PictureAdapter;

public class Main2Activity extends AppCompatActivity {
     GridView gridView;
     String[] titles=new String[]{"用户信息","用户预约","用户订单","我的收入",
     "菜谱名单","店家信息设置","退出"};
     int[] images=new int[]{R.mipmap.r_user,R.mipmap.r_yuyue,R.mipmap.r_dingdan,R.mipmap.r_shouru,
     R.mipmap.r_menu,R.mipmap.r_shezhi,R.mipmap.r_exit};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        gridView= findViewById(R.id.GridView1);
        PictureAdapter adapter=new PictureAdapter(titles,images,this);//创建picture对象
        gridView.setAdapter(adapter);                      //为GridView设置数据源
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?>arg0,View arg1,
                                    int arg2, long arg3) {
                Intent intent=null;    //创建intent对象
                switch (arg2){
                    case 0:
                        intent=new Intent(Main2Activity.this,InquiryuserActivity.class);
                        startActivity(intent);
                        break;
                    case 6:
                        Login1DAO login1DAO=new Login1DAO(Main2Activity.this);
                        login1DAO.detele(1);
                        intent=new Intent(Main2Activity.this,Login.class);
                        startActivity(intent);
                        Main2Activity.this.finish();
                }

            }
        });
    }
    class ViewHolder{
        private TextView title;   //创建TextView对象
        private ImageView image;  //创建ImageView对象
    }

}
