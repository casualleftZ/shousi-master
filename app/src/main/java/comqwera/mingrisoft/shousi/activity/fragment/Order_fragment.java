package comqwera.mingrisoft.shousi.activity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import comqwera.mingrisoft.shousi.DAO.Login1DAO;
import comqwera.mingrisoft.shousi.DAO.MyuserDAO;
import comqwera.mingrisoft.shousi.DAO.OnlineorderDAO;
import comqwera.mingrisoft.shousi.activity.activity.*;
import comqwera.mingrisoft.shousi.model.Login1;
import comqwera.mingrisoft.shousi.model.Onlineorder;

public class Order_fragment extends Basefragment {

    private TextView textView;
    private int UID;         //u_id
    private String PHONE;      //电话

    private String TIME;     //时间
    private String SHUOMING; //说明
    private String renshu;//人数
    private EditText time;   //获取文本框时间
    private EditText beizhu;  //获取文本框备注
    private EditText people;   //获取文本框人数
    private EditText phone;    //获取文本框电话
    private Button yuyuebutton;
    private Button yuyuexinxi;
    @Override
    public View initview() {
        View view = View.inflate(mcontext, R.layout.order, null);
        Login1DAO login1DAO = new Login1DAO(getActivity());
        yuyuebutton = (Button) view.findViewById(R.id.yuyuebutton);
        yuyuexinxi = (Button) view.findViewById(R.id.yuyuexinxi);
        time = view.findViewById(R.id.time);
        people = view.findViewById(R.id.people1);
        phone = view.findViewById(R.id.phone);
        beizhu = view.findViewById(R.id.or_memo);
        TIME = time.getText().toString();
        renshu=people.getText().toString();
        UID = login1DAO.find(1).getU_id();
        SHUOMING = beizhu.getText().toString();
        PHONE = phone.getText().toString();
        yuyuebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnlineorderDAO onlineorderDAO = new OnlineorderDAO(getActivity());
                if(onlineorderDAO.find2(UID)!=null) {
                    Onlineorder onlineorder = new Onlineorder(onlineorderDAO.getMaxId() + 1, UID,
                            PHONE, 0, renshu, null, null);
                    onlineorderDAO.add(onlineorder);
                    Login1DAO login1DAO=new Login1DAO(getActivity());
                    Login1 login1=new Login1();
                    login1.setOr_id(onlineorderDAO.getMaxId());
                    login1.setZt_id(1);
                    login1DAO.update(login1);

                   Toast.makeText(getActivity(), "预约成功", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(getActivity(), "已经预约成功",
                        Toast.LENGTH_SHORT).show();}
            }
        });

        yuyuexinxi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent a=new Intent(getActivity(),Orderfinish.class);
                startActivity(a);
            }
        });
        return view;
    }

    public void initDate() {
        super.initDate();

    }


}

