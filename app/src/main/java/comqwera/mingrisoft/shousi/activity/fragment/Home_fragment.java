package comqwera.mingrisoft.shousi.activity.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import comqwera.mingrisoft.shousi.activity.Adapter.RecyclerviewAdapter;
import comqwera.mingrisoft.shousi.activity.activity.R;
import comqwera.mingrisoft.shousi.model.shousi;

import java.util.ArrayList;
import java.util.List;


public class Home_fragment extends Basefragment {
    private Banner banner;
    private RecyclerView recyclerView;
    private RecyclerviewAdapter recyclerviewAdapter;
    private ArrayList<shousi> shousiList=new ArrayList<>();

    @Override
    public View initview() {
        View view = View.inflate(mcontext, R.layout.home_fragment, null);




        return view;
    }
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initRecyclerView();
        getdtring();
        init();
    }
    //banner图片轮播
    public void init() {
        banner = getActivity().findViewById(R.id.banner);
        int[] imageResouceID = new int[]{R.mipmap.zhujiemian1, R.mipmap.zhujiemian2, R.mipmap.zhujiemian3, R.mipmap.zhujiemian4};
        List<Integer> imageList = new ArrayList<>();
        for (int i = 0; i < imageResouceID.length; i++) {
            imageList.add(imageResouceID[i]);
            banner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Glide.with(Home_fragment.this).load(path).into(imageView);
                }
            });
            banner.setDelayTime(3000);////设置轮播时间
            banner.setBannerAnimation(Transformer.CubeOut);////设置banner动画效果
            banner.setImages(imageList);
            banner.start();
        }

    }
/*
    public void onStart() {
        super.onStart();
        banner.startAutoPlay();
    }

    public void onStop() {
        super.onStop();
        banner.stopAutoPlay();
    }
    */
    private void initRecyclerView() {
        //获取RecyclerView
        recyclerView = (RecyclerView) getActivity().findViewById(R.id.re_home);
        //创建adapter
        recyclerviewAdapter = new RecyclerviewAdapter(getActivity(),shousiList);
        //给RecyclerView设置adapter
        recyclerView.setAdapter(recyclerviewAdapter);
        //设置layoutManager,可以设置显示效果，是线性布局、grid布局，还是瀑布流布局
        //参数是：上下文、列表方向（横向还是纵向）、是否倒叙
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2, GridLayoutManager.VERTICAL, false));
        //设置item的分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));


    }
    private void getdtring(){
        shousi hot1=new shousi("今日火爆",R.mipmap.zhujiemian1);
        shousiList.add(hot1);
        shousi hot2=new shousi("热卖ing",R.mipmap.zhujiemian2);
        shousiList.add(hot2);
        shousi hot3=new shousi("不可错过",R.mipmap.zhujiemian3);
        shousiList.add(hot3);
        shousi hot4=new shousi("特惠",R.mipmap.zhujiemian4);
        shousiList.add(hot4);
        shousi hot5=new shousi("店长推荐",R.mipmap.zhujiemian3);
        shousiList.add(hot5);
        shousi hot6=new shousi("火爆",R.mipmap.zhujiemian4);
        shousiList.add(hot6);

    }
    protected void initData() {
        super.initDate();
    }

}

