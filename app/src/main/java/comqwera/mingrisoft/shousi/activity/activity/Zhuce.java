package comqwera.mingrisoft.shousi.activity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import comqwera.mingrisoft.shousi.DAO.MyuserDAO;


import comqwera.mingrisoft.shousi.model.Myuser;

public class Zhuce extends Activity {
    private String username;
    private String pwd;
    private String qrpwd;
    private String phonenumber;
    private Button fanhui;            //返回按钮
    private Button likezhuceButton;   //立刻注册按钮
    private EditText zhucenicheng;    //用户昵称
    private EditText zhuceshouji;     //用户手机
    private EditText zhucemima;       //注册密码
    private EditText querenzhucemima; //确认密码
    private int u_loginid;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.zhuce);
        fanhui= findViewById (R.id.fanhui);
        likezhuceButton= findViewById (R.id.likezhuceButton);
        fanhui.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Zhuce.this,Login.class);
                startActivity (intent);
                Zhuce.this.finish ();
            }
        });
        likezhuceButton.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                zhucenicheng= findViewById (R.id.zhucenicheng);
                zhucemima= findViewById (R.id.zhucemima);
                zhuceshouji= findViewById (R.id.zhuceshouji);
                querenzhucemima= findViewById (R.id.querenzhucemima);
                username = zhucenicheng.getText().toString();
                pwd = zhucemima.getText().toString();
                phonenumber=zhuceshouji.getText ().toString ();
                qrpwd=querenzhucemima.getText ().toString ();
                MyuserDAO myuserDAO = new MyuserDAO(Zhuce.this);

                if(TextUtils.isEmpty(username)){
                    Toast.makeText (Zhuce.this,"请输入用户名",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (TextUtils.isEmpty (phonenumber)){
                    Toast.makeText (Zhuce.this,"请输入手机号码",Toast.LENGTH_SHORT).show ();
                    return;
                }
                else if (myuserDAO.find(phonenumber)!=null) {
                    Toast.makeText (Zhuce.this, "此电话号码已经注册过",
                            Toast.LENGTH_SHORT).show ();
                }
                else if(TextUtils.isEmpty (pwd)){
                    Toast.makeText (Zhuce.this,"请输入密码",Toast.LENGTH_SHORT).show ();
                    return;
                }
                else if(TextUtils.isEmpty (qrpwd)){
                    Toast.makeText (Zhuce.this,"请再次输入密码",Toast.LENGTH_SHORT).show ();
                    return;
                }
                else if(!pwd.equals (qrpwd)){
                    Toast.makeText (Zhuce.this,"输入两次密码不一样",
                            Toast.LENGTH_SHORT).show ();
                    return;
                }
                else {
                    Myuser myuser=new Myuser (myuserDAO.getMaxId ()+1,u_loginid+1,username,
                            pwd,phonenumber,null,null,null,null);
                    myuserDAO.add (myuser);
                    Toast.makeText (Zhuce.this,"注册成功",Toast.LENGTH_SHORT).show ();
                    Intent i = new Intent (Zhuce.this,Login.class);
                    startActivity (i);
                }
            }
        });
    }
}
