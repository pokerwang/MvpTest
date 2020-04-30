package com.example.mvptest.model;

import com.example.mvptest.contract.IPoetryContract;
import com.example.mvptest.entity.PoetryEntity;
import com.example.mvptest.iApiService.GetPoetryEntity;
import com.example.mvptest.util.RetrofitManager;

import io.reactivex.Observable;

/**
 * @author WangXiangDong
 * @date :2020/4/29
 */
public class PoetryModel implements IPoetryContract.IPoetryModel
{
    private PoetryModel()
    {

    }
    public static PoetryModel getInstance(){
        return Inner.instance;
    }

    public static class Inner{
        private  static final PoetryModel instance=new PoetryModel();
    }

    /**
     * 获取古诗词
     * @return
     */
    @Override
    public Observable<PoetryEntity> getPoetry()
    {
        return RetrofitManager.getInstance().createRs(GetPoetryEntity.class).getPoetry();
    }


}