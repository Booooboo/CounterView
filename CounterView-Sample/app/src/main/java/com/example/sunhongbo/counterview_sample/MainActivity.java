package com.example.sunhongbo.counterview_sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.counterview.CounterView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CounterView counterView = (CounterView) findViewById(R.id.counter_view);
    }
}
