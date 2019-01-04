package comqwera.mingrisoft.shousi.activity.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import comqwera.mingrisoft.shousi.DAO.DingdanDAO;
import comqwera.mingrisoft.shousi.DAO.Login1DAO;
import comqwera.mingrisoft.shousi.DAO.MyuserDAO;
import comqwera.mingrisoft.shousi.activity.Adapter.OrderAdapter;
import comqwera.mingrisoft.shousi.model.Dingdan;
import comqwera.mingrisoft.shousi.model.Login1;
import comqwera.mingrisoft.shousi.model.Myuser;
import comqwera.mingrisoft.shousi.model.Order;

import java.util.ArrayList;
import java.util.List;

public class MyorderActivity extends Activity {
    private List<Order> orderList=new ArrayList<>();
    private int u_id;
    private String u_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myorder);
        initOrder();
        OrderAdapter adapter=new OrderAdapter(MyorderActivity.this,R.layout.list_myorder,orderList);
        ListView listView=(ListView)findViewById(R.id.list_view5);
        listView.setAdapter(adapter);

    }
    private void initOrder(){
        DingdanDAO dingdanDAO=new DingdanDAO(MyorderActivity.this);
        Login1DAO login1DAO=new Login1DAO(MyorderActivity.this);
        MyuserDAO myuserDAO=new MyuserDAO(MyorderActivity.this);
        u_id=login1DAO.find(1).getU_id();
        u_name=myuserDAO.find2(u_id).getU_nickname();
        Dingdan dingdan[]=dingdanDAO.find3(u_id);
        for(int i=0;i<dingdan.length;i++){
            Order ding=new Order(dingdan[i].getD_id(),u_name,dingdan[i].getD_thing(),
                    dingdan[i].getD_address(),dingdan[i].getF_money());
            orderList.add(ding);
        }

    }
}
