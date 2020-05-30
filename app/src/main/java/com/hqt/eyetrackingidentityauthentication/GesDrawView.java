package com.hqt.eyetrackingidentityauthentication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class GesDrawView extends View {
    float x1, x2, y1, y2;
    public GesDrawView(Context context, float x1, float y1, float x2, float y2) {
        super(context);
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStrokeWidth(10);
        paint.setColor(Color.BLUE);
        canvas.drawLine(x1, y1, x2, y2, paint);
    }
}
