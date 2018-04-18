package com.example.emery.chartview;

import android.os.Bundle;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView pivotLeft = findViewById(R.id.pivot_left);

        pivotLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = "销售总额=会员消费+支付宝账户+微信账户+其他收入";
                String b = "会员消费大于3天";
                LiftHintWindow hintWindow = new LiftHintWindow(MainActivity.this,b);
                hintWindow.setContentText(b);
                View contentView = hintWindow.getContentView();
                //需要先测量，PopupWindow还未弹出时，宽高为0
                contentView.measure(hintWindow.makeDropDownMeasureSpec(hintWindow.getWidth()),
                        hintWindow.makeDropDownMeasureSpec(hintWindow.getHeight()));

                int offsetX = -3*contentView.getMeasuredWidth()/40;
                int offsetY = 0;
                PopupWindowCompat.showAsDropDown(hintWindow, pivotLeft, offsetX, offsetY, Gravity.START);

            }
        });

        final TextView pivotRight = findViewById(R.id.pivot_right);
        pivotRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RightHintWindow hintWindow = new RightHintWindow(MainActivity.this);
                View contentView = hintWindow.getContentView();
                //需要先测量，PopupWindow还未弹出时，宽高为0
                contentView.measure(hintWindow.makeDropDownMeasureSpec(hintWindow.getWidth()),
                        hintWindow.makeDropDownMeasureSpec(hintWindow.getHeight()));

                int offsetX = -contentView.getMeasuredWidth() + 60;
                int offsetY = 0;
                PopupWindowCompat.showAsDropDown(hintWindow, pivotRight, offsetX, offsetY, Gravity.END);

            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        // TODO Auto-generated method stub
        super.onWindowFocusChanged(hasFocus);

        if(hasFocus){
            }
    }
}
