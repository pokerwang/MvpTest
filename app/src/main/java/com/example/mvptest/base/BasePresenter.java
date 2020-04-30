package com.example.mvptest.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author WangXiangDong
 * @date :2020/4/29
 */
public abstract class BasePresenter <V extends BaseView>
{   //将所有正在处理的Subscription都添加到 CompositeDisposable中，统一退出时注销观察
    private CompositeDisposable compositeDisposable;
    private V baseView;

    /**
     * 和view视图绑定
     * @param baseView
     */
    public void attachView(V baseView){
        this.baseView=baseView;
    }

    /**
     * 解绑view
     */
    public void detachView(){
        baseView=null;
        //在界面退出等需要解绑观察者的情况下调用此方法统一解绑
        //防止rx造成内存泄漏
        if (compositeDisposable!=null){
            compositeDisposable.dispose();
        }
    }

    /**
     * 获取view
     * @return view
     */
    public V getMvpView(){
        return baseView;
    }
    /**
     * 将disposable添加，在每次网络访问之前初始化进行添加操作
     *
     */
    public void addDisposable(Disposable subscription){
        //compositeDisposable如果解绑了的话subscription需要新的实例否者绑定无效
        if (compositeDisposable==null||compositeDisposable.isDisposed()){
            compositeDisposable=new CompositeDisposable();
        }
        compositeDisposable.add(subscription);
    }

}
