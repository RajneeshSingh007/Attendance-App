package com.attendance.misc.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static android.graphics.Paint.ANTI_ALIAS_FLAG;
import static com.attendance.misc.utils.Constants.DATE_FORMAT_NOW;

/**
 * Created by coolalien on 18,March,2017
 */

public class Helpers {

    /**
     * Date and time
     * @return
     */
    public static String now() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        return sdf.format(cal.getTime());
    }


    /**
     * Convert text to bitmap
     * @param text
     * @param textSize
     * @param textColor
     * @return
     */
    public static Bitmap textAsBitmap(String text, float textSize, int textColor) {
        Paint paint = new Paint(ANTI_ALIAS_FLAG);
        paint.setTextSize(textSize); //text size
        paint.setColor(textColor); //text color
        paint.setTextAlign(Paint.Align.LEFT); //align center
        float baseline = -paint.ascent(); // ascent() is negative
        int width = (int) (paint.measureText(text) + 0.0f); // round
        int height = (int) (baseline + paint.descent() + 0.0f);
        Bitmap image = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(image);
        canvas.drawText(text, 0, baseline, paint); //draw text
        return image;
    }
}
