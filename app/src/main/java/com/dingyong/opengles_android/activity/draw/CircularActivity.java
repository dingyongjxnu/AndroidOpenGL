package com.dingyong.opengles_android.activity.draw;

import android.opengl.GLSurfaceView;

import com.dingyong.opengles_android.activity.BaseActivity;
import com.dingyong.opengles_android.render.CircularRender;

/**
 * Created by：dingyong on 2019/5/3 17:06
 * email：dingyongjxnu@163.com
 */
public class CircularActivity extends BaseActivity {
    @Override
    public GLSurfaceView.Renderer getRender() {
        return new CircularRender();
    }
}
