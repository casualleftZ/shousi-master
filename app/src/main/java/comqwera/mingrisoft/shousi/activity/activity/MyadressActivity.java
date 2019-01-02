package comqwera.mingrisoft.shousi.activity.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import comqwera.mingrisoft.shousi.DAO.Login1DAO;
import comqwera.mingrisoft.shousi.DAO.UseraddressDAO;

public class MyadressActivity extends AppCompatActivity {

    private Button add_adress;
    private TextView lianxiren_nickname;
    private TextView lianxiren_phone;
    private TextView lianixren_address;
    private TextView lianxiren_menhao;
    private String phone;
    private String nickname;
    private String menhao;
    private String address;
    private int u_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myadress);
        lianxiren_nickname=(TextView)findViewById(R.id.lianxiren_nickname);
        lianxiren_phone=(TextView)findViewById(R.id.lianxiren_phone) ;
        lianixren_address=(TextView)findViewById(R.id.lianxiren_dizhi) ;
        lianxiren_menhao=(TextView)findViewById(R.id.lianxiren_menhao) ;
        Login1DAO login1DAO=new Login1DAO(MyadressActivity.this);
        u_id=login1DAO.find(1).getU_id();
        UseraddressDAO useaddressDAO=new UseraddressDAO(MyadressActivity.this);

        if(useaddressDAO.find(u_id)!=null) {
            if (useaddressDAO.find(u_id).getA_name() != null) {
                nickname = useaddressDAO.find(u_id).getA_name();
                lianxiren_nickname.setText("收货人:" + nickname);
            } else {
                lianxiren_nickname.setText("收货人:");
            }

            if (useaddressDAO.find(u_id).getA_phone() != null) {
                phone = useaddressDAO.find(u_id).getA_phone();
                lianxiren_phone.setText("收货人电话号码:" + phone);
            } else {
                lianxiren_phone.setText("收货人电话号码:");
            }

            if (useaddressDAO.find(u_id).getA_weizhi() != null) {
                address = useaddressDAO.find(u_id).getA_weizhi();
                lianixren_address.setText("收货人地址:" + address);
            } else {
                lianixren_address.setText("收货人地址:");
            }


            if (useaddressDAO.find(u_id).getA_menhao() != null) {
                menhao = useaddressDAO.find(u_id).getA_menhao();
                lianxiren_menhao.setText("收货人门号:" + menhao);
            } else {
                lianxiren_phone.setText("收货人门号:");
            }
        }
        else{
            lianxiren_nickname.setText("收货人:");
            lianxiren_phone.setText("收货人电话号码:");
            lianixren_address.setText("收货人地址:");
            lianxiren_menhao.setText("收货人门号:");
        }
        add_adress=(Button)findViewById(R.id.add_adress);

        add_adress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyadressActivity.this,AddadressActivity.class);
                startActivity(intent);
                MyadressActivity.this.finish();
            }
        });
    }
}
