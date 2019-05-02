package com.dingyong.opengles_android.activity.draw;

import android.opengl.GLSurfaceView;

import com.dingyong.opengles_android.activity.BaseActivity;
import com.dingyong.opengles_android.render.TriangleRenderer;

public class TriangleActivity extends BaseActivity {


    @Override
    public GLSurfaceView.Renderer getRender() {
        return new TriangleRenderer();
    }
}
