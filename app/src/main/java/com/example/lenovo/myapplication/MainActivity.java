package com.example.lenovo.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private static final int TOTALCHART = 2;
    private TextView tex_power;
    private ChartView chartView;
    private LinearLayout layout_chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        tex_power = (TextView) findViewById(R.id.tex_power);
        tex_power.setOnClickListener(this);
        layout_chart = (LinearLayout) findViewById(R.id.layout_chart);
        layout_chart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                int whitch = 0;
                whitch = TOTALCHART;
                tex_power.setVisibility(View.INVISIBLE);
                tex_power.setTextColor(Color.BLUE);

                chartView = new ChartView(this, whitch);
                layout_chart.removeAllViews();
                layout_chart.addView(chartView);
                break;
        }
    }
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK)
            System.exit(0);
        return true;
    }
}
