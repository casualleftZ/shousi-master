package comqwera.mingrisoft.shousi.business.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import comqwera.mingrisoft.shousi.DAO.MyuserDAO;
import comqwera.mingrisoft.shousi.activity.activity.R;
import comqwera.mingrisoft.shousi.business.Adapter.InquiryuserApdater;
import comqwera.mingrisoft.shousi.business.modle.Inquiryuser;

import java.util.ArrayList;
import java.util.List;

public class InquiryuserActivity extends AppCompatActivity {
    private List<Inquiryuser> inquiryuserList=new ArrayList<>();
    private String u_id;
    private String nickname;
    private String phone1;
    private String phone2;
    private String address;
    private EditText bus_seach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquiryuser);


        bus_seach=(EditText)findViewById(R.id.bus_seach);
        bus_seach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(InquiryuserActivity.this,SeachUserActivity.class);
                startActivity(intent);
            }
        });


        initInquiryuser();   //初始化list数据
        InquiryuserApdater adapter=new InquiryuserApdater(InquiryuserActivity.this,R.layout.inquiruser_item,
                inquiryuserList);
        ListView listView= findViewById(R.id.inquiruser1);
        listView.setAdapter(adapter);
    }
    private void initInquiryuser(){
        MyuserDAO myuserDAO=new MyuserDAO(InquiryuserActivity.this);
        int n;
        Inquiryuser biaoti=new Inquiryuser("用户id","昵称","注册手机","预留手机号码","地址");
        inquiryuserList.add(biaoti);
        for(int i=0;i<myuserDAO.getMaxId();i++){
            n=i+1;
            u_id=Integer.toString(myuserDAO.find2(n).getU_id());
            nickname=myuserDAO.find2(n).getU_nickname();
            phone1=myuserDAO.find2(n).getU_phone();
            phone2=myuserDAO.find2(n).getU_phone2();
            address=myuserDAO.find2(n).getU_adress();
            Inquiryuser yonghuxinxi=new Inquiryuser(u_id,nickname,phone1,phone2,address);
            inquiryuserList.add(yonghuxinxi);

        }
    }
}
