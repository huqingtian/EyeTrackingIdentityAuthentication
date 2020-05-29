package com.hqt.eyetrackingidentityauthentication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class HumanCheckView extends View {
    public float X;
    public float Y;
    Bitmap bitmap;
    public HumanCheckView(Context context, Bitmap bitmap) {
        super(context);
        this.bitmap = bitmap;
        X = 543;
        Y = 1513;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        canvas.drawBitmap(bitmap, X, Y, paint);
        if(bitmap.isRecycled()){
            bitmap.recycle();
        }
    }

}
