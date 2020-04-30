package com.example.mvptest.base;

/**
 * @author WangXiangDong
 * @date :2020/4/29
 */
public abstract class BaseMvpActivity<V extends BaseView,P extends BasePresenter> extends BaseActivity
{
    private P presenter;
    /**
     * 初始化presenter
     */
    @Override
    protected void initPresenter()
    {
        presenter=createPresenter();
        if (presenter!=null){
            presenter.attachView((V)this);
        }

    }
    /**
     * 创建presenter
     *
     */
    protected abstract P createPresenter();
    /**
     * 得到presenter
     * @return presenter
     */
    protected  P getPresenter(){
        return presenter;
    }
    /**
     * 销毁
     */
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        if (presenter!=null){
            presenter.detachView();
        }
    }
}
