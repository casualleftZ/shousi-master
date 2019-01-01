package comqwera.mingrisoft.shousi.activity.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MymessageActivity extends AppCompatActivity {

    private Button xiugaixinxi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mymessage);
        xiugaixinxi=(Button)findViewById(R.id.xiugaixinxi);


        xiugaixinxi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent wodexinxi=new Intent(MymessageActivity.this,updatewode.class);
                startActivity(wodexinxi);

            }
        });//修改信息按钮
    }
}
