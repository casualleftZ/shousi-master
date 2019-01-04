package comqwera.mingrisoft.shousi.activity.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import comqwera.mingrisoft.shousi.DAO.Login1DAO;
import comqwera.mingrisoft.shousi.DAO.MyuserDAO;
import comqwera.mingrisoft.shousi.activity.Adapter.UserAdapter;
import comqwera.mingrisoft.shousi.model.Login1;
import comqwera.mingrisoft.shousi.model.User;

import java.util.ArrayList;
import java.util.List;

public class MymessageActivity extends AppCompatActivity {

    private Button xiugaixinxi;
    private int u_id;
    private List<User>userList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mymessage);
        Login1DAO login1DAO=new Login1DAO(MymessageActivity.this);
        MyuserDAO myuserDAO=new MyuserDAO(MymessageActivity.this);
        u_id=login1DAO.find(1).getU_id();

        User user_id=new User("用户昵称：",myuserDAO.find2(u_id).getU_nickname());
        userList.add(user_id);
        User user_address=new User("用户地址：",myuserDAO.find2(u_id).getU_adress());
        userList.add(user_address);
        User user_phone=new User("预留电话号码：",myuserDAO.find2(u_id).getU_phone());
        userList.add(user_phone);
        UserAdapter adapter=new UserAdapter(MymessageActivity.this,R.layout.user_xinxi,userList);
        ListView listView=(ListView)findViewById(R.id.list_view8) ;
        listView.setAdapter(adapter);





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
