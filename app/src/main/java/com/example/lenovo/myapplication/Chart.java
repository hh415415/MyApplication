package com.example.lenovo.myapplication;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by lenovo on 2017/9/11.
 */

public class Chart {
    int w = 50;
    int h;
    int total_y = 300;
    int x;

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void drawSelf(Canvas canvas, Paint paint) {
        canvas.drawRect(x, total_y - h, w + x, total_y - 1, paint);
    }

}
