package ro.rocknrolla.android.smartcar.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class ResizableImageView extends ImageView {
    public ResizableImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ResizableImageView(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Drawable d = getDrawable();
        if (d == null) {
            super.setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
            return;
        }

        int imageHeight = d.getIntrinsicHeight();
        int imageWidth = d.getIntrinsicWidth();

        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int imageRatio = 0;
        if (imageHeight > 0) {
            imageRatio = (int) Math.floor(imageWidth / imageHeight);
        }
        int sizeRatio = 0;
        if (heightSize > 0) {
            sizeRatio = (int) Math.floor(widthSize / heightSize);
        }

        int width;
        int height;
        if (imageRatio >= sizeRatio) {
            // set width to maximum allowed
            width = widthSize + 1;
            // scale height
            height = (int) Math.floor(width * imageHeight / imageWidth);
        } else {
            // set height to maximum allowed
            height = heightSize;
            // scale width
            width = (int) Math.floor(height * imageWidth / imageHeight);
        }

        setMeasuredDimension(width, height);
    }
}