package com.dingyong.opengles_android.render;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

/**
 * Created by：dingyong on 2019/5/2 21:41
 * email：dingyongjxnu@163.com
 */
public abstract class BaseRender implements GLSurfaceView.Renderer {
    public int loadShader(int type, String shaderCode) {
        //根据type创建顶点着色器或者片元着色器
        int shader = GLES20.glCreateShader(type);
        //将资源加入到着色器中，并编译
        GLES20.glShaderSource(shader, shaderCode);
        GLES20.glCompileShader(shader);
        return shader;
    }
}
