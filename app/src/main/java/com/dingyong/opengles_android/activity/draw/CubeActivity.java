package com.dingyong.opengles_android.activity.draw;

import android.opengl.GLSurfaceView;

import com.dingyong.opengles_android.activity.BaseActivity;
import com.dingyong.opengles_android.render.CubeRender;

/**
 * 绘制立方体
 * Created by：dingyong on 2019/5/3 17:48
 * email：dingyongjxnu@163.com
 */
public class CubeActivity extends BaseActivity {
    @Override
    public GLSurfaceView.Renderer getRender() {
        return new CubeRender();
    }
}
