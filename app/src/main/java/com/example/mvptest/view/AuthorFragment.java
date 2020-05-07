package com.example.mvptest.view;

import android.os.Bundle;
import android.util.Log;
import android.view.CollapsibleActionView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.mvptest.R;
import com.example.mvptest.base.BaseFragment;
import com.example.mvptest.base.MyApplication;
import com.example.mvptest.contract.IPoetryContract;
import com.example.mvptest.presenter.PoetryPresenter;


import butterknife.BindView;
import butterknife.OnClick;

import static android.content.ContentValues.TAG;

/**
 * @author WangXiangDong
 * @date :2020/4/29
 */
public class AuthorFragment extends BaseFragment<PoetryPresenter> implements IPoetryContract
    .IPoetryView
{
    @BindView(R.id.btn_fg_getAuthor)
    Button btnFgGetAuthor;
    @BindView(R.id.fg_author)
    TextView fg_author;


    @Override
    public View initView(LayoutInflater layoutInflater, @Nullable ViewGroup container, @Nullable Bundle saveInstanceState)
    {
        return layoutInflater.inflate(R.layout.fragment_author,container,false);
    }

    @Override
    public PoetryPresenter initPresenter()
    {
        return PoetryPresenter.getInstance();
    }

    @Override
    public void searchSuccess(String author)
    {
        fg_author.setText(author);
        Log.e(TAG, "searchSuccess: "+author);
    }

    @Override
    public void searchContent(String content)
    {

    }

    @Override
    public void showProgressDialog()
    {

    }

    @Override
    public void closeProgressDialog()
    {

    }

    @Override
    public void onError(String result)
    {
        Toast.makeText(MyApplication.getContext(),result,Toast.LENGTH_SHORT).show();;
    }
    @OnClick(R.id.btn_fg_getAuthor)
    public void onViewClicked(){
                getPresenter().getPoetry();
                Log.e(TAG, "onViewClicked: " );
        }

}
