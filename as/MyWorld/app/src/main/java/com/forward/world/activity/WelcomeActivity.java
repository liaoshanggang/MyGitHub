package com.forward.world.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;

import com.forward.world.R;

public class WelcomeActivity extends AppCompatActivity{

    private static final String TAG = WelcomeActivity.class.getSimpleName();

    Handler handler = new Handler();
    private boolean isStartMain = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //两秒后执行到这里
                //执行在主线程中
                toMainActivity();
                Log.e("TAG","当前线程名称=="+Thread.currentThread().getName());
            }
        },2000);
    }
    
    /*
    * 跳转到主页面，并且把当前页面关闭掉
    * */
    private void toMainActivity() {
        /*(2)*/
        if(!isStartMain){
            isStartMain = true;
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            Log.d(TAG,"toMainActivity");
            //关闭当前页面
            finish();
        }
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG,"onTouchEvent==Action"+event.getAction());
        /*(1)因为多次触发产生很多，所以MainActivity需要单例*/
        toMainActivity();
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDestroy() {
        /*解决点击进去退出，singleTask有bug*/
        handler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }
}
