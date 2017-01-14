package com.gdut.LeShuhua.common;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by lchua on 2017/1/14.
 * <p>
 * 描述：
 */

public class BaseActivity extends AppCompatActivity implements BaseFunImpl {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        initTheme();
        super.onCreate(savedInstanceState);
    }

    /**
     * 可以获取界面中某个view 宽高
     *
     * @param savedInstanceState
     */
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        initData();
        initView();
        initListener();
        initLoad();
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initLoad() {

    }
}
