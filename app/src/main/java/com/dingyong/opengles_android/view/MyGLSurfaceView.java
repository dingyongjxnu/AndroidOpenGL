package com.dingyong.opengles_android.view;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

import com.dingyong.opengles_android.render.TriangleRenderer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by：dingyong on 2019/3/30 22:19
 * email：dingyongjxnu@163.com
 */
public class MyGLSurfaceView extends GLSurfaceView implements GLSurfaceView.Renderer {
    private final static int VERSION = 2;
    private Renderer mRenderer;


    public void setMyRenderer(Renderer renderer) {
        mRenderer = renderer;
    }

    public MyGLSurfaceView(Context context) {
        super(context);

    }

    public MyGLSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public void init() {
        if (mRenderer == null){
            mRenderer = new TriangleRenderer();
        }
        //设置版本
        setEGLContextClientVersion(VERSION);
        //设置渲染器
        setRenderer(this);
        //设置render模式为只在绘制数据发生改变时才绘制view
        //此设置会阻止绘制GLSurfaceView的帧，直到你调用了requestRender()，这样会非常高效。
        setRenderMode(RENDERMODE_CONTINUOUSLY);

    }

    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
        mRenderer.onSurfaceCreated(gl10, eglConfig);
    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int width, int height) {
        mRenderer.onSurfaceChanged(gl10, width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl10) {
        mRenderer.onDrawFrame(gl10);
    }
}
