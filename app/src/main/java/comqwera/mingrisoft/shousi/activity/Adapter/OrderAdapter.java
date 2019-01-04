package comqwera.mingrisoft.shousi.activity.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import comqwera.mingrisoft.shousi.activity.activity.R;
import comqwera.mingrisoft.shousi.model.Order;
import comqwera.mingrisoft.shousi.model.Thing;

import java.util.List;

public class OrderAdapter extends ArrayAdapter<Order> {
    private int resourceId;

    public OrderAdapter(Context context, int textViewResourceId, List<Order> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Order order=getItem(position);
        View view=LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        TextView a=(TextView)view.findViewById(R.id.dingdanbianhao);
        TextView b=(TextView)view.findViewById(R.id.dingdannicheng);
        TextView c=(TextView)view.findViewById(R.id.dingdancontext);
        TextView d=(TextView)view.findViewById(R.id.dingdanzonge);
        TextView e=(TextView)view.findViewById(R.id.dingdandizhi);
        a.setText("订单编号："+Integer.toString(order.getDingdan_id()));
        b.setText("用户昵称："+order.getUse_name());
        c.setText("点餐内容："+order.getUse_dingdanxinxi());
        d.setText("总共金额"+Float.toString(order.getDingdan_money()));
        e.setText("用户地址"+order.getUser_address());
        return view;
    }
}