package comqwera.mingrisoft.shousi.activity.activity;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.*;
import comqwera.mingrisoft.shousi.DAO.FoodDAO;
import comqwera.mingrisoft.shousi.activity.Adapter.FindAdapter;
import comqwera.mingrisoft.shousi.model.Food;
import comqwera.mingrisoft.shousi.model.Thing;

import java.util.ArrayList;
import java.util.List;

public class FindActivity extends Activity {
    public static FindActivity mfindActivity;
    private TextView find_tv_seach;
    private Thread thread;
    private EditText tv_seach2;
    private String content;
    private String picture;

    @Override
    protected void onCreate(Bundle savedInstancestate) {
        super.onCreate(savedInstancestate);
        setContentView(R.layout.activity_find);

        mfindActivity=this; //非Activity跳转方法
        find_tv_seach=(TextView)findViewById(R.id.find_tv_seach) ;
        find_tv_seach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FoodDAO foodDAO=new FoodDAO(FindActivity.this);
                tv_seach2=(EditText) findViewById(R.id.tv_seach2);
                content=tv_seach2.getText().toString();
                if(!TextUtils.isEmpty(content)) {
                    List<Thing>thingsList=new ArrayList<>();
                    Food food[] = foodDAO.find3(content);
                    Toast.makeText(FindActivity.this, food[0].getF_name(), Toast.LENGTH_SHORT).show();
                    for (int i = 0; i < food.length; i++) {
                        picture = food[i].getF_url();
                        int resID = getResources().getIdentifier(picture, "mipmap", getPackageName());
                        Thing chide = new Thing(resID, food[i].getF_name(), food[i].getF_price(), food[i].getF_sellcount());
                        thingsList.add(chide);
                    }
                    FindAdapter adapter=new FindAdapter(FindActivity.this,R.layout.activity_find_item,thingsList);
                    ListView listView=(ListView)findViewById(R.id.list_view3);
                    listView.setAdapter(adapter);
                }
                else {
                    Toast.makeText(FindActivity.this, "查询不到", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}