package com.example.mysample.carouselviewexample;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by Mickey on 12/14/2015.
 */
public class MyLinearLayout extends LinearLayout {
    private float scale = MainActivity.BIG_SCALE;

    public MyLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLinearLayout(Context context) {
        super(context);
    }

    public void setScaleBoth(float scale) {
        this.scale = scale;
        this.invalidate();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        // The main mechanism to display scale animation, you can customize it as your needs
        int w = this.getWidth();
        int h = this.getHeight();
        canvas.scale(scale, scale, w/2, h/2);

        super.onDraw(canvas);
    }

}

