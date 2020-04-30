package com.example.mvptest.iApiService;

import com.example.mvptest.entity.PoetryEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @author WangXiangDong
 * @date :2020/4/29
 */
public interface GetPoetryEntity
{
    /**
     * 获取古诗词
     */
    @GET("all.json")
    Observable<PoetryEntity> getPoetry();
}
