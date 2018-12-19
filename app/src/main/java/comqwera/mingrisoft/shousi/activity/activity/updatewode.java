package comqwera.mingrisoft.shousi.activity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import comqwera.mingrisoft.shousi.activity.activity.R;
import comqwera.mingrisoft.shousi.DAO.Login1DAO;
import comqwera.mingrisoft.shousi.DAO.MyuserDAO;
import comqwera.mingrisoft.shousi.model.Login1;
import comqwera.mingrisoft.shousi.model.Myuser;

public class updatewode extends Activity {
    private EditText nickname; //文本框昵称
    private EditText mima;     //文本框密码
    private EditText phone;    //预留电话号码
    private EditText Address;  //地址
    private EditText Zhiwen;   //指纹
    private String nickname1;   //存储昵称
    private String mima1;     //存储密码
    private String phone1;    //存储预留电话号码
    private String Address1;  //存储地址
    private int Zhiwen1;   //存储指纹
    private String nickname2;   //存储昵称
    private String mima2;     //存储密码
    private String phone2;    //存储预留电话号码
    private String Address2;  //存储地址
    private int Zhiwen2;
    private int Zhiwen3;
    private int u_id;
    private Button xiugaixinxi;
    private Button fanhuiuser;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xiugaiwode);
        MyuserDAO myuserDAO=new MyuserDAO(updatewode.this);
        Login1DAO login1DAO=new Login1DAO(updatewode.this);
        u_id=login1DAO.find(1).getU_id();

//数据库中获取数据
        nickname1=myuserDAO.find2(u_id).getU_nickname();
        mima1=myuserDAO.find2(u_id).getU_password();
        phone1=myuserDAO.find2(u_id).getU_phone2();
        Address1=myuserDAO.find2(u_id).getU_adress();
        Zhiwen1=login1DAO.find(1).getZhiwen();
//获取编辑文本框
        nickname=(EditText)findViewById(R.id.usernickname);
        mima=(EditText)findViewById(R.id.usermima);
        phone=(EditText)findViewById(R.id.userphone);
        Address=(EditText)findViewById(R.id.useraddress);
        Zhiwen=(EditText)findViewById(R.id.userzhiwen);
//获取数据库文字显示
        nickname.setText(nickname1);
        mima.setText(mima1);
        phone.setText(phone1);
        Address.setText(Address1);
        Zhiwen.setText(Integer.toString(Zhiwen1));
        xiugaixinxi=(Button)findViewById(R.id.xiugaiuser);
        xiugaixinxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyuserDAO myuserDAO=new MyuserDAO(updatewode.this);
                if (nickname.getText().toString() != null) {
                    nickname2 = nickname.getText().toString();
                } else {
                    nickname2 = nickname1;
                }
                if (mima.getText().toString() != null) {
                    mima2 = mima.getText().toString();
                } else {
                    mima2 = mima1;
                }
                if (phone.getText().toString() != null) {
                    phone2 = phone.getText().toString();
                } else {
                    phone2 = phone1;
                }
                if (Address.getText().toString()!= null) {
                    Address2 = Address.getText().toString();
                } else {
                    Address2=Address1;
                }
                 Zhiwen2=Integer.parseInt(Zhiwen.getText().toString());

                Myuser myuser=new Myuser(u_id,u_id,nickname2,mima2,myuserDAO.find2(u_id).getU_phone(),null,
                        null,null,Address2,phone2);
                myuserDAO.update(myuser);
                Login1DAO login1DAO=new Login1DAO(updatewode.this);
                Login1 login1=new Login1(1,1,u_id,login1DAO.find(1).getOr_id(),Zhiwen2);
                login1DAO.update(login1);
                Toast.makeText (updatewode.this,"修改成功",Toast.LENGTH_SHORT).show ();
                Intent c=new Intent(updatewode.this,MainActivity.class);
                startActivity(c);
                updatewode.this.finish();
            }
        });
        fanhuiuser=(Button)findViewById(R.id.fanhuiuser);
        fanhuiuser.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   updatewode.this.finish();
               }
           });
    }
}