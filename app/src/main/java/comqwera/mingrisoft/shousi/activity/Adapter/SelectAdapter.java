package comqwera.mingrisoft.shousi.activity.Adapter;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



import java.text.NumberFormat;


import comqwera.mingrisoft.shousi.DAO.FoodDAO;
import comqwera.mingrisoft.shousi.DAO.ShopthingDAO;
import comqwera.mingrisoft.shousi.activity.activity.R;
import comqwera.mingrisoft.shousi.activity.activity.ShoppingCartActivity;
import comqwera.mingrisoft.shousi.model.Food;
import comqwera.mingrisoft.shousi.model.GoodsItem;
import comqwera.mingrisoft.shousi.model.Shopthing;


public class SelectAdapter extends RecyclerView.Adapter<SelectAdapter.ViewHolder>{
    private ShoppingCartActivity activity;
    private SparseArray<GoodsItem> dataList;
    private NumberFormat nf;
    private LayoutInflater mInflater;
    public SelectAdapter(ShoppingCartActivity activity, SparseArray<GoodsItem> dataList) {
        this.activity = activity;

        this.dataList = dataList;
        nf = NumberFormat.getCurrencyInstance();
        nf.setMaximumFractionDigits(2);
        mInflater = LayoutInflater.from(activity);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_selected_goods,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        GoodsItem item = dataList.valueAt(position);
        holder.bindData(item);
    }

    @Override
    public int getItemCount() {
        if(dataList==null) {
            return 0;
        }
        return dataList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private GoodsItem item;
        private GoodsItem item2;
        private TextView tvCost,tvCount,tvAdd,tvMinus,tvName;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvCost = itemView.findViewById(R.id.tvCost);
            tvCount = itemView.findViewById(R.id.count);
            tvMinus = itemView.findViewById(R.id.tvMinus);
            tvAdd = itemView.findViewById(R.id.tvAdd);
//            ShopthingDAO shopthingDAO=new ShopthingDAO(ShoppingCartActivity.mshoppingCartActivity);
//            Shopthing shopthing[]=shopthingDAO.shopthingall();
//            FoodDAO foodDAO=new FoodDAO(ShoppingCartActivity.mshoppingCartActivity);
//            for(int i=0;i<shopthing.length;i++){
//
//                item2.name=shopthing[i].getF_name();
//                item2.rating=shopthing[i].getT_num();
//                item2.price=shopthing[i].getT_money();
//                item2.typeName=foodDAO.find2(shopthing[i].getF_name()).getF_type();
//                item2.typeId=foodDAO.find2(shopthing[i].getF_name()).getF_type_id();
//                item2.id=foodDAO.find2(shopthing[i].getF_name()).getF_id();
//                item2.count=shopthing[i].getT_num();
//                activity.add(item2, true);}
            tvMinus.setOnClickListener(this);
            tvAdd.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.tvAdd:
                    activity.add(item, true);
                    break;
                case R.id.tvMinus:
                    activity.remove(item, true);
                    break;
                default:
                    break;
            }
        }

        public void bindData(GoodsItem item){
            this.item = item;
            tvName.setText(item.name);
            tvCost.setText(nf.format(item.count*item.price));
            tvCount.setText(String.valueOf(item.count));
        }
//        public void bindData2(GoodsItem item2){
//            this.item2 = item2;
//            tvName.setText(item2.name);
//            tvCost.setText(nf.format(item2.count*item2.price));
//            tvCount.setText(String.valueOf(item2.count));
//        }
    }
}
