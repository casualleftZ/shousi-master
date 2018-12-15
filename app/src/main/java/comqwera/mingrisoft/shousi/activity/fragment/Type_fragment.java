package comqwera.mingrisoft.shousi.activity.fragment;

import android.view.View;
import android.widget.TextView;

public class Type_fragment extends Basefragment {

    private TextView textView;
    @Override
    public View initview() {
        textView=new TextView(mcontext);

        return textView;
    }
    public void initDate(){
        super.initDate();
        textView.setText("nhg ");
    }
    private String zhanghao;

}

