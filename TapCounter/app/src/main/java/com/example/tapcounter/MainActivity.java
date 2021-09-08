package com.example.tapcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Counter count;
    private TextView countView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count = new Counter();
        countView = (TextView)findViewById(R.id.TapCounter);
    }
    public void CountTap(View view){
        count.addCount();
        countView.setText(count.getCount().toString());
    }
}