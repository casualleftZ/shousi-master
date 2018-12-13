package comqwera.mingrisoft.shousi.activity.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import comqwera.mingrisoft.shousi.DAO.MyuserDAO;
import comqwera.mingrisoft.shousi.DAO.OnlineorderDAO;
import comqwera.mingrisoft.shousi.activity.activity.Login;
import comqwera.mingrisoft.shousi.activity.activity.Orderfinish;
import comqwera.mingrisoft.shousi.activity.activity.R;
import comqwera.mingrisoft.shousi.activity.activity.Zhuce;
import comqwera.mingrisoft.shousi.model.Onlineorder;

public class Order_fragment extends Basefragment {

    private TextView textView;
    private int UID;         //u_id
    private String ORP;      //定义电话号码
    private String zhanghao; //定义u_id
    private String TIME;     //定义时间
    private String SHUOMING; //说明
    private int renshu;      //人数
    private EditText time;   //获取时间文本框
    private EditText people;  //获取人数文本框
    private EditText phone;
    private EditText beizhu;
    private Button yuyuebutton;
    private Button yuyuexinxi;
    @Override
    public View initview() {
        View view = View.inflate(mcontext, R.layout.order, null);
        onStart();
       MyuserDAO myuserDAO = new MyuserDAO(getActivity());
        Toast.makeText(getActivity(), zhanghao,
                Toast.LENGTH_SHORT).show();
        yuyuebutton = (Button) view.findViewById(R.id.yuyuebutton);
        yuyuexinxi = (Button) view.findViewById(R.id.yuyuexinxi);
        time = view.findViewById(R.id.time);
        people = view.findViewById(R.id.people);
        phone = view.findViewById(R.id.phone);
        beizhu = view.findViewById(R.id.or_memo);
        TIME = time.getText().toString();
//      renshu = Integer.parseInt(people.getText().toString());
        UID = myuserDAO.find(zhanghao).getU_id();
        SHUOMING = beizhu.getText().toString();
        ORP = phone.getText().toString();
        yuyuebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnlineorderDAO onlineorderDAO = new OnlineorderDAO(getActivity());
                if(onlineorderDAO.find2(UID)!=null) {
                    Onlineorder onlineorder = new Onlineorder(onlineorderDAO.getMaxId() + 1, UID,
                            ORP, 0, 10, null, null);
                    onlineorderDAO.add(onlineorder);

                    Intent intent = new Intent(getActivity(), Orderfinish.class);
                    Toast.makeText(getActivity(), "预约成功",
                            Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
                else {Toast.makeText(getActivity(), "你已经预约成功",
                        Toast.LENGTH_SHORT).show();}
            }
      });
        return view;
    }
    public void initDate() {
        super.initDate();

    }

    @Override
    public void onStart() {
        super.onStart();
        if (isAdded()) {//判断Fragment已经依附Activity
            zhanghao = getArguments().getString("zhanghao");
        }
    }
}

