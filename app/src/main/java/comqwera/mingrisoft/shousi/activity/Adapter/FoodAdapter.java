package comqwera.mingrisoft.shousi.activity.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import comqwera.mingrisoft.shousi.model.Food;

import java.util.List;

public class FoodAdapter extends ArrayAdapter<Food> {
    private int resourceId;
    public FoodAdapter(Context context, int textViewResourceID, List<Food>objects) {
        super(context, textViewResourceID, objects);
        resourceId = textViewResourceID;
    }
        @Override
         public View getView(int position, View converView, ViewGroup parent){
                  Food food=getItem(position); //获取当前food实例
                  View view=LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
                  return view;
    }
}
