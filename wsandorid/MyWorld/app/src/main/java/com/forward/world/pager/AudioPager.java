package com.forward.world.pager;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.forward.world.base.BasePager;

/**
 * Created by liaoshanggang on 7/1/2017.
 * 本地音乐的页面
 */

public class AudioPager extends BasePager{
    private TextView textView;
    public AudioPager(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        Log.e("View","本地音乐页面初始化了");
        textView = new TextView(context);
        textView.setTextSize(25);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        return textView;
    }

    @Override
    public void initData() {
        super.initData();
        Log.e("View","本地音乐页面数据被初始化了");
        textView.setText("本地音乐页面");
    }
}
