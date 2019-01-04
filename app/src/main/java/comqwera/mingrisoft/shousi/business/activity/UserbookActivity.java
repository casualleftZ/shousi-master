package comqwera.mingrisoft.shousi.business.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import comqwera.mingrisoft.shousi.DAO.OnlineorderDAO;
import comqwera.mingrisoft.shousi.activity.activity.R;
import comqwera.mingrisoft.shousi.business.Adapter.YuyueuserApdater;
import comqwera.mingrisoft.shousi.model.Login1;
import comqwera.mingrisoft.shousi.model.Onlineorder;

import java.util.ArrayList;
import java.util.List;

public class UserbookActivity extends AppCompatActivity {
private List<Onlineorder> onlineorderList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userbook);
        initOnlineorder();
        YuyueuserApdater apdater=new YuyueuserApdater(UserbookActivity.this,R.layout.list_myuser_yuyue,onlineorderList);
        ListView listView=(ListView)findViewById(R.id.list_view7);
        listView.setAdapter(apdater);
    }
    private void initOnlineorder(){
        OnlineorderDAO onlineorderDAO=new OnlineorderDAO(UserbookActivity.this);
        Onlineorder onlineorder[]=onlineorderDAO.find2();
        for(int i=0;i<onlineorder.length;i++){
            Onlineorder a=new Onlineorder(onlineorder[i].getOr_id(),onlineorder[i].getU_id(),
                    onlineorder[i].getOr_phone(),onlineorder[i].getD_id(),onlineorder[i].getOr_sum(),
                    onlineorder[i].getOr_time(),onlineorder[i].getOr_memo());
            onlineorderList.add(a);
        }

    }
}
