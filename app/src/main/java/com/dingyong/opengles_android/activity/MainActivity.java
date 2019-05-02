package com.dingyong.opengles_android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.dingyong.opengles_android.R;
import com.dingyong.opengles_android.activity.draw.TriangleActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onDrawTriangle(View view) {
        Intent intent = new Intent(this, TriangleActivity.class);
        startActivity(intent);
    }


}
