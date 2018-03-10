package com.forward.world.base;

import android.content.Context;
import android.view.View;

/**
 * Created by liaoshanggang on 7/1/2017.
 */

public abstract class BasePager {
    /**
     * 上下文
     */
    public final Context context;

    /**
     * 接收各个页面的实例
     */
    public View rootView;
    public boolean isInitData;

    public BasePager(Context context){
        this.context = context;
        this.rootView = initView();
    }

    /**
     * 强制子页面实现该方法，实现想要的特定的效果
     */
    public abstract View initView();

    /**
     * 当子页面需要初始化数据，联网请求数据，或者绑定数据的时候要重写该方法
     */
    public void initData(){

    }
}
