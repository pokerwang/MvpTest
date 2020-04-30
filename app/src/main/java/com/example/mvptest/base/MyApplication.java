package com.example.mvptest.base;

import android.app.Application;
import android.content.Context;

/**
 * @author WangXiangDong
 * @date :2020/4/29
 */
public class MyApplication extends Application
{
    private static Context context;

    @Override
    public void onCreate()
    {
        super.onCreate();
        context=getApplicationContext();
    }
    //获取全局context
    public static Context getContext(){
        return context;
    }
}
