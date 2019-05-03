package com.dingyong.opengles_android.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.dingyong.opengles_android.R;
import com.dingyong.opengles_android.activity.draw.CircularActivity;
import com.dingyong.opengles_android.activity.draw.CubeActivity;
import com.dingyong.opengles_android.activity.draw.SquareActivity;
import com.dingyong.opengles_android.activity.draw.TriangleActivity;
import com.dingyong.opengles_android.activity.draw.TriangleWithCameraActivity;

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
    public void onDrawTriangleWithCamera(View view) {
        Intent intent = new Intent(this, TriangleWithCameraActivity.class);
        startActivity(intent);
    }
    public void onDrawSquare(View view){
        Intent intent = new Intent(this, SquareActivity.class);
        startActivity(intent);
    }
    public void onDrawCircular(View view){
        Intent intent = new Intent(this, CircularActivity.class);
        startActivity(intent);
    }
    public void onDrawCube(View view){
        Intent intent = new Intent(this, CubeActivity.class);
        startActivity(intent);
    }
}
