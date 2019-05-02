package com.dingyong.opengles_android.activity;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dingyong.opengles_android.view.MyGLSurfaceView;

/**
 * Created by：dingyong on 2019/3/31 10:44
 * email：dingyongjxnu@163.com
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyGLSurfaceView surfaceView = new MyGLSurfaceView(this);
        surfaceView.setMyRenderer(getRender());
        surfaceView.init();
        setContentView(surfaceView);
    
}

    public abstract GLSurfaceView.Renderer getRender();
}
