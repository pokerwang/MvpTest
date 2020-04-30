package com.example.mvptest.util;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author WangXiangDong
 * @deprecated
 * @date :2020/4/29
 */
public class RxJavaUtil
{
    /**
     * 线程调度
     * @param observable 被观察者
     */
    public static <T> Observable toSubscribe(Observable<T> observable){
        return  observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
