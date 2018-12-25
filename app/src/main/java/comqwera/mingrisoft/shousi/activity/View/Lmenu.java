package comqwera.mingrisoft.shousi.activity.View;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import comqwera.mingrisoft.shousi.activity.activity.R;

import java.util.ArrayList;
import java.util.List;

public class Lmenu extends RelativeLayout implements View.OnClickListener {
    private ImageView center,hot,discount,new_foods,delicious,snack,drink;

    private List<ImageView> oViews;

    private boolean mFlag=true;

    private float mHiddenViewMeasuredHeight;

    public Lmenu(Context context) {
        this(context,null);
    }

    public Lmenu(Context context, AttributeSet attrs) {
        super(context, attrs);

        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.menu_layout, this);
        center=(ImageView) findViewById(R.id.center);
        hot=(ImageView) findViewById(R.id.hot);
        discount=(ImageView) findViewById(R.id.discount);
        new_foods=(ImageView) findViewById(R.id.new_foods);
        delicious=(ImageView) findViewById(R.id.delicious);
        snack=(ImageView) findViewById(R.id.snack);
        drink=(ImageView) findViewById(R.id.drink);

        //将四个Imageview放在集合里，方便管理
        oViews=new ArrayList<ImageView>();
        oViews.add(center);
        oViews.add(hot);
        oViews.add(discount);
        oViews.add(new_foods);
        oViews.add(delicious);
        oViews.add(snack);
        oViews.add(drink);

        center.setOnClickListener(this);
        hot.setOnClickListener(this);
        discount.setOnClickListener(this);
        new_foods.setOnClickListener(this);
        delicious.setOnClickListener(this);
        snack.setOnClickListener(this);
        drink.setOnClickListener(this);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mHiddenViewMeasuredHeight = (int) (w*1/12);
        Anim(mHiddenViewMeasuredHeight,-mHiddenViewMeasuredHeight ,0.5f, 1f, 0f, 90f);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.center:
                if (mFlag) {
                    Anim(-mHiddenViewMeasuredHeight,mHiddenViewMeasuredHeight, 1f, 0.5f, 90f, 0f);;
                    mFlag=false;
                }else {
                    Anim(mHiddenViewMeasuredHeight, -mHiddenViewMeasuredHeight,0.5f, 1f, 0f, 90f);
                    mFlag=true;
                }
                break;
            case R.id.hot:
                if (listener!=null) {
                    listener.hot();
                }
                break;
            case R.id.discount:
                if (listener!=null) {
                    listener.discount();
                }
                break;

            case R.id.new_foods:
                if (listener!=null) {
                    listener.new_foods();
                }
            case R.id.delicious:
                if (listener!=null) {
                    listener.delicious();
                }
            case R.id.snack:
                if (listener!=null) {
                    listener.snack();
                }
            case R.id.drink:
                if (listener!=null) {
                    listener.drink();
                }
                break;

            default:
                break;
        }
    }

    private void Anim(float mHiddenViewMeasuredHeightBegin,float mHiddenViewMeasuredHeightyClose,float x,float y,float anglex,float angley){

        //设置动画。用于弹出和收回
        ObjectAnimator animator0=ObjectAnimator.ofFloat(oViews.get(0), "alpha", x,y);

        ObjectAnimator animator1=ObjectAnimator.ofFloat(oViews.get(1), "translationX",mHiddenViewMeasuredHeightBegin);

        ObjectAnimator animator2=ObjectAnimator.ofFloat(oViews.get(2), "translationY",mHiddenViewMeasuredHeightBegin);

        ObjectAnimator animator3=ObjectAnimator.ofFloat(oViews.get(3), "translationY",mHiddenViewMeasuredHeightBegin);

        ObjectAnimator animator4=ObjectAnimator.ofFloat(oViews.get(4), "translationY",mHiddenViewMeasuredHeightBegin);

        ObjectAnimator animator5=ObjectAnimator.ofFloat(oViews.get(5), "translationY",mHiddenViewMeasuredHeightBegin);

        ObjectAnimator animator6=ObjectAnimator.ofFloat(oViews.get(6), "translationX",mHiddenViewMeasuredHeightyClose);



        //设置动画，用于旋转效果
        ObjectAnimator animator7=ObjectAnimator.ofFloat(oViews.get(0), "rotation", anglex,120f,angley);

        ObjectAnimator animator8=ObjectAnimator.ofFloat(oViews.get(1), "rotationX", anglex,120f,angley);

        ObjectAnimator animator9=ObjectAnimator.ofFloat(oViews.get(2), "rotationY", anglex,120f,angley);

        ObjectAnimator animator10=ObjectAnimator.ofFloat(oViews.get(3), "rotationX", anglex,120f,angley);
        ObjectAnimator animator11=ObjectAnimator.ofFloat(oViews.get(4), "rotationX", anglex,120f,angley);
        ObjectAnimator animator12=ObjectAnimator.ofFloat(oViews.get(5), "rotationX", anglex,120f,angley);
        ObjectAnimator animator13=ObjectAnimator.ofFloat(oViews.get(6), "rotationX", anglex,120f,angley);

        AnimatorSet set = new AnimatorSet();
        set.setDuration(500);
        set.setInterpolator(new OvershootInterpolator());
        set.playTogether(animator0,animator1,animator2,animator3,animator4,animator5,animator6,animator7,animator8,animator9,
                         animator10,animator11,animator12,animator13);
        set.start();


    }
    onMenuClickListener listener;
    //定义回调接口
    public interface onMenuClickListener {
        void hot();
        void discount();
        void new_foods();
        void  delicious();
        void  snack();
        void  drink();
    }
    //设置事件回调
    public void setonMenuClickListener( onMenuClickListener listener){
        this.listener=listener;
    }
}

