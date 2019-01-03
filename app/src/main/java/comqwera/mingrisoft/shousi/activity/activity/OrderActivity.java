package comqwera.mingrisoft.shousi.activity.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class OrderActivity extends AppCompatActivity {

    private Button tv_surepay;
    private TextView tv_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        tv_surepay=(Button)findViewById(R.id.tv_surepay);
        tv_time=(TextView)findViewById(R.id.tv_time) ;
        Calendar calendar = Calendar.getInstance();//获取系统时间


        int hour = calendar.get(Calendar.HOUR_OF_DAY);//小时

        int minute = calendar.get(Calendar.MINUTE);//分钟


        tv_time.setText(""+hour+":"+minute+":");
        tv_surepay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
