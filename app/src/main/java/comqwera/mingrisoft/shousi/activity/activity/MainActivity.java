package comqwera.mingrisoft.shousi.activity.activity;

import android.content.Intent;
import android.os.Bundle;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.lang.invoke.ConstantCallSite;
import java.util.ArrayList;



import comqwera.mingrisoft.shousi.activity.fragment.Basefragment;
import comqwera.mingrisoft.shousi.activity.fragment.Home_fragment;
import comqwera.mingrisoft.shousi.activity.fragment.Order_fragment;
import comqwera.mingrisoft.shousi.activity.fragment.Type_fragment;
import comqwera.mingrisoft.shousi.activity.fragment.User_fragment;


public class MainActivity extends FragmentActivity{
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
        fragment = (FrameLayout) findViewById(R.id.fl_connect);
        mrg = (RadioGroup) findViewById(R.id.rg1);
        initfragment();
        //设置RadioGroup的监听

        setListenner();
    }

    private String zhanghao;
    private void setListenner() {

        mrg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Intent intent=getIntent();
                zhanghao= (String) intent.getExtras().get("zhanghao");
                Bundle bundle=new Bundle();
                bundle.putString ("zhanghao", zhanghao);
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
                //根据位置得到相应的Fragment
                Basefragment basefragment = getfragment(post);
                //替换
                basefragment.setArguments(bundle);
                switchfragment(tempfragment,basefragment);
            }
        });
        mrg.check(R.id.rbzhuye);
    }

    public void initfragment() {
        fragments = new ArrayList<>();
        fragments.add(new Home_fragment ());
        fragments.add(new Type_fragment ());
        fragments.add(new Order_fragment ());
        fragments.add(new User_fragment ());
    }

    private Basefragment getfragment(int post) {
        if (fragments != null && fragments.size() > 0) {
            Basefragment basefragment = fragments.get(post);
            return basefragment;
        }
        return null;
    }
   /**
   *@param fromfragment
   *@param nextfragment
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
                    transaction.add(R.id.fl_connect,nextfragment).commit();
                }else {
                    if (fromfragment!=null){
                        transaction.hide(fromfragment);
                    }
                    transaction.show(nextfragment).commit();
                }

            }
        }
    }
}
