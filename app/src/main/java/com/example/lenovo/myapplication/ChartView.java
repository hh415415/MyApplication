package com.example.lenovo.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by lenovo on 2017/9/11.
 */

public class ChartView extends View {

    private int[] data_screen;
    private int[] data_power;
    private int[] data_total;
    private int flag;
    private int margin;
    private Chart chart;
    private Paint paint;

    public ChartView(Context context, int flag) {
        super(context);
        this.flag = flag;
        margin = 0;
        chart = new Chart();
        data_screen =new int[]{90,65,80,115};
        data_power=new int[]{150,125,100,130};
        data_total=new int[4];
        for (int i = 0; i <4 ; i++) {
            data_total[i] =data_screen[i]+data_power[i];

        }
        paint = new Paint();
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        drawAxis(canvas);
        drawChat(canvas);

    }

    private void drawAxis(Canvas canvas) {

        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(2);
        canvas.drawLine(30,300,350,300,paint);
        canvas.drawLine(30,20,30,300,paint);
        int x=90;
        int y=250;
        for (int i = 0; i <4 ; i++) {
            canvas.drawText(i+1+"",x,320,paint);
                x+=60;
        }
        for (int i = 0; i <5 ; i++) {
            canvas.drawText(50*(i+1)+"",0,y,paint);
            y-=50;
        }
    }

    private void drawChat(Canvas canvas) {
            if(flag==1){
                paint.setColor(Color.BLUE);
                int temp_screen=30;
                for (int i = 0; i <4 ; i++) {
                    chart.setH(data_screen[i]);
                    chart.setX(temp_screen+20*2+margin);
                    chart.drawSelf(canvas,paint);
                    margin=20;
                    temp_screen=chart.getX();
                }
                margin=0;
                paint.setColor(Color.DKGRAY);
                int temp_power=50;
                for (int i = 0; i <4 ; i++) {
                    chart.setH(data_power[1]);
                    chart.setX(temp_power+20*2+margin);
                    chart.drawSelf(canvas,paint);
                    margin=20;
                    temp_power=chart.getX();
                }
            }else if(flag==2){
                    paint.setColor(Color.GREEN);
                int temp=40;
                for (int i = 0; i <4 ; i++) {
                    chart.setH(data_total[i]);
                    chart.setX(temp+20*2+margin);
                    chart.drawSelf(canvas,paint);
                    margin=20;
                    temp=chart.getX();

                }
            }
    }
}
