package com.example.mvptest.base;

/**
 * @author WangXiangDong
 * @date :2020/4/29
 */
public interface BaseView
{
    /**
     * 显示进度框
     */
    void  showProgressDialog();
    /**
     * 关闭进度框
     */
    void closeProgressDialog();
    /**
     * 出错信息回调
     * @param result 错误信息
     */
    void onError(String result);
}
