package com.yds.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

/**
 * Created by yds
 * on 2020/3/10.
 */
public class CircleImageViewPD extends AppCompatImageView {

    private int mWidth;
    private int mHeight;
    private Paint mPaint;
    private Bitmap CircleBitmap;

    public CircleImageViewPD(Context context) {
        super(context);
    }

    public CircleImageViewPD(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleImageViewPD(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void ImgCircle(){
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setColor(Color.GRAY);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.FILL);
        CircleBitmap = Bitmap.createBitmap(mWidth,mHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(CircleBitmap);
        canvas.drawCircle(mWidth/2,mHeight/2,mWidth/2,paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setFilterBitmap(true);
        ImgCircle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int count = canvas.saveLayerAlpha(0, 0, mWidth, mHeight, 250, Canvas.ALL_SAVE_FLAG);
        super.onDraw(canvas);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas.drawBitmap(CircleBitmap,0,0, mPaint);
        canvas.restoreToCount(count);
    }
}
