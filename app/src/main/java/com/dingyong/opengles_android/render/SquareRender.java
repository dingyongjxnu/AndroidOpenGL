package com.dingyong.opengles_android.render;

import android.opengl.GLES20;
import android.opengl.Matrix;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by：dingyong on 2019/5/3 15:31
 * email：dingyongjxnu@163.com
 */
public class SquareRender extends BaseRender {

    private final String vertexShaderCode =
            "attribute vec4 vPosition;" +
                    "uniform mat4 vMatrix;"+
                    "void main() {" +
                    "  gl_Position = vMatrix*vPosition;" +
                    "}";

    private final String fragmentShaderCode =
            "precision mediump float;" +
                    "uniform vec4 vColor;" +
                    "void main() {" +
                    "  gl_FragColor = vColor;" +
                    "}";

    static float position[] = {
            -0.5f,  0.5f, 0.0f, // top left
            -0.5f, -0.5f, 0.0f, // bottom left
            0.5f, -0.5f, 0.0f, // bottom right
            0.5f,  0.5f, 0.0f  // top right
    };

    static short index[]={
            0,1,2,0,2,3
    };

    private ShortBuffer indexBuffer;
    private FloatBuffer mPositionBuffer;
    private int mProgram;
    //颜色值
    private final float[] colors = {1.0f, 1.0f, 1.0f, 1.0f};
    private float[] mViewMatrix = new float[16];
    private float[] mProjectMatrix = new float[16];
    private float[] mMVPMatrix = new float[16];

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {


        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(position.length * 4);
        byteBuffer.order(ByteOrder.nativeOrder());
        mPositionBuffer = byteBuffer.asFloatBuffer();
        mPositionBuffer.put(position);
        mPositionBuffer.position(0);


         ByteBuffer byteBufferIndex = ByteBuffer.allocateDirect(index.length * 2);
        byteBufferIndex.order(ByteOrder.nativeOrder());
        indexBuffer = byteBufferIndex.asShortBuffer();
        indexBuffer.put(index);
        indexBuffer.position(0);


        int vertexShade = loadShader(GLES20.GL_VERTEX_SHADER, vertexShaderCode);
        int fragmentShade = loadShader(GLES20.GL_FRAGMENT_SHADER, fragmentShaderCode);
        mProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(mProgram, vertexShade);
        GLES20.glAttachShader(mProgram, fragmentShade);

        GLES20.glLinkProgram(mProgram);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        //计算宽高比
        float ratio=(float)width/height;
        //设置透视投影
        Matrix.frustumM(mProjectMatrix, 0, -ratio, ratio, -1, 1, 3, 7);
        //设置相机位置
        Matrix.setLookAtM(mViewMatrix, 0, 0, 0, 7.0f, 0f, 0f, 0f, 0f, 1.0f, 0.0f);
        //计算变换矩阵
        Matrix.multiplyMM(mMVPMatrix,0,mProjectMatrix,0,mViewMatrix,0);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        //清空缓冲区，与  GLES20.glClearColor(0.5f,0.5f,0.5f,1.0f);对应
      //  GLES20.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        //将程序加入到OpenGLES2.0环境
        //将程序加入到OpenGLES2.0环境
        GLES20.glUseProgram(mProgram);
        //获取变换矩阵vMatrix成员句柄
        int mMatrixHandler = GLES20.glGetUniformLocation(mProgram, "vMatrix");
        //指定vMatrix的值
        GLES20.glUniformMatrix4fv(mMatrixHandler,1,false,mMVPMatrix,0);
        //获取顶点着色器的vPosition成员句柄
        int mPositionHandle = GLES20.glGetAttribLocation(mProgram, "vPosition");
        //启用三角形顶点的句柄
        GLES20.glEnableVertexAttribArray(mPositionHandle);
        //准备三角形的坐标数据
        GLES20.glVertexAttribPointer(mPositionHandle, 3,
                GLES20.GL_FLOAT, false,
                12, mPositionBuffer);
        //获取片元着色器的vColor成员的句柄
        int mColorHandle = GLES20.glGetUniformLocation(mProgram, "vColor");
        //设置绘制三角形的颜色
        GLES20.glUniform4fv(mColorHandle, 1, colors, 0);
        //绘制三角形
//        GLES20.glDrawArrays(GLES20.GL_TRIANGLE_STRIP, 0, vertexCount);
        //索引法绘制正方形
        GLES20.glDrawElements(GLES20.GL_TRIANGLES,index.length, GLES20.GL_UNSIGNED_SHORT,indexBuffer);
        //禁止顶点数组的句柄
        GLES20.glDisableVertexAttribArray(mPositionHandle);
    }
}
