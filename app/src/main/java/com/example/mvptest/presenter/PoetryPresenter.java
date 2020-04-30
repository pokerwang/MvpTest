package com.example.mvptest.presenter;

import android.util.Log;

import com.example.mvptest.base.BasePresenter;
import com.example.mvptest.contract.IPoetryContract;
import com.example.mvptest.entity.PoetryEntity;
import com.example.mvptest.model.PoetryModel;
import com.example.mvptest.util.RxJavaUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * @author WangXiangDong
 * @date :2020/4/29
 */
public class PoetryPresenter extends BasePresenter<IPoetryContract.IPoetryView>implements
        IPoetryContract.IPoetryPresenter
{
    private static final String TAG="PoetryPresenter";
    private PoetryEntity mPoetryEntity;
    private PoetryModel poetryModel;
    private  PoetryPresenter(){
        poetryModel=PoetryModel.getInstance();
    }
    public static PoetryPresenter getInstance(){
        return Inner.instance;
    }
    private static class Inner{
        private static final PoetryPresenter instance=new PoetryPresenter();
    }

    /**
     * 得到诗歌
     */
    @Override
    public void getPoetry()
    {
        Observable observable=poetryModel.getPoetry().doOnSubscribe(new Consumer<Disposable>()
        {
            @Override
            public void accept(Disposable disposable) throws Exception
            {
                addDisposable(disposable);
            }
        });
        observable= RxJavaUtil.toSubscribe(observable);
        observable.subscribe(new Observer<PoetryEntity>()
        {
            @Override
            public void onSubscribe(Disposable d)
            {

            }

            @Override
            public void onNext(PoetryEntity poetryEntity)
            {
                mPoetryEntity=poetryEntity;
            }

            @Override
            public void onError(Throwable e)
            {
                getMvpView().onError(e.getMessage());
                Log.d(TAG, "onError: "+e.getMessage());


            }

            @Override
            public void onComplete()
            {
                if (mPoetryEntity!=null){
                    getMvpView().searchSuccess(mPoetryEntity.getAuthor());
                }

            }
        });

    }
}
