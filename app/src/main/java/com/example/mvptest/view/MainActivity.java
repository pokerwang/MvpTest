package com.example.mvptest.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvptest.R;
import com.example.mvptest.base.BaseActivity;
import com.example.mvptest.base.BaseMvpActivity;
import com.example.mvptest.base.BasePresenter;
import com.example.mvptest.base.MyApplication;
import com.example.mvptest.contract.IPoetryContract;
import com.example.mvptest.presenter.PoetryPresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseMvpActivity<MainActivity, PoetryPresenter>
    implements IPoetryContract.IPoetryView
{
    @BindView(R.id.btn_getAuthor)
    Button btnGetAuthor;
    @BindView(R.id.author)
    TextView mAuthor;
    @BindView(R.id.btn_choose)
    Button btnChoose;
    @BindView(R.id.ll)
    LinearLayout ll;
    private static final String TAG=MyApplication.getContext().getClass().getSimpleName();


    @Override
    protected void initView()
    {

    }

    @Override
    protected int getLayoutId()
    {
        return R.layout.activity_main;
    }

    @Override
    protected PoetryPresenter createPresenter()
    {
        return PoetryPresenter.getInstance();
    }

    @Override
    public void searchSuccess(String author)
    {
     mAuthor.setText(author);
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
        Toast.makeText(MyApplication.getContext(),result,Toast.LENGTH_SHORT).show();
        Log.e(TAG, "onError: "+result );
    }
    @OnClick({R.id.btn_getAuthor,R.id.btn_choose})
    public void onViewClick(View view){
        switch (view.getId()){
            case R.id.btn_getAuthor:
                getPresenter().getPoetry();
                break;
            case R.id.btn_choose:
                startFragment(R.id.ll,new AuthorFragment());
        }

    }

}