package comqwera.mingrisoft.shousi.business.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import comqwera.mingrisoft.shousi.activity.activity.R;
import comqwera.mingrisoft.shousi.business.modle.Inquiryuser;

import java.util.List;

public class InquiryuserApdater extends ArrayAdapter<Inquiryuser>
{
    private  int resourceId1;
    public InquiryuserApdater(Context context, int textViewResourceId, List<Inquiryuser> objects) {
        super(context, textViewResourceId,objects);
        resourceId1=textViewResourceId;
    }
    @Override
    public View getView(int position, View converView, ViewGroup parent){
        Inquiryuser inquiryuser=getItem(position);
        View view=LayoutInflater.from(getContext()).inflate(resourceId1,parent,false);
        TextView user_id= view.findViewById(R.id.user_nickname);
        TextView user_nickname= view.findViewById(R.id.user_id);
        TextView user_phone1= view.findViewById(R.id.user_phone1);
        TextView user_phone2= view.findViewById(R.id.user_phone2);
        TextView user_address= view.findViewById(R.id.user_address);
        user_id.setText(inquiryuser.getU_id1());
        user_nickname.setText(inquiryuser.getU_nickname1());
        user_phone1.setText(inquiryuser.getU_phone1());
        user_phone2.setText(inquiryuser.getU_phone21());
        user_address.setText(inquiryuser.getU_adress());
        return view;
    }
}
