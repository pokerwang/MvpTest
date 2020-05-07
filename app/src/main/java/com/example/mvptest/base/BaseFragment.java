package com.example.mvptest.base;

import android.content.Context;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.lang.annotation.Target;
import java.util.logging.Logger;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author WangXiangDong
 * @date :2020/4/29
 */
public abstract class BaseFragment<P extends BasePresenter >extends Fragment implements BaseView
{
    private P presenter;
    private Context context;
    private Bundle bundle;
    private Unbinder unbinder;
    private View view;

    /**
     * 恢复数据
     */
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState)
    {
        super.onSaveInstanceState(outState);
        if(bundle!=null){
            outState.putBundle("bundle",bundle);
        }
    }


    /**
     * 绑定activity
     */
    @Override
    public void onAttach(@NonNull Context context)
    {
        super.onAttach(context);
        this.context=context;
    }

    /**
     * 运行在onAttach之后 可以接收别人传递过来的参数 实例化对象
     * 可以解决返回的时候页面空白的bug
     * @param savedInstanceState
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (savedInstanceState!=null){
            bundle=savedInstanceState.getBundle("bundle");
        }else {
            bundle=getArguments()==null?new Bundle():getArguments();
        }
        //初始化presenter
        presenter=initPresenter();
    }
    /**
     * 获取presenter
     */
    protected  P getPresenter(){
        return presenter;
    }
    /**
     * 运行在onCreate之后，生成VIEW视图
     *  @param inflater
     *  @param container
     *  @param savedInstanceState
     *  @return view
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        view=initView(inflater,container,savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        return view;

    }
    /**
     * 运行在onCreateView之后
     * 加载数据
     *
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        presenter.attachView(this);
    }
    /**
     * 跳转Fragment
     */
    public void startFragment(Fragment toFragment){
        Log.d("baseFragment", "startFragment: ");
        startFragment(toFragment,null);

    }
    /**
     * 跳转fragment
     * @param tag fragment的标签
     *
     */
    public void startFragment(Fragment toFragment,String tag){
        FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
        fragmentTransaction.hide(this).add(android.R.id.content,toFragment,tag);
        fragmentTransaction.addToBackStack(tag);
        fragmentTransaction.commitNowAllowingStateLoss();
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        unbinder.unbind();
    }
    /**
     * fragment进行回退
     * 类似activity的OnBackPress
     */
    public void onBack(){
        getFragmentManager().popBackStack();
    }

    @Override
    public void onDetach()
    {
        presenter.detachView();
        super.onDetach();
    }

    /**
     * 初始化Fragment视图
     * @param layoutInflater
     * @param container
     * @param saveInstanceState
     * @return view
     */
    public  abstract View initView(LayoutInflater layoutInflater,@Nullable ViewGroup container,
                                   @Nullable Bundle
                                   saveInstanceState);

    /**
     * 创建presenter
     */
    public abstract P initPresenter();

    /**
     * 得到context
     * @return context
     */
    @Nullable
    @Override
    public Context getContext()
    {
        return context;
    }
    /**
     * 得到bundle
     */
    public Bundle getBundle(){
        return bundle;
    }
    /**
     * 得到fragment
     */
    public Fragment getFragment(){
        return this;
    }
}
