package com.forward.world.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.forward.world.R;
import com.forward.world.base.BasePager;
import com.forward.world.pager.AudioPager;
import com.forward.world.pager.NetAudioPager;
import com.forward.world.pager.NetVideoPager;
import com.forward.world.pager.VideoPager;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {
    private FrameLayout fl_main_content;
    private RadioGroup rg_bottom_tag;

    private ArrayList<BasePager> basePagers;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fl_main_content = (FrameLayout) findViewById(R.id.fl_main_content);
        rg_bottom_tag = (RadioGroup) findViewById(R.id.rg_bottom_tag);

        basePagers = new ArrayList<>();
        basePagers.add(new VideoPager(this));//添加本地视频页面0
        basePagers.add(new AudioPager(this));//添加本地音频页面1
        basePagers.add(new NetVideoPager(this));//添加网络视频页面2
        basePagers.add(new NetAudioPager(this));//添加网络音频页面3

        //设置RadioGroup的监听
        rg_bottom_tag.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        /*设置默认选择首页*/
        rg_bottom_tag.check(R.id.rd_video);
    }
    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                default:
                    position = 0;
                    break;
                case R.id.rd_audio:
                    position = 1;
                    break;
                case R.id.rd_net_video:
                    position = 2;
                    break;
                case R.id.rd_net_audio:
                    position = 3;
                    break;
            }
            setFragment();
        }
    }

    /**
     * 把页面添加到Fragment中
     */
    private void setFragment() {
        //1、得到FragmentManager
        FragmentManager manager =  getSupportFragmentManager();
        //2、开始事务
        FragmentTransaction ft =  manager.beginTransaction();
        //3、替换
        ft.replace(R.id.fl_main_content,new ReplaceFragment(getBasePager()));
        //4、提交事务
        ft.commit();
        //Fragment null must be a public static class to be  properly recreated from instance state.
        /*new Fragment(){
            @Nullable
            @Override
            public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
                BasePager basePagers = getBasePager();
                if(basePagers != null){
                    //各个页面的视图,动态地执行各个文本内容
                    return basePagers.rootView;
                }
                return null;
                *//*return super.onCreateView(inflater, container, savedInstanceState);*//*
            }
        }*/
    }

    /**
     * 根据位置得到对应的页面
     * @return
     */
    private BasePager getBasePager() {
        BasePager basePager = basePagers.get(position);
        if(basePager != null){
            basePager.initData();//联网请求或者绑定数据
        }
        return basePager;
    }
}
