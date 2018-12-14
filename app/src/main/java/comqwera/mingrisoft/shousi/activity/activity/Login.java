package comqwera.mingrisoft.shousi.activity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import comqwera.mingrisoft.shousi.DAO.MyuserDAO;
import comqwera.mingrisoft.shousi.DAO.RestaurantDAO;

import comqwera.mingrisoft.shousi.activity.fragment.User_fragment;

public class Login extends Activity {

    private EditText Zhanghao, Mima;
    private String pwd, zhanghao;
    private Button loginbutton, tuichubutton, zhucebutton;
    private Spinner spinner1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.login);
        spinner1= findViewById (R.id.spinner1);
        spinner1.setOnItemSelectedListener (new AdapterView.OnItemSelectedListener () {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String result=parent.getItemAtPosition (position).toString ();
                Toast.makeText (Login.this, result, Toast.LENGTH_SHORT).show ();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        zhucebutton = findViewById (R.id.zhucebutton);
        tuichubutton = findViewById (R.id.tuichubutton);
        loginbutton = findViewById (R.id.loginbutton);

        //退出组件
        tuichubutton.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Login.this.finish ();
            }
        });
        //注册组件
        zhucebutton.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (Login.this, Zhuce.class);
                startActivity (i);
                Login.this.finish ();
            }
        });
        loginbutton.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Spinner spinner1= findViewById (R.id.spinner1);


                Zhanghao = findViewById (R.id.zhanghao);
                Mima = findViewById (R.id.mima);
                zhanghao = Zhanghao.getText ().toString ();
                pwd = Mima.getText ().toString ();
                Intent intent = new Intent();
                switch (spinner1.getSelectedItemPosition()) {
                    case 0:
                        MyuserDAO myuserDAO = new MyuserDAO (Login.this);
                        if (myuserDAO.find (zhanghao) == null) {
                            Toast.makeText (Login.this, "该账号没被注册", Toast.LENGTH_SHORT).show ();
                            return;
                        } else if (!myuserDAO.find (zhanghao).getU_password ().equals (pwd)) {
                            Toast.makeText (Login.this, "密码错误", Toast.LENGTH_SHORT).show ();
                            return;
                        } else {
                            intent.setClass (Login.this, MainActivity.class);
                            Bundle bundle = new Bundle ();
                            bundle.putString ("zhanghao", zhanghao);
                            intent.putExtras (bundle);
                            startActivity (intent);
                        }
                        break;
                    case 1:
                        RestaurantDAO restaurantDAO = new RestaurantDAO (Login.this);
                        if (restaurantDAO.find (zhanghao) == null) {
                            Toast.makeText (Login.this, "该商家账号未注册", Toast.LENGTH_SHORT).show ();
                            return;
                        } else if (!restaurantDAO.find (zhanghao).getR_password ().equals (pwd)) {
                            Toast.makeText (Login.this, "密码错误", Toast.LENGTH_SHORT).show ();
                            return;
                        }
                            else{Toast.makeText (Login.this, "登录成功", Toast.LENGTH_SHORT).show ();
                            intent.setClass (Login.this, MainActivity.class);
                            Bundle bundle = new Bundle ();
                            bundle.putString ("zhanghao", zhanghao);
                            intent.putExtras (bundle);
                            startActivity (intent);
                        }
                        break;
                    default:
                        Toast.makeText (Login.this, "玩你妈逼", Toast.LENGTH_SHORT).show ();
                        break;

                }
            }
        });
    }
}
