package comqwera.mingrisoft.shousi.business.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import comqwera.mingrisoft.shousi.DAO.DingdanDAO;
import comqwera.mingrisoft.shousi.DAO.Login1DAO;
import comqwera.mingrisoft.shousi.DAO.MyuserDAO;
import comqwera.mingrisoft.shousi.activity.Adapter.OrderAdapter;
import comqwera.mingrisoft.shousi.activity.activity.MyorderActivity;
import comqwera.mingrisoft.shousi.activity.activity.R;
import comqwera.mingrisoft.shousi.model.Dingdan;
import comqwera.mingrisoft.shousi.model.Order;

import java.util.ArrayList;
import java.util.List;

public class UserorderActivity extends AppCompatActivity {
    private List<Order> orderList = new ArrayList<>();
    private int u_id;
    private String u_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userorder);
        initOrder();
        OrderAdapter adapter=new OrderAdapter(UserorderActivity.this,R.layout.list_myorder,orderList);
        ListView listView=(ListView)findViewById(R.id.list_view6);
        listView.setAdapter(adapter);
}
        private void initOrder(){
            DingdanDAO dingdanDAO=new DingdanDAO(UserorderActivity.this);
            Login1DAO login1DAO=new Login1DAO(UserorderActivity.this);
            MyuserDAO myuserDAO=new MyuserDAO(UserorderActivity.this);

            Dingdan dingdan[]=dingdanDAO.find4();
            for(int i=0;i<dingdan.length;i++){
                Order ding=new Order(dingdan[i].getD_id(),u_name,dingdan[i].getD_thing(),
                        dingdan[i].getD_address(),dingdan[i].getF_money());
                orderList.add(ding);
            }

        }
    }
