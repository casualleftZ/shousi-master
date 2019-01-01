package comqwera.mingrisoft.shousi.activity.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import comqwera.mingrisoft.shousi.business.modle.Inquiryuser;

public class MyadressActivity extends AppCompatActivity {

    private Button add_adress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myadress);
        add_adress=(Button)findViewById(R.id.add_adress);
        add_adress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyadressActivity.this,AddadressActivity.class);
                startActivity(intent);
            }
        });
    }
}
