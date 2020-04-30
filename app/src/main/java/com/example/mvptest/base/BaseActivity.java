package com.example.mvptest.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import butterknife.ButterKnife;

/**
 * @author WangXiangDong
 * @deprecated 基类活动
 * @date  :2020/4/29
 */
public abstract class BaseActivity extends AppCompatActivity
{
    @Override
    protected void onCreate( Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initPresenter();
        initView();
        ButterKnife.bind(this);


    }

    /**
     * 抽象方法：实例化 presenter
     */
    protected abstract void  initPresenter();

    /**
     * 抽象方法：初始化控件
     */
    protected abstract void initView();
    /**
     * 抽象方法：得到布局id
     * @return id
     */
    protected abstract int getLayoutId();
    /**
     * 启动fragment
     * @param id id
     * @param fragment 碎片
     */
    protected void startFragment(int id, Fragment fragment){
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(id,fragment);
        fragmentTransaction.commit();
    }

}
