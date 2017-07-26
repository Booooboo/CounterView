package com.example.counterview;

import android.content.Context;

import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * Created by sunhongbo on 17/7/26.
 */

public class CounterView extends View implements OnClickListener {

    private Paint mPaint;
    private Rect mBounds;
    private int mText;
    private float mSize;
    private int mMin;

    public CounterView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(); // 不要在onDraw中实例化对象
        mBounds = new Rect();
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CounterView);
        mText = a.getInteger(R.styleable.CounterView_text, 1);
        mSize = a.getDimensionPixelSize(R.styleable.CounterView_size, 20);
        setOnClickListener(this);
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.RED);
        //canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
        mMin = Math.min(getWidth()/2, getHeight()/2);
        canvas.drawCircle(mMin, mMin, mMin, mPaint);
        mPaint.setColor(Color.BLUE);
        mPaint.setTextSize(mSize);
        String text = String.valueOf(mText);
        mPaint.getTextBounds(text, 0, text.length(), mBounds);
        float textWidth = mBounds.width();
        float textHeight = mBounds.height();
        canvas.drawText(text, getWidth() / 2 - textWidth / 2, getHeight() / 2
                + textHeight / 2, mPaint);
    }

    @Override
    public void onClick(final View view) {
        mText++;
        invalidate();
    }
}
