package comqwera.mingrisoft.shousi.activity.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.io.File;

public class GoodsActivity extends AppCompatActivity {
    private ImageButton ib_fanhui;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);
        ib_fanhui=(ImageButton)findViewById(R.id.ib_fanhui);
        ib_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(GoodsActivity.this,MainActivity.class);
                startActivity(a);
                GoodsActivity.this.finish();
            }
        });

    }
}
