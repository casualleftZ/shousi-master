package comqwera.mingrisoft.shousi.activity.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import comqwera.mingrisoft.shousi.DAO.*;
import comqwera.mingrisoft.shousi.activity.Adapter.FoodthingAdapter;
import comqwera.mingrisoft.shousi.model.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class OrderActivity extends AppCompatActivity {

    private Button tv_surepay;
    private TextView tv_time;
    private TextView dingdan_name;
    private TextView dingdan_address;
    private TextView tv_total;
    private float a=0;
    private float b=0;
    private int u_id;
    private String food_thing=" ";
    private List<Foodthing>foodthingList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        tv_surepay=(Button)findViewById(R.id.tv_surepay);
        tv_time=(TextView)findViewById(R.id.tv_time) ;
        tv_total=(TextView)findViewById(R.id.tv_total);
        ShopthingDAO shopthingDAO=new ShopthingDAO(OrderActivity.this);
        Shopthing1DAO shopthing1DAO=new Shopthing1DAO(OrderActivity.this);
        dingdan_address=(TextView)findViewById(R.id.dingdan_address);
        dingdan_name=(TextView)findViewById(R.id.dingdan_name) ;
        Login1DAO login1DAO=new Login1DAO(OrderActivity.this);
        u_id=login1DAO.find(1).getU_id();
        final MyuserDAO myuserDAO=new MyuserDAO(OrderActivity.this);

        UseraddressDAO useraddressDAO=new UseraddressDAO(OrderActivity.this);


        if(useraddressDAO.find(u_id)==null){
            dingdan_address.setText("我的信息地址没填");
        }
        else{
            dingdan_address.setText(useraddressDAO.find(u_id).getA_weizhi());
        }
        if (myuserDAO.find2(1).getU_nickname()!=null){
            dingdan_name.setText(myuserDAO.find2(1).getU_nickname());
        }
        else {
            dingdan_name.setText("昵称未填写");
        }
        Calendar calendar = Calendar.getInstance();//获取系统时间

        int hour = calendar.get(Calendar.HOUR_OF_DAY);//小时
        int minute = calendar.get(Calendar.MINUTE);//分钟
        calendar.add(calendar.MINUTE,30);

        tv_time.setText(""+hour+":"+minute);

        initShopthing();
        FoodthingAdapter adapter=new FoodthingAdapter(OrderActivity.this,R.layout.list_order_food,foodthingList);
        ListView listView=(ListView)findViewById(R.id.list_view4);
        listView.setAdapter(adapter);
        tv_surepay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UseraddressDAO useraddressDAO1 = new UseraddressDAO(OrderActivity.this);
                if (useraddressDAO1.find(u_id)!= null) {
                    ShopthingDAO shopthingDAO = new ShopthingDAO(OrderActivity.this);
                    Shopthing1DAO shopthing1DAO = new Shopthing1DAO(OrderActivity.this);
                    DingdanDAO dingdanDAO = new DingdanDAO(OrderActivity.this);

                    if (shopthingDAO.getMaxId() != 0) {
                        for (int i = 1; i <= shopthingDAO.getMaxId(); i++) {
                            food_thing = food_thing + shopthingDAO.find2(i).getF_name() + shopthingDAO.find2(i).getT_num() + "分";
                        }
                    }
                    for (int j = 1; j <= shopthing1DAO.getMaxId(); j++) {
                        food_thing = food_thing + shopthing1DAO.find2(j).getF_name() + shopthing1DAO.find2(j).getT_num() + "分";
                    }
                    Dingdan dingdan = new Dingdan(dingdanDAO.getMaxId() + 1, u_id, food_thing, useraddressDAO1.find(u_id).getA_weizhi(),a+b);
                    dingdanDAO.add(dingdan);
                    for (int m = shopthingDAO.getMaxId(); m >= 1; m--) {
                        shopthingDAO.detete2(m);
                    }
                    for (int m = shopthing1DAO.getMaxId(); m >= 1; m--) {
                        shopthing1DAO.detele2(m);
                    }
                    Toast.makeText(OrderActivity.this, "支付完成", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(OrderActivity.this,MyorderActivity.class);
                    startActivity(intent);
                    OrderActivity.this.finish();
                } else {
                    Toast.makeText(OrderActivity.this, "完善地址", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(OrderActivity.this,MyadressActivity.class);
                    startActivity(intent);

                }
            }
            });

    }
    private void initShopthing(){
        ShopthingDAO shopthingDAO=new ShopthingDAO(OrderActivity.this);
        Shopthing1DAO shopthing1DAO=new Shopthing1DAO(OrderActivity.this);
        if(shopthingDAO.getMaxId()!=0){
        for(int i=1;i<=shopthingDAO.getMaxId();i++){
            Foodthing thing=new Foodthing(shopthingDAO.find2(i).getF_name(),
                    shopthingDAO.find2(i).getT_num(),shopthingDAO.find2(i).getT_money_num());
            foodthingList.add(thing);
        a=a+shopthingDAO.find2(i).getT_money_num();
        }
        }
        if((shopthing1DAO.getMaxId()!=0)) {
            for (int j = 1; j <= shopthing1DAO.getMaxId(); j++) {
                Foodthing thing2 = new Foodthing(shopthing1DAO.find2(j).getF_name(),
                        shopthing1DAO.find2(j).getT_num(), shopthing1DAO.find2(j).getT_money_num());
                foodthingList.add(thing2);
                b=b+shopthing1DAO.find2(j).getT_money_num();
            }
            tv_total.setText("¥"+Float.toString(b+a));
        }

    }
}
