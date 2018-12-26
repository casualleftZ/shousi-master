package comqwera.mingrisoft.shousi.activity.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import comqwera.mingrisoft.shousi.DAO.FoodDAO;
import comqwera.mingrisoft.shousi.activity.activity.R;
import comqwera.mingrisoft.shousi.model.Food;

import java.io.File;

public class GoodsActivity extends AppCompatActivity {
    private ImageButton ib_fanhui;
    private ImageView iv_good_info_image;
    private TextView tv_good_info_name;
    private TextView tv_good_info_desc;
    private TextView tv_good_info_jiage;
    private String cai;
    private String cai_pingjia;
    private String cai_picture;
    private float cai_price;
    private Button btn_good_info_addcart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);
        ib_fanhui= findViewById(R.id.ib_fanhui);
        ib_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(GoodsActivity.this,MainActivity.class);
                startActivity(a);
                GoodsActivity.this.finish();
            }
        });
        Intent intent=getIntent();
        cai= (String) intent.getExtras().get("cai");
        Bundle bundle=new Bundle();
        bundle.putString ("cai", cai);
        Toast.makeText(GoodsActivity.this,cai,Toast.LENGTH_SHORT).show();
        FoodDAO foodDAO=new FoodDAO(GoodsActivity.this);
        iv_good_info_image= findViewById(R.id.iv_good_info_image);
        tv_good_info_name= findViewById(R.id.tv_good_info_name);
        tv_good_info_desc= findViewById(R.id.tv_good_info_desc);
        tv_good_info_jiage= findViewById(R.id.tv_good_info_jiage);
        cai_pingjia=foodDAO.find2(cai).getF_instruction();
        cai_picture=foodDAO.find2(cai).getF_url();
        cai_price=foodDAO.find2(cai).getF_price();
        tv_good_info_name.setText(cai);
        tv_good_info_desc.setText(cai_pingjia);
        tv_good_info_jiage.setText(Float.toString(cai_price));
        int resID=getResources().getIdentifier(cai_picture,"mipmap",getPackageName());
        iv_good_info_image.setImageResource(resID);
        btn_good_info_addcart= findViewById(R.id.btn_good_info_addcart);
        btn_good_info_addcart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });
    }

}
