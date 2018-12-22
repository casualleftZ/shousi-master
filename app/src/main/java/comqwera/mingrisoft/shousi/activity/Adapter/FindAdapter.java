package comqwera.mingrisoft.shousi.activity.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
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
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Thing thing=getItem(position);
        View view=LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        ImageView img=(ImageView)view.findViewById(R.id.img);
        TextView tvName=(TextView)view.findViewById(R.id.tvName);
        TextView ratingBar=(TextView)view.findViewById(R.id.ratingBar);
        TextView tvPrice=(TextView)view.findViewById(R.id.tvName);
        return view;
    }
}
