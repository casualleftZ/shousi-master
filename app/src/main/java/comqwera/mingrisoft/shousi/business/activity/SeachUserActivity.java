package comqwera.mingrisoft.shousi.business.activity;

import android.app.Activity;
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

public class SeachUserActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seach_user);

    }
}