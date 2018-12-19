package comqwera.mingrisoft.shousi.activity.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

import comqwera.mingrisoft.shousi.DAO.FoodDAO;
import comqwera.mingrisoft.shousi.activity.Adapter.RecyclerviewAdapter;
import comqwera.mingrisoft.shousi.activity.activity.R;
import comqwera.mingrisoft.shousi.model.shousi;

import java.util.ArrayList;
import java.util.List;


public class Home_fragment extends Basefragment {
    private Banner banner;
    private RecyclerView recyclerView;
    private RecyclerviewAdapter recyclerviewAdapter;
    private ArrayList<shousi> shousiList = new ArrayList<>();

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
        recyclerviewAdapter = new RecyclerviewAdapter(getActivity(), shousiList);
        //给RecyclerView设置adapter
        recyclerView.setAdapter(recyclerviewAdapter);
        //设置layoutManager,可以设置显示效果，是线性布局、grid布局，还是瀑布流布局
        //参数是：上下文、列表方向（横向还是纵向）、是否倒叙
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false));
        //设置item的分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));


    }

    private String shouyewenzi1;
    private String shouyewenzi2;
    private String shouyewenzi3;
    private String shouyewenzi4;
    private String shouyewenzi5;
    private String shouyewenzi6;
    private String shouyewenzi7;
    private String shouyewenzi8;
    private String shouyetupian1;
    private String shouyetupian2;
    private String shouyetupian3;
    private String shouyetupian4;
    private String shouyetupian5;
    private String shouyetupian6;
    private String shouyetupian7;
    private String shouyetupian8;
    private void getdtring() { //主界面8幅图
        FoodDAO foodDAO = new FoodDAO(getActivity());
        if (foodDAO.getMaxId() > 0) {
            shouyewenzi1 = foodDAO.find(1).getF_name();
            shouyetupian1 = foodDAO.find(1).getF_url();
            shousi hot1 = new shousi(shouyewenzi1,  getDrawResourceID(shouyetupian1 ));
            shousiList.add(hot1);

        } else {
            shousi hot1 = new shousi("待添加", R.mipmap.daitianjia);
            shousiList.add(hot1);
        }
        if (foodDAO.getMaxId() > 1) {
            shouyewenzi2 = foodDAO.find(2).getF_name();
            shouyetupian2 = foodDAO.find(2).getF_url();
            shousi hot2 = new shousi(shouyewenzi2,  getDrawResourceID(shouyetupian2 ));
            shousiList.add(hot2);
        }
        else{
            shousi hot2 = new shousi("待添加",R.mipmap.daitianjia);
        shousiList.add(hot2);
        }
        if (foodDAO.getMaxId() > 2) {
            shouyewenzi3= foodDAO.find(3).getF_name();
            shouyetupian3 = foodDAO.find(3).getF_url();
            shousi hot3 = new shousi(shouyewenzi3,  getDrawResourceID(shouyetupian3 ));
            shousiList.add(hot3);
        }
        else
            {
                shousi hot3 = new shousi("待添加", R.mipmap.daitianjia);
                shousiList.add(hot3);
            }
        if (foodDAO.getMaxId() > 3) {
            shouyewenzi4= foodDAO.find(4).getF_name();
            shouyetupian4 = foodDAO.find(4).getF_url();
            shousi hot4 = new shousi(shouyewenzi4,  getDrawResourceID(shouyetupian4 ));
            shousiList.add(hot4);
        }
          else {
            shousi hot4 = new shousi("待添加",  R.mipmap.daitianjia);
            shousiList.add(hot4);
        }
        if (foodDAO.getMaxId() > 4) {
            shouyewenzi5= foodDAO.find(5).getF_name();
            shouyetupian5 = foodDAO.find(5).getF_url();
            shousi hot5 = new shousi(shouyewenzi5,  getDrawResourceID(shouyetupian5 ));
            shousiList.add(hot5);
        }
        else{
        shousi hot5 = new shousi("待添加", R.mipmap.daitianjia);
        shousiList.add(hot5);}
        if (foodDAO.getMaxId() > 5) {
            shouyewenzi6= foodDAO.find(6).getF_name();
            shouyetupian6 = foodDAO.find(6).getF_url();
            shousi hot5 = new shousi(shouyewenzi6,  getDrawResourceID(shouyetupian6 ));
            shousiList.add(hot5);
        }
        else {
            shousi hot6 = new shousi("待添加", R.mipmap.daitianjia);
            shousiList.add(hot6);
        }
        if (foodDAO.getMaxId() > 6) {
            shouyewenzi7= foodDAO.find(7).getF_name();
            shouyetupian7 = foodDAO.find(7).getF_url();
            shousi hot7 = new shousi(shouyewenzi7,  getDrawResourceID(shouyetupian7 ));
            shousiList.add(hot7);
        }
        else {
            shousi hot7 = new shousi("待添加", R.mipmap.daitianjia);
            shousiList.add(hot7);
        }
        if (foodDAO.getMaxId() >7) {
            shouyewenzi8= foodDAO.find(8).getF_name();
            shouyetupian8 = foodDAO.find(8).getF_url();
            shousi hot8 = new shousi(shouyewenzi8,  getDrawResourceID(shouyetupian8 ));
            shousiList.add(hot8);
        }
        else {
            shousi hot8 = new shousi("待添加", R.mipmap.daitianjia);
            shousiList.add(hot8);
        }
    }

    protected void initData() {
        super.initDate();
    }


    /**

     * 根据图片的名称获取对应的资源id

     * @param resourceName

     * @return

     */

    public int getDrawResourceID(String resourceName) {

        Resources res=getResources();

        int picid = res.getIdentifier(resourceName,"mipmap",getActivity().getPackageName());

        return picid;

    }

}