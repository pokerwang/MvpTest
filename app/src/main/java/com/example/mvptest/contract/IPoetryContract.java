package com.example.mvptest.contract;

import com.example.mvptest.base.BaseView;
import com.example.mvptest.entity.PoetryEntity;

import io.reactivex.Observable;

/**
 * @author WangXiangDong
 * @deprecated 诗歌接口管理器
 * @date :2020/4/29
 */
public interface IPoetryContract
{
    interface IPoetryModel{
        /**
         * 得到诗歌
         */
        Observable<PoetryEntity> getPoetry();
        }
    interface IPoetryPresenter
    {
        void getPoetry();
    }
    interface IPoetryView extends BaseView{
        /**
         *
         */
        void searchSuccess(String author);

    }



}
