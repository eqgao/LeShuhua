package com.gdut.LeShuhua.mvpframe;

import android.content.Context;

import com.gdut.LeShuhua.mvpframe.rx.RxManager;


/**
 * Created by baixiaokang on 16/4/22.
 */
public abstract class BasePresenter<M, V> {
    public Context context;
    public M mModel;
    public V mView;
    public RxManager mRxManager = new RxManager();

    public void setVM(V v, M m) {
        this.mView = v;
        this.mModel = m;
    }


    public void onDestroy() {
        mRxManager.clear();
    }
}
