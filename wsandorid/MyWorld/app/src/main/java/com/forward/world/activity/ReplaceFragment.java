package com.forward.world.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.forward.world.base.BasePager;

/**
 * Created by liaoshanggang on 7/1/2017.
 */

public class  ReplaceFragment extends Fragment {
    private BasePager currPager;

    public ReplaceFragment(BasePager pager) {
        this.currPager = pager;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(currPager != null){
            //各个页面的视图,动态地执行各个文本内容
            return currPager.rootView;
        }
        return null;
    }
}
