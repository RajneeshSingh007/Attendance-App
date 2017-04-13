package com.attendance.misc.widgets;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Coolalien on 3/3/2017.
 */

public class VerticalTextView extends TextView {

    public VerticalTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public VerticalTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VerticalTextView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        final ColorStateList csl = getTextColors();
        final int color = csl.getDefaultColor();
        final int paddingBottom = getPaddingBottom();
        final int paddingTop = getPaddingTop();
        final int viewWidth = getWidth();
        final int viewHeight = getHeight();
        final TextPaint paint = getPaint();
        paint.setColor(color);
        paint.setTextAlign(Paint.Align.CENTER);
        final float bottom = viewWidth * 13.0f / 20.0f;
        Path p = new Path();
        p.moveTo(bottom, viewHeight - paddingBottom - paddingTop);
        p.lineTo(bottom, paddingTop);
        canvas.drawTextOnPath(getText().toString(),p , 0, 0, paint);
    }
}