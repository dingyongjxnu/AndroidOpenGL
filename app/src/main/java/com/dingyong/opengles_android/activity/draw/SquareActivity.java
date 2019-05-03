package com.dingyong.opengles_android.activity.draw;

import android.opengl.GLSurfaceView;

import com.dingyong.opengles_android.activity.BaseActivity;
import com.dingyong.opengles_android.render.SquareRender;

public class SquareActivity extends BaseActivity {

    @Override
    public GLSurfaceView.Renderer getRender() {
        return new SquareRender();
    }
}
