package com.example.mvptest.util;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.mvptest.contants.StaticQuality.BASE_URL;

/**
 * @author WangXiangDong
 * @deprecated retrofit 单例工具类
 * @date :2020/4/29
 */
public class RetrofitManager
{
    private Retrofit retrofit;
    //构造器私有，这个工具类只有一个实例
    private RetrofitManager(){
        OkHttpClient.Builder httpClientBuilder =new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(15, TimeUnit.SECONDS);
        retrofit=new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();
    }
    /**
     * 静态内部类单例模式
     *
     */
    public static RetrofitManager getInstance(){
        return Inner.retrofitManager;
    }
    private static class Inner{
        private static final RetrofitManager retrofitManager=new RetrofitManager();
    }
    /**
     * 利用泛型传入接口class返回接口实例
     *
     */
    public <T> T createRs(Class<T> ser){
        return retrofit.create(ser);
    }
}
