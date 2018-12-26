package comqwera.mingrisoft.shousi.activity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.TextViewCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import comqwera.mingrisoft.shousi.activity.activity.R;
import comqwera.mingrisoft.shousi.DAO.Login1DAO;
import comqwera.mingrisoft.shousi.DAO.OnlineorderDAO;
import comqwera.mingrisoft.shousi.activity.fragment.*;
import comqwera.mingrisoft.shousi.model.Login1;
import comqwera.mingrisoft.shousi.model.Onlineorder;

import java.util.ArrayList;

public class Orderfinish extends Activity {
    private String Time;     //时间
    private String People;   //人数
    private String Beizhu;   //备注
    private String Phone;    //预留电话
    private TextView timetext;   //获取文本框
    private TextView peopletext;
    private TextView phonetext;
    private TextView or_memotext;
    private int u_id;     //定义账号id
    private Button tuichuyuyueButton;
    private Button quxiaoyuyueButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orderfinish);
        OnlineorderDAO onlineorderDAO = new OnlineorderDAO(Orderfinish.this);
        final Login1DAO login1DAO = new Login1DAO(Orderfinish.this);
        u_id = login1DAO.find(1).getU_id();   //获取账号id
       if(onlineorderDAO.getMaxId()!=0) {
           Phone = onlineorderDAO.find2(u_id).getOr_phone();
           Beizhu = onlineorderDAO.find2(u_id).getOr_memo();
           Time = onlineorderDAO.find2(u_id).getOr_time();
           People = onlineorderDAO.find2(u_id).getOr_sum();
       }
       else{
           People=null;
           Beizhu=null;
           Time=null;
           People=null;
       }
        timetext = findViewById(R.id.timeText);
        peopletext = findViewById(R.id.peopletext);
        phonetext = findViewById(R.id.phonetext);
        or_memotext = findViewById(R.id.or_memotext);

        timetext.setText(Time);
        peopletext.setText(People);
        phonetext.setText(Phone);
        or_memotext.setText(Beizhu);

        tuichuyuyueButton = findViewById(R.id.tuichubuyuyuetton);
        quxiaoyuyueButton = findViewById(R.id.quxiaoyuyue);

        tuichuyuyueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//               Intent a=new Intent(Orderfinish.this,MainActivity.class);
//                a.putExtra("id",2);
//                startActivity(a);
               Orderfinish.this.finish();
            }
        });
        quxiaoyuyueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login1DAO login1DAO1=new Login1DAO(Orderfinish.this);
                if(login1DAO.find(1).getOr_id()==1){
                OnlineorderDAO onlineorderDAO = new OnlineorderDAO(Orderfinish.this);
                onlineorderDAO.detele(1);
                Login1 login1=new Login1();
                login1.setZt_id(1);
                login1.setU_id(login1DAO.find(1).getU_id());
                login1.setZt(login1DAO.find(1).getZt());
                login1.setOr_id(0);         //预约状态
                login1DAO.update(login1);
                Toast.makeText(Orderfinish.this, "取消预约成功", Toast.LENGTH_SHORT).show();}
                else{
                    Toast.makeText(Orderfinish.this, "未预约", Toast.LENGTH_SHORT).show();}
//                Intent a=new Intent(Orderfinish.this,MainActivity.class);
//                a.putExtra("id",2);
//                startActivity(a);

                Orderfinish.this.finish();
            }
        });
    }


}
