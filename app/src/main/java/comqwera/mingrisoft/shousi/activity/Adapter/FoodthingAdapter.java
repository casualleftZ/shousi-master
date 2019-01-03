package comqwera.mingrisoft.shousi.activity.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import comqwera.mingrisoft.shousi.activity.activity.R;
import comqwera.mingrisoft.shousi.model.Foodthing;

import java.util.List;

public class FoodthingAdapter extends ArrayAdapter {
    private int resourveID;
    public FoodthingAdapter(Context context, int textViewResourceId, List<Foodthing>objects){
        super(context,textViewResourceId,objects);
        resourveID=textViewResourceId;
    }
    @Override
    public View getView(int position,View convertView,ViewGroup parent){
        Foodthing foodthing= (Foodthing) getItem(position);
        View view=LayoutInflater.from(getContext()).inflate(resourveID,parent,false);
        TextView food_name=(TextView)view.findViewById(R.id.dingdan_shousi);
        TextView food_count=(TextView)view.findViewById(R.id.dingdan_shuliang);
        TextView food_num_money=(TextView)view.findViewById(R.id.dingdan_money);
        food_name.setText(foodthing.getFood_name());
        food_count.setText(Integer.toString(foodthing.getFood_count()));
        food_num_money.setText(Float.toString(foodthing.getFood_num_money()));
        return view;
    }
}
