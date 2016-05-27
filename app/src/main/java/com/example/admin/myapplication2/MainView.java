package com.example.admin.myapplication2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MainView extends View{

    private float position;

    private int centerX = 0;
    private int centerY = 0;

//    @Override
//    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
//        return super.dispatchNestedFling(velocityX, velocityY, consumed);
//    }


    public MainView(Context context,float posival){
        super(context);
        position = posival;
    }

    public MainView(Context context, AttributeSet attrs) {
        super(context,attrs);
    }

    public MainView(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);
    }

    protected void onDraw(Canvas canvas) {
        float x0 = centerX;
        float y0 = centerY;

        canvas.drawColor(Color.argb(255, 255, 255, 255));

        Paint paint = new Paint();
        paint.setColor(Color.argb(255, 155, 155, 155));
        paint.setAntiAlias(true);
        canvas.drawCircle(x0, y0, 500, paint);
        paint.setTextSize(80);
        paint.setColor(Color.argb(255, 255, 0, 0));

        Double pai = 3.14159263589;

        //北
        double rad = (90 - position) / 180 * pai;
        float needlesize = 500;
        float x1 = (float) Math.cos(rad) * needlesize;
        float y1 = (float) Math.sin(rad) * needlesize;

        canvas.drawLine(x0, y0, x0 - x1, y0 - y1, paint);
        canvas.drawText("N", x0 -x1, y0 - y1, paint);

        //南
        paint.setColor(Color.argb(255, 255, 255, 255));
        canvas.drawLine(x0, y0, x0+x1, y0+y1, paint);
        paint.setColor(Color.argb(255, 0, 0, 0));
        canvas.drawText("S", x0+x1, y0+y1+70, paint);

        //東
        rad = (position) / 180 * pai;//東
        x1 =(float) Math.cos(rad) * needlesize ;
        y1 =(float)Math.sin(rad) * needlesize ;
        paint.setColor(Color.argb(255, 255, 255, 255));
        canvas.drawLine(x0, y0, x0+x1, y0-y1, paint);
        paint.setColor(Color.argb(255, 0, 0, 0));
        canvas.drawText("E", x0+x1, y0-y1, paint);


        //西
        paint.setColor(Color.argb(255, 255, 255, 255));
        canvas.drawLine(x0, y0, x0-x1, y0+y1, paint);
        paint.setColor(Color.argb(255, 0, 0, 0));
        canvas.drawText("W", x0-x1-80, y0+y1, paint);

        //現時点値描画
        String str=String.valueOf(position);
        canvas.drawText(str, centerX-10, centerY-133, paint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        // 画面の幅の中央のxy座標取得。
        centerX = w / 2;
        centerY = h / 2;

    }
}


