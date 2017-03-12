package com.example.ruedy.barrageviewtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by ruedy on 2017/3/12.
 */

public class BarrageView extends View implements Runnable {

    private List<Textitem> items = new ArrayList<Textitem>();//弹幕集合
    Random random = new Random();//随机数,用于取得x,y坐标,颜色值，以及移动速度
    private Paint paint;//画笔


    public BarrageView(Context context) {
        this(context, null);
    }

    public BarrageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BarrageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initpaint();
        new Thread(this).start();//开启死循环线程让弹幕动起来


    }

    /**
     * @param "文本内容"
     */
    public void addTextitem(String content) {//此方法可根据需求自行改动
        float x = random.nextFloat() * getWidth() - 30;//随机x
        float y = Math.abs(random.nextFloat() * (getHeight() - 50)) + 40;//稍微处理了一下y坐标，让字幕不紧贴边缘
        float step = random.nextFloat() * 50;
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
        Textitem textitem = new Textitem(content, x, y, step, Color.rgb(r, g, b));
        items.add(textitem);

    }

    private void initpaint() {
        paint = new TextPaint(Paint.ANTI_ALIAS_FLAG);//初始化文本画笔
        paint.setColor(Color.RED);//文字颜色值,可以不设定
        paint.setTextSize(30);//文字大小
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //把文字画出来
        for (Textitem item : items) {

            paint.setColor(item.getTextcolor());
            canvas.drawText(item.getContent(), item.getFx(), item.getFy(), paint);

        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(600);
                for (Textitem item : items) {

                    item.setPerstep();
                }
                postInvalidate();//每隔500毫秒重绘视图
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 弹幕类
     */
    class Textitem {
        private String content;//文本内容
        private float fx;//x坐标
        private float fy;//y坐标
        private float perstep;//移动速度
        private int textcolor;//字体颜色

        public Textitem(String content, float fx, float fy, float perstep, int textcolor) {
            this.content = content;
            this.fx = fx;
            this.fy = fy;
            this.perstep = perstep;
            this.textcolor = textcolor;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public float getFx() {
            return fx;
        }

        public void setFx(float fx) {
            this.fx = fx;
        }

        public int getTextcolor() {
            return textcolor;
        }

        public void setTextcolor(int textcolor) {
            this.textcolor = textcolor;
        }

        public float getFy() {
            return fy;
        }

        public void setFy(float fy) {
            this.fy = fy;
        }

        public float getPerstep() {
            return perstep;
        }

        public void setPerstep() {
            fx -= perstep;//调用此方法实现x坐标向左移动
        }
    }
}
