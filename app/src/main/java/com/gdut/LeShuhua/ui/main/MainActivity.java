package com.gdut.LeShuhua.ui.main;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gdut.LeShuhua.R;
import com.gdut.LeShuhua.common.BaseActivity;
import com.gdut.LeShuhua.common.FragmentAdapter;
import com.gdut.LeShuhua.entity.DrawerMenuEntity;
import com.gdut.LeShuhua.ui.adapter.DrawerMenuAdapter;
import com.gdut.LeShuhua.ui.custom.MySimpleDraweeView;
import com.gdut.LeShuhua.ui.logic.pagewelcome.WelcomeFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private MySimpleDraweeView mUserImgIv;
    private TextView mUserNameTv;
    private TextView mUserDescTv;
    private RelativeLayout mUserInfoRl;
    private Toolbar mToolBar;
    private ViewPager mContainer;
    private LinearLayout mMainContent;
    private MySimpleDraweeView mUserIv;
    private TextView mUserEmailTv;
    private TextView mNameTv;
    private ImageView mMenuDownIv;
    private RelativeLayout mLoginSuccessRl;
    private TextView mLoginTv;
    private RecyclerView mDrawerMenuRc;
    private LinearLayout mLoginHelpLl;
    private LinearLayout mNavigationView;
    private DrawerLayout mDrawerLayout;

    private List<DrawerMenuEntity> mMainMenuList;
    private DrawerMenuAdapter mMenuAdapter;
    private TabLayout mTabLayout;

    private WelcomeFragment welcomeFragment1;
    private WelcomeFragment welcomeFragment2;
    private WelcomeFragment welcomeFragment3;
    private WelcomeFragment welcomeFragment4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void initToolbar() {
        mToolBar.inflateMenu(R.menu.menu_main);
        Resources.Theme theme = getTheme();
        TypedValue navIcon = new TypedValue();
        TypedValue overFlowIcon = new TypedValue();

        theme.resolveAttribute(R.attr.navIcon, navIcon, true);
        theme.resolveAttribute(R.attr.overFlowIcon, overFlowIcon, true);

        mToolBar.setNavigationIcon(navIcon.resourceId);
        mToolBar.setOverflowIcon(ContextCompat.getDrawable(this, overFlowIcon.resourceId));
    }


    @Override
    public void initData() {
        super.initData();
        mMainMenuList = new ArrayList<>();
        mMainMenuList.add(new DrawerMenuEntity(getString(R.string.menu_upload), R.mipmap.ic_main_palette));
        mMainMenuList.add(new DrawerMenuEntity(getString(R.string.menu_order), R.mipmap.ic_main_palette));
        mMainMenuList.add(new DrawerMenuEntity(getString(R.string.menu_account), R.mipmap.ic_main_palette));
        mMainMenuList.add(new DrawerMenuEntity(getString(R.string.menu_setting), R.mipmap.ic_main_palette));
        mMenuAdapter = new DrawerMenuAdapter(this, mMainMenuList);

    }

    public void findView() {
        mUserImgIv = (MySimpleDraweeView) findViewById(R.id.user_img_iv);
        mUserNameTv = (TextView) findViewById(R.id.user_name_tv);
        mUserDescTv = (TextView) findViewById(R.id.user_desc_tv);
        mUserInfoRl = (RelativeLayout) findViewById(R.id.user_info_rl);
        mToolBar = (Toolbar) findViewById(R.id.toolBar);
        mContainer = (ViewPager) findViewById(R.id.container);
        mMainContent = (LinearLayout) findViewById(R.id.main_content);
        mUserIv = (MySimpleDraweeView) findViewById(R.id.user_iv);
        mUserEmailTv = (TextView) findViewById(R.id.user_email_tv);
        mNameTv = (TextView) findViewById(R.id.name_tv);
        mMenuDownIv = (ImageView) findViewById(R.id.menu_down_iv);
        mLoginSuccessRl = (RelativeLayout) findViewById(R.id.login_success_rl);
        mLoginTv = (TextView) findViewById(R.id.login_tv);
        mDrawerMenuRc = (RecyclerView) findViewById(R.id.drawer_menu_rc);
//        mSettingLl = (LinearLayout) findViewById(R.id.setting_ll);
        mLoginHelpLl = (LinearLayout) findViewById(R.id.login_out_ll);
        mNavigationView = (LinearLayout) findViewById(R.id.navigation_view);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
    }

    public void initView() {
        findView();
        initToolbar();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mDrawerMenuRc.setLayoutManager(layoutManager);
        mDrawerMenuRc.setAdapter(mMenuAdapter);
        setupViewPager();

    }

    private void setupViewPager() {
        List<String> titles = new ArrayList<>();
        titles.add("推荐");
        titles.add("艺术品");
        titles.add("艺术家");
        titles.add("商品");

        welcomeFragment1 = new WelcomeFragment();
        welcomeFragment2 = new WelcomeFragment();
        welcomeFragment3 = new WelcomeFragment();
        welcomeFragment4 = new WelcomeFragment();

        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager());
        fragmentAdapter.addFragment(welcomeFragment1, titles.get(0));
        fragmentAdapter.addFragment(welcomeFragment2, titles.get(1));
        fragmentAdapter.addFragment(welcomeFragment3, titles.get(2));
        fragmentAdapter.addFragment(welcomeFragment4, titles.get(3));

        mContainer.setAdapter(fragmentAdapter);
        mContainer.setOffscreenPageLimit(4);

        mTabLayout.setupWithViewPager(mContainer);
        mTabLayout.setTabsFromPagerAdapter(fragmentAdapter);
    }

}
