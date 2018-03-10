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
 * 网络视频的页面
 */

public class NetVideoPager extends BasePager{
    private TextView textView;
    public NetVideoPager(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        Log.e("View","网络视频页面初始化了");
        textView = new TextView(context);
        textView.setTextSize(25);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        return textView;
    }

    @Override
    public void initData() {
        super.initData();
        Log.e("View","网络视频页面数据被初始化了");
        textView.setText("网络视频页面");
    }
}
