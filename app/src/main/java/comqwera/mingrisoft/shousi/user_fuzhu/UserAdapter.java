package comqwera.mingrisoft.shousi.user_fuzhu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import comqwera.mingrisoft.shousi.activity.activity.R;


import java.util.List;



public class UserAdapter extends ArrayAdapter{
    private final int resourceId;
    public UserAdapter(Context context,int textViewResourceId,List<User> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }
    @Override
    public View getView(int position, View converView, ViewGroup parent){
        User user=(User)getItem (position);//获取当前User实例
        View view= LayoutInflater.from (getContext ()).inflate(resourceId,null);//实例化一个对象
        TextView xinxiName=(TextView)view.findViewById (R.id.user_thing);//为文字视图设置图片资源
        TextView information=(TextView)view.findViewById (R.id.user_information); //为文字视图设置图片资源
        xinxiName.setText (user.getXinxi());//为文本视图设置文本内容
        information.setText (user.getInformation ());
        return view;
    }
}
