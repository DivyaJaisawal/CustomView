package com.leftshift.barchart;



import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;


public class BarChart extends View {
    Paint textPaint;
    Paint linePaint;
    Paint boxPaint1;
    Paint textPaint1;
    double percentage;

    float scaleFactor;

    public BarChart(Context context) {
        super(context);
        initialise();
    }


    public BarChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialise();
    }

    public BarChart(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initialise();
    }

    void initialise() {

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        scaleFactor = metrics.density;

        textPaint = new Paint();
        linePaint = new Paint();
        boxPaint1 = new Paint();
        textPaint1 = new Paint();
        linePaint.setStrokeWidth(1);
        //grey
        linePaint.setColor(0xFFC5C5C5);
        textPaint.setColor(0xFFC5C5C5);
        textPaint.setTextSize(14 * scaleFactor);
        // yellow
        boxPaint1.setColor(0xFFFFBB33);
        textPaint1.setColor(0xFFFFBB33);
        textPaint1.setTextSize(14 * scaleFactor);
        //values
        setPercentage(50);


    }


    public void setPercentage(double value) {
        percentage = value;
        invalidate();
    }


    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int fullWidth = getWidth();
        int fullHeight = getHeight();
       // int padding = (int) (10 * scaleFactor);
        int padding = 0;
        int maxBarHeight = fullHeight - 5 * padding;
        float bar1height;
        bar1height = (float) (percentage * maxBarHeight) / 100;
       // canvas.drawLine(padding, fullHeight - 25 * scaleFactor, fullWidth - padding,
           //     fullHeight - 25 * scaleFactor, linePaint);
        float middle = (float) (fullWidth * 0.5);
        float quarter = (float) (fullWidth * 0.25);
        int bar1bottom = fullHeight - padding * 3;
        float bar1top = bar1bottom - bar1height;
        float val1pos = bar1top - padding;
        canvas.drawRect(padding * 2, bar1top, middle - padding, bar1bottom, boxPaint1);
       // canvas.drawText("Percent", quarter - padding, fullHeight - padding, textPaint1);
       // canvas.drawText(percentage + "%", quarter - padding, val1pos, textPaint);


    }

}