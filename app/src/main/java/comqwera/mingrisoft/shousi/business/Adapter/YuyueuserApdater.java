package comqwera.mingrisoft.shousi.business.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import comqwera.mingrisoft.shousi.activity.activity.R;
import comqwera.mingrisoft.shousi.business.modle.Inquiryuser;
import comqwera.mingrisoft.shousi.model.Onlineorder;
import comqwera.mingrisoft.shousi.model.Thing;

import java.util.List;

public class YuyueuserApdater extends ArrayAdapter<Onlineorder> {
    private int resourceId;

    public YuyueuserApdater(Context context, int textViewResourceId, List<Onlineorder> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Onlineorder onlineorder = getItem(position);

        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        TextView a=(TextView)view.findViewById(R.id.timeText1);
        TextView b=(TextView)view.findViewById(R.id.peopletext1);
        TextView c=(TextView)view.findViewById(R.id.phonetext1);
        TextView d=(TextView)view.findViewById(R.id.or_memotext1);
        TextView f=(TextView)view.findViewById(R.id.yuyueu_id1) ;
        a.setText(onlineorder.getOr_time());
        b.setText(onlineorder.getOr_sum());
        c.setText(onlineorder.getOr_phone());
        d.setText(onlineorder.getOr_memo());
        f.setText(Integer.toString(onlineorder.getU_id()));

        return view;
    }
}