package com.dingyong.opengles_android.utils;

import android.opengl.GLES20;

/**
 * Created by：dingyong on 2019/3/31 13:54
 * email：dingyongjxnu@163.com
 */
public class ShaderUtils {

    public static int loadShader(int type, String source) {
        int shader = 0;
        shader = GLES20.glCreateShader(type);
        GLES20.glShaderSource(shader, source);
        GLES20.glCompileShader(shader);
        return shader;
    }
}
