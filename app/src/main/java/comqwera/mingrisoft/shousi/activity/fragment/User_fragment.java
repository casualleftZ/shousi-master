package comqwera.mingrisoft.shousi.activity.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import comqwera.mingrisoft.shousi.activity.activity.Login;
import comqwera.mingrisoft.shousi.activity.activity.R;
import comqwera.mingrisoft.shousi.user_fuzhu.User;
import comqwera.mingrisoft.shousi.user_fuzhu.UserAdapter;

import java.util.ArrayList;
import java.util.List;


public class User_fragment extends Basefragment{
    private List<User>userlist=new ArrayList<User> ();
    private  LinearLayout wode_login;
    private Button button;

    public View initview() {
        View view = View.inflate (mcontext, R.layout.user_activity, null);
/**       wode_login = (LinearLayout) view.findViewById (R.id.wode_login);
        wode_login.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getActivity (), Login.class);
                startActivity (intent);
            }
        }); */
        onStart();
        initUser ();//初始化信息数据
        UserAdapter adapter = new UserAdapter (getActivity (), R.layout.user_xinxi, userlist);
        ListView listView = view.findViewById (R.id.list_view);
        listView.setAdapter (adapter);
        return view;
    }
    private void initUser(){
        User id=new User ("用户id:","001");
        userlist.add (id);
        User nicheng=new User ("昵称:" ,"...");
        userlist.add (nicheng);
        User phone=new User ("电话号码:","1111111");
        userlist.add (phone);
        User address=new User ("地址:","江西师范大学");
        userlist.add (address);
    }
    public void initDate(){
        super.initDate();

    }
    private String zhanghao;

    @Override
    public void onStart() {
        super.onStart();
        if (isAdded()) {//判断Fragment已经依附Activity
            zhanghao = getArguments().getString("zhanghao");
        }
    }
}


