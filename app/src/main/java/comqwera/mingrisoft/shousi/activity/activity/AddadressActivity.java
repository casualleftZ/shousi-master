package comqwera.mingrisoft.shousi.activity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import comqwera.mingrisoft.shousi.DAO.Login1DAO;
import comqwera.mingrisoft.shousi.DAO.MyuserDAO;
import comqwera.mingrisoft.shousi.DAO.UseraddressDAO;
import comqwera.mingrisoft.shousi.model.Login1;
import comqwera.mingrisoft.shousi.model.Myuser;
import comqwera.mingrisoft.shousi.model.Useraddress;

public class AddadressActivity extends Activity {
    private TextView shouhuoren;   //收货人
    private TextView yuliushouji;  //收货人电话
    private TextView yuliudizhi;   //收货人地址
    private TextView yuliumenhao;  //收货人门号
    private Button add_adress;   //修改按钮
    private String shouhuoren1;
    private String yuliushouji1;
    private String yuliudizhi1;
    private String yuliumenhao1;
    private int u_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addadress);
        shouhuoren=(TextView) findViewById(R.id.shouhuoren);
        yuliushouji=(TextView) findViewById(R.id.yuliushouji);
        yuliudizhi=(TextView) findViewById(R.id.yuliudizhi);
        yuliumenhao=(TextView) findViewById(R.id.yuliumenhao);
        add_adress=(Button)findViewById(R.id.add_adress);
        add_adress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shouhuoren1=shouhuoren.getText().toString();
                yuliudizhi1=yuliudizhi.getText().toString();
                yuliushouji1=yuliushouji.getText().toString();
                yuliumenhao1=yuliumenhao.getText().toString();
                UseraddressDAO useraddressDAO=new UseraddressDAO(AddadressActivity.this);
                MyuserDAO myuserDAO=new MyuserDAO(AddadressActivity.this);
                Login1DAO login1DAO=new Login1DAO(AddadressActivity.this);
                u_id=login1DAO.find(1).getU_id();
                    if (useraddressDAO.find(u_id) == null) {
                        Useraddress useraddress = new Useraddress(useraddressDAO.getMaxId()+1, u_id, shouhuoren1, yuliushouji1, yuliudizhi1, yuliumenhao1);
                        useraddressDAO.add(useraddress);
                        Toast.makeText (AddadressActivity.this, "添加成功", Toast.LENGTH_SHORT).show ();
                    }
                    else {
                        Useraddress useraddress = new Useraddress(useraddressDAO.getMaxId()+1, u_id, shouhuoren1, yuliushouji1, yuliudizhi1, yuliumenhao1);
                        useraddressDAO.update(useraddress);
                        Toast.makeText (AddadressActivity.this, "修改成功", Toast.LENGTH_SHORT).show ();
                    }
                Myuser myuser=new Myuser(u_id,myuserDAO.find2(u_id).getU_loinid(),myuserDAO.find2(u_id).getU_nickname(),myuserDAO.find2(u_id).getU_password(),
                        myuserDAO.find2(u_id).getU_phone(),myuserDAO.find2(u_id).getU_sex(),myuserDAO.find2(u_id).getU_headportrait(),
                        myuserDAO.find2(u_id).getU_vip(),yuliudizhi1,yuliushouji1);
                myuserDAO.update(myuser);
                Intent intent=new Intent(AddadressActivity.this,MyadressActivity.class);
                startActivity(intent);
                AddadressActivity.this.finish();
            }

        });

    }
}
