package comqwera.mingrisoft.shousi.activity.View;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;

import android.support.v7.widget.AppCompatTextView;

public class Mytextview extends AppCompatTextView{
    private LinearGradient mLinearGradient;
    private Matrix mGradientMatrix;
    private Paint mPaint;
    private int mViewWidth = 0;
    private int mTranslate = 0;

    private boolean mAnimating = true;
    private int delta = 15;
    public Mytextview(Context ctx)
    {
        this(ctx,null);
    }

    public Mytextview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (mViewWidth == 0) {
            mViewWidth = getMeasuredWidth();
            if (mViewWidth > 0) {
                mPaint = getPaint();
                String text = getText().toString();
                // float textWidth = mPaint.measureText(text);
                int size;
                if(text.length()>0)
                {
                    size = mViewWidth*2/text.length();
                }else{
                    size = mViewWidth;
                }
                mLinearGradient = new LinearGradient(-size, 0, 0, 0,
                        new int[] { 0xFFDC143C, 0xFF90FF, 0xFF00FFFF },
                        new float[] { 0, 0.5f, 1 }, Shader.TileMode.CLAMP); //边缘融合
                mPaint.setShader(mLinearGradient);
                mGradientMatrix = new Matrix();
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int length = Math.max(length(), 1);
        if (mAnimating && mGradientMatrix != null) {
            float mTextWidth = getPaint().measureText(getText().toString());
            mTranslate += delta;
            if (mTranslate > mTextWidth+1 || mTranslate<1) {
                delta  = -delta;
            }
            mGradientMatrix.setTranslate(mTranslate, 0);
            mLinearGradient.setLocalMatrix(mGradientMatrix);
            postInvalidateDelayed(40);
        }
    }

}
