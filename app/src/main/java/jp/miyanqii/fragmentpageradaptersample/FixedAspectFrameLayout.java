package jp.miyanqii.fragmentpageradaptersample;


import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * 縦横比固定FrameLayout。
 * - 上位のLayoutによって動的に決定された幅(or高さ)に応じて縦横比が一定になるように高さ(or幅)を決定する。
 * - 縦横比はカスタム属性 aspectRate に float (幅÷高さ) で与る。
 * - 参考：http://stackoverflow.com/a/13846628/804479
 *
 * @author kotemaru.org
 */
public class FixedAspectFrameLayout extends FrameLayout {
    private float mAspectRate;

    public FixedAspectFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.fw_FixedAspectFrameLayout);
        this.mAspectRate = a.getFloat(R.styleable.fw_FixedAspectFrameLayout_aspectRate, 1.0F);
        a.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        if (widthMode == MeasureSpec.EXACTLY && heightMode != MeasureSpec.EXACTLY) {
            int h = (int) (MeasureSpec.getSize(widthMeasureSpec) / mAspectRate);
            super.onMeasure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(h, MeasureSpec.EXACTLY));
        } else if (widthMode != MeasureSpec.EXACTLY && heightMode == MeasureSpec.EXACTLY) {
            int w = (int) (MeasureSpec.getSize(heightMeasureSpec) * mAspectRate);
            super.onMeasure(MeasureSpec.makeMeasureSpec(w, MeasureSpec.EXACTLY), heightMeasureSpec);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}