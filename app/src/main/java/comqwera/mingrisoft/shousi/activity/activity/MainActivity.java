package comqwera.mingrisoft.shousi.activity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import comqwera.mingrisoft.shousi.DAO.Login1DAO;
import comqwera.mingrisoft.shousi.DAO.RestaurantDAO;
import comqwera.mingrisoft.shousi.activity.activity.R;
import comqwera.mingrisoft.shousi.activity.fragment.*;
import comqwera.mingrisoft.shousi.model.Restaurant;

import java.util.ArrayList;


public class MainActivity extends FragmentActivity {
    private RadioGroup mrg;

    private RadioButton radioButton;
    private ArrayList<Basefragment> fragments;
    FrameLayout fragment;
    private int post = 0;
    private Fragment tempfragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);
        RestaurantDAO restaurantDAO=new RestaurantDAO(MainActivity.this);
        if(restaurantDAO.getMaxId()==0){
        Restaurant restaurant=new Restaurant(1,"chenhuanzhenchou","陈桓寿司","8:00","江西师范大学",
                "10086","陈桓牌寿司好吃不上火");

        restaurantDAO.add(restaurant);}
        fragment = findViewById(R.id.fl_connect);
        mrg = findViewById(R.id.rg1);
        initfragment();
        //设置RadioGroup的监听
//        int id = getIntent().getIntExtra("id", 0);


        setListenner();

    }

    private String zhanghao;

    private void setListenner() {

        mrg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbzhuye:
                        post = 0;
                        break;
                    case R.id.rbfenlei:
                        post = 1;
                        break;
                    case R.id.rbyuyue:
                        post = 2;
                        break;
                    case R.id.rbme:
                        post = 3;
                        break;
                    default:
                        post = 0;
                        break;
                }
                Login1DAO login1DAO = new Login1DAO(MainActivity.this);
                if (login1DAO.getMaxId() == 0 && post != 0) {
                    Toast.makeText(MainActivity.this, "请先登录", Toast.LENGTH_SHORT).show();
                    Intent b = new Intent(MainActivity.this, Login.class);
                    startActivity(b);
                } else {
                    Basefragment basefragment = getfragment(post);
                    //根据位置得到相应的Fragment
                    //替换
                    switchfragment(tempfragment, basefragment);
                }
            }
        });
        mrg.check(R.id.rbzhuye);
    }

    public void initfragment() {
        fragments = new ArrayList<>();
        fragments.add(new Home_fragment());
        fragments.add(new Type_fragment());
        fragments.add(new Order_fragment());
        fragments.add(new User_fragment());
    }

    private Basefragment getfragment(int post) {
        if (fragments != null && fragments.size() > 0) {
            Basefragment basefragment = fragments.get(post);
            return basefragment;
        }
        return null;
    }

    /**
     * @param fromfragment
     * @param nextfragment
     */
    private void switchfragment(Fragment fromfragment, Basefragment nextfragment) {
        if (tempfragment != nextfragment) {
            tempfragment = nextfragment;
            //才切换

            if (nextfragment != null) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                //判断没有被添加
                if (!nextfragment.isAdded()) {
                    //nextfragment没有被添加
                    if (fromfragment != null) {
                        transaction.hide(fromfragment);
                    }
                    transaction.add(R.id.fl_connect, nextfragment).commit();
                } else {
                    if (fromfragment != null) {
                        transaction.hide(fromfragment);
                    }
                    transaction.show(nextfragment).commit();
                }

            }
        }
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        int id = getIntent().getIntExtra("id", 0);
//        if (id == 2) {
//            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//
//            transaction.show(nextfragment).commit();
//            Intent i=new Intent();
//            i.setClass(MainActivity.this,Order_fragment.class);
//            i.putExtra("id",2);



        }

