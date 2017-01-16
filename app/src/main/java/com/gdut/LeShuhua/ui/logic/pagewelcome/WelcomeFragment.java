package com.gdut.LeShuhua.ui.logic.pagewelcome;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gdut.LeShuhua.R;
import com.gdut.LeShuhua.common.BaseFragment;


/**
 * Created by lchua on 2017/1/14.
 * <p>
 * 描述：
 */

public class WelcomeFragment extends BaseFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_recycle);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
