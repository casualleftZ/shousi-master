package comqwera.mingrisoft.shousi.activity.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OrderActivity extends AppCompatActivity {

    private Button tv_surepay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        tv_surepay=(Button)findViewById(R.id.tv_surepay);
        tv_surepay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
