package comqwera.mingrisoft.shousi.activity.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import comqwera.mingrisoft.shousi.activity.activity.GoodsActivity;
import comqwera.mingrisoft.shousi.activity.activity.R;
import comqwera.mingrisoft.shousi.model.shousi;

import java.util.ArrayList;
import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.viewhodler> {
    private final Context context;
    private List<shousi> shousiList;

    public RecyclerviewAdapter(Context context, ArrayList<shousi> shousiList) {
        this.context=context;
        this.shousiList=shousiList;
    }

    @NonNull
    @Override
    public viewhodler onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        View itemView=View.inflate(context, R.layout.recycler_home,null);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, GoodsActivity.class);
                context.startActivity(intent);
            }
        });
        return new viewhodler(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull viewhodler viewodler, int postion) {
        shousi shousi=shousiList.get(postion);
        viewodler.imageView.setImageResource(shousi.getImageID());
        viewodler.textView.setText(shousi.getName());
    }
    //得到总条数
    @Override
    public int getItemCount() {
        return shousiList.size();
    }

    class viewhodler extends RecyclerView.ViewHolder{

        private TextView textView;
        private ImageView imageView;
        public viewhodler(@NonNull View itemView) {
            super(itemView);
            imageView=(ImageView) itemView.findViewById(R.id.iv_home);
            textView=(TextView) itemView.findViewById(R.id.tv);
        }
    }
}