package comqwera.mingrisoft.shousi.activity.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**
*作用：基类
*
*/
public abstract class Basefragment extends Fragment {
  /**
  *上下文
*/
    protected Context mcontext;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mcontext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return initview();
    }
    /**
    *强制子类重写，实现之类特有的Ui
*/
    public abstract View initview();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initDate();
    }

    protected void initDate(){

    }
}
