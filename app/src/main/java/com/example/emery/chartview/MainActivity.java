package com.example.emery.chartview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ChartView  cvView=(ChartView)findViewById(R.id.cv_chartView);

        //定义三个数组，分别为x轴和Y轴的值，values为折线的点

        String[] txtx = new String[] { "04/08", "04/09", "04/10", "04/09", "04/10", "04/11", "04/12" };
        String[] txty = new String[] { "-20000", "0", "20000", "60000", "800000" };
        String[] values = new String[] { "6000", "50000", "5000", "2000", "40000", "500000", "50" };
        //String[] values = new String[] { "0", "0", "0", "0", "0", "0", "0" };
        cvView.setData(txtx, txty, values);
    }
}
