package comqwera.mingrisoft.shousi.activity.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.*;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import comqwera.mingrisoft.shousi.DAO.ShopthingDAO;
import comqwera.mingrisoft.shousi.activity.activity.R;
import comqwera.mingrisoft.shousi.activity.activity.ShoppingCartActivity;
import comqwera.mingrisoft.shousi.model.GoodsItem;
import comqwera.mingrisoft.shousi.model.Shopthing;
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

import java.text.NumberFormat;
import java.util.ArrayList;


public class GoodsAdapter extends BaseAdapter implements StickyListHeadersAdapter {

    private ArrayList<GoodsItem> dataList;
    private ShoppingCartActivity mContext;
    private NumberFormat nf;
    private LayoutInflater mInflater;

    public GoodsAdapter(ArrayList<GoodsItem> dataList, ShoppingCartActivity mContext) {
        this.dataList = dataList;
        this.mContext = mContext;
        nf = NumberFormat.getCurrencyInstance();
        nf.setMaximumFractionDigits(2);
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        if(convertView==null) {
            convertView = mInflater.inflate(R.layout.iitem_hader_view, parent, false);
        }
        ((TextView)(convertView)).setText(dataList.get(position).typeName);
        return convertView;
    }

    @Override
    public long getHeaderId(int position) {
        return dataList.get(position).typeId;
    }

    @Override
    public int getCount() {
        if(dataList==null){
            return 0;
        }
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemViewHolder holder = null;
        if(convertView==null){
            convertView = mInflater.inflate(R.layout.item_goods,parent,false);
            holder = new ItemViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ItemViewHolder) convertView.getTag();
        }
//        ShopthingDAO shopthingDAO=new ShopthingDAO(ShoppingCartActivity.mshoppingCartActivity);
//        Shopthing shopthing[]=shopthingDAO.shopthingall("f_name");
//        for(int i=0;i<shopthing.length;i++){
//        GoodsItem item2=dataList.get(position);
//            item2.count = shopthing[i].getT_num();
//            holder.tvCount.setText(String.valueOf(item2.count));
//            holder.price.setText(nf.format(item2.price));
//            holder(item2);
//        }
        GoodsItem item = dataList.get(position);
        holder.bindData(item);
        return convertView;
    }

        class ItemViewHolder implements View.OnClickListener{
            private TextView name,price,tvAdd,tvMinus,tvCount;
            private GoodsItem item;
            private TextView ratingBar;
            private ImageView img;

            public ItemViewHolder(View itemView) {
                name = itemView.findViewById(R.id.tvName1);
                price = itemView.findViewById(R.id.tvPrice);
                tvCount = itemView.findViewById(R.id.count);
                tvMinus = itemView.findViewById(R.id.tvMinus);
                tvAdd = itemView.findViewById(R.id.tvAdd);
                ratingBar = itemView.findViewById(R.id.ratingBar);
                img=itemView.findViewById(R.id.img);
                tvMinus.setOnClickListener(this);
                tvAdd.setOnClickListener(this);
            }

            public void bindData(GoodsItem item){
                this.item = item;
                name.setText(item.name);
                ratingBar.setText("月售:"+item.rating);
                int resID=ShoppingCartActivity.mshoppingCartActivity.getResources().getIdentifier(item.f_picture,"mipmap",ShoppingCartActivity.mshoppingCartActivity.getPackageName());
                img.setImageResource(resID);
                item.count = mContext.getSelectedItemCountById(item.id);
                tvCount.setText(String.valueOf(item.count));
                price.setText(nf.format(item.price));

                if(item.count<1){
                    tvCount.setVisibility(View.GONE);
                    tvMinus.setVisibility(View.GONE);
                }else{
                    tvCount.setVisibility(View.VISIBLE);
                    tvMinus.setVisibility(View.VISIBLE);
                }
            }

        @Override
        public void onClick(View v) { //加减商品
            ShoppingCartActivity activity = mContext;
            switch (v.getId()){
                case R.id.tvAdd: {
                    int count = activity.getSelectedItemCountById(item.id);
                    if (count < 1) {
                        tvMinus.setAnimation(getShowAnimation());
                        tvMinus.setVisibility(View.VISIBLE);   //显示减法按钮
                        tvCount.setVisibility(View.VISIBLE);   //显示加法按钮
                    }
                    activity.add(item, false);
                    count++;
                    tvCount.setText(String.valueOf(count));
                    int[] loc = new int[2];
                    v.getLocationInWindow(loc);
                    activity.playAnimation(loc);
                }
                break;
                case R.id.tvMinus: {
                    int count = activity.getSelectedItemCountById(item.id);
                    if (count < 2) {
                        tvMinus.setAnimation(getHiddenAnimation());
                        tvMinus.setVisibility(View.GONE);
                        tvCount.setVisibility(View.GONE);
                    }
                    count--;
                    activity.remove(item, false);//activity.getSelectedItemCountById(item.id)
                    tvCount.setText(String.valueOf(count));

                }
                break;
                default:
                    break;
            }
        }
    }

    private Animation getShowAnimation(){
        AnimationSet set = new AnimationSet(true);
        RotateAnimation rotate = new RotateAnimation(0,720,
                RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.
                RELATIVE_TO_SELF,0.5f);
        set.addAnimation(rotate);
        TranslateAnimation translate = new TranslateAnimation(
                TranslateAnimation.RELATIVE_TO_SELF,2f
                ,TranslateAnimation.RELATIVE_TO_SELF,0
                ,TranslateAnimation.RELATIVE_TO_SELF,0
                ,TranslateAnimation.RELATIVE_TO_SELF,0);
        set.addAnimation(translate);
        AlphaAnimation alpha = new AlphaAnimation(0,1);
        set.addAnimation(alpha);
        set.setDuration(500);
        return set;
    }

    private Animation getHiddenAnimation(){
        AnimationSet set = new AnimationSet(true);
        RotateAnimation rotate = new RotateAnimation(0,720,
                RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
        set.addAnimation(rotate);
        TranslateAnimation translate = new TranslateAnimation(
                TranslateAnimation.RELATIVE_TO_SELF,0
                ,TranslateAnimation.RELATIVE_TO_SELF,2f
                ,TranslateAnimation.RELATIVE_TO_SELF,0
                ,TranslateAnimation.RELATIVE_TO_SELF,0);
        set.addAnimation(translate);
        AlphaAnimation alpha = new AlphaAnimation(1,0);
        set.addAnimation(alpha);
        set.setDuration(500);
        return set;
    }
}
