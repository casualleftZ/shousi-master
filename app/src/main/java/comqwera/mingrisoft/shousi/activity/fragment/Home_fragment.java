package comqwera.mingrisoft.shousi.activity.fragment;

import android.view.View;
import comqwera.mingrisoft.shousi.activity.activity.R;


public class Home_fragment extends Basefragment {
    @Override
    public View initview() {
        View view = View.inflate(mcontext, R.layout.activity_home, null);
        onStart();

        return view;
    }

    protected void initData() {
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