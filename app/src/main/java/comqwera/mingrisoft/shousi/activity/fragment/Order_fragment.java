package comqwera.mingrisoft.shousi.activity.fragment;

import android.view.View;
import android.widget.TextView;
import comqwera.mingrisoft.shousi.activity.activity.R;

public class Order_fragment extends Basefragment {

    private TextView textView;
    private String UID;
    private String ORP;     //定义电话号码
    @Override
    public View initview() {
        View view = View.inflate(mcontext, R.layout.order, null);
        onStart();
        return view;
    }

    public void initDate() {
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

