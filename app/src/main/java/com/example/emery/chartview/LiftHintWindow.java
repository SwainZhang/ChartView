package com.example.emery.chartview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

/**
 * Created by emery on 2018/4/18.
 */

public class LiftHintWindow extends PopupWindow {

    private final TextView mContent;

    public LiftHintWindow(Context context,String text){
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);

        Paint paint = new Paint();
        paint.setTextSize(20);
        float width = paint.measureText(text,0,text.length());
        setWidth((int) Math.ceil(width));
        setOutsideTouchable(true);
        setFocusable(true);
        setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        View contentView = LayoutInflater.from(context).inflate(R.layout.left_item_tips,
                null, false);
        setContentView(contentView);

        mContent = contentView.findViewById(R.id.content);
    }

    public void setContentText(String contentText){
        mContent.setText(contentText);
    }

    @SuppressWarnings("ResourceType")
    public static int makeDropDownMeasureSpec(int measureSpec) {
        int mode;
        if (measureSpec == ViewGroup.LayoutParams.WRAP_CONTENT) {
            mode = View.MeasureSpec.UNSPECIFIED;
        } else {
            mode = View.MeasureSpec.EXACTLY;
        }
        return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(measureSpec), mode);
    }
}
