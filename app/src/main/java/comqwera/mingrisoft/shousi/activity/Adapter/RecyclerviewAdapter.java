package comqwera.mingrisoft.shousi.activity.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import comqwera.mingrisoft.shousi.activity.activity.R;
import comqwera.mingrisoft.shousi.activity.activity.GoodsActivity;

import comqwera.mingrisoft.shousi.activity.fragment.Home_fragment;
import comqwera.mingrisoft.shousi.model.Shousi;

import java.util.ArrayList;
import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.viewhodler> {
    private final Context context;
    private List<Shousi> shousiList;

    public RecyclerviewAdapter(Context context, ArrayList<Shousi> shousiList) {
        this.context = context;
        this.shousiList = shousiList;
    }

    @NonNull
    @Override
    public viewhodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = View.inflate(context, R.layout.recycler_home, null);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, GoodsActivity.class);
                context.startActivity(intent);
            }
        });
        return new viewhodler(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull viewhodler viewodler, int postion) {
        Shousi shousi = shousiList.get(postion);
        viewodler.imageView.setImageResource(shousi.getImageID());
        viewodler.textView.setText(shousi.getName());

    }

    //得到总条数
    @Override
    public int getItemCount() {
        return shousiList.size();
    }

    class viewhodler extends RecyclerView.ViewHolder {

        private TextView textView;
        private ImageView imageView;
        private String cai;
        public viewhodler(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_home);
            textView = itemView.findViewById(R.id.tv);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cai=textView.getText().toString();
                    Intent intent = new Intent(context, GoodsActivity.class);
                    Bundle bundle=new Bundle();
                    bundle.putString ("cai", cai);
                    intent.putExtras (bundle);
                    context.startActivity(intent);

//                     Toast.makeText(context, "data==" + shousiList.get(getLayoutPosition()), Toast.LENGTH_SHORT).show();
//                    if(onItemClickListener !=null){
//                        onItemClickListener.onItemClick(v,shousiList.get(getLayoutPosition()));
//                    }
                }
            });
        }
    }
//    public  interface OnItemClickListener{
//        /**
//         * 点击RecylerView某条监听
//         * @param view 点击item的视图
//         * @param  data 点击得到的数据
//         */
//
//        public  void onItemClick(View view, Shousi data);
//    }
//    private OnItemClickListener onItemClickListener;
//
//    /**
//     * 设置RecylerView某个的监听
//     * @param onItemClickListener
//     */
//    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
//        this.onItemClickListener=onItemClickListener;
//    }
}