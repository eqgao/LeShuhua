package com.gdut.LeShuhua.common;

/**
 * Created by lchua on 2017/1/14.
 * <p>
 * 描述：
 */

interface BaseFunImpl {
    /**
     * 初始化数据方法
     */
    void initData();

    /**
     * 初始化UI控件方法
     */
    void initView();

    /**
     * 初始化事件监听方法
     */
    void initListener();

    /**
     * 初始化界面加载
     */
    void initLoad();
}
