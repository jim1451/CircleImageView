package com.example.administrator.circleimageview;


import android.content.Context;
import android.graphics.*;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class circleImageView extends View {
    private Paint mPaint;
    private Bitmap imageBitmap;
    private float circleRadio;

    public circleImageView(Context context) {
        super(context);
        mPaint = new Paint();

    }

    public circleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        imageBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.kk);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(getCircle(imageBitmap), 0, 0, mPaint);
    }

    //将bitmap转换成圆形bitmap
    public Bitmap getCircle(Bitmap bitmap) {


        //circleRadio圆形图片的半径
        float circleRadio = bitmap.getWidth() / 2;
        //创建一张新的bitmap，跟传入图片一样宽的正方形bitmap，
        Bitmap b = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getWidth(), Bitmap.Config.ARGB_8888);
        //初始化画布，并将刚才创建的bitmap给这画布，让画布画在这bitmap上面
        Canvas canvas = new Canvas(b);
        //初始化画笔
        Paint p = new Paint();
        //在画布中画一个等宽的圆
        canvas.drawCircle(circleRadio, circleRadio, circleRadio, p);
        //设置画笔属性，让画笔只在哪圆圈中画画，关于画笔属性，可以百度一下，很多，但是非常有用
        p.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

      /*float  scale = Math.max(getWidth() * 1.0f / dWidth, getHeight()
                * 1.0f / dHeight);
*/

        canvas.drawBitmap(bitmap, 0, 0, p);
        return b;
    }

}
