package comqwera.mingrisoft.shousi.activity.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import comqwera.mingrisoft.shousi.activity.activity.FindActivity;
import comqwera.mingrisoft.shousi.activity.activity.R;
import comqwera.mingrisoft.shousi.model.Thing;

import java.lang.reflect.Array;
import java.util.List;

public class FindAdapter extends ArrayAdapter<Thing> {
    private int resourceId;
    public FindAdapter(Context context, int textViewResourceId, List<Thing> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }
    private String tvname;//菜名
    private String ratingBar;//销售数目
    private String tvprice; //菜价格
    private String picture; //图片id
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Thing thing=getItem(position);
        View view=LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        ImageView img= view.findViewById(R.id.img);
        TextView tvName= view.findViewById(R.id.tvName);
        TextView ratingBar= view.findViewById(R.id.ratingBar);
        TextView tvPrice= view.findViewById(R.id.tvName);
        tvName.setText(thing.getF_name());
        ratingBar.setText(Integer.toString(thing.getF_sellcount()));
        tvPrice.setText(Float.toString(thing.getF_price()));
        img.setImageResource(thing.getF_url());
        tvName.setText(thing.getF_name());
        return view;
    }
}
