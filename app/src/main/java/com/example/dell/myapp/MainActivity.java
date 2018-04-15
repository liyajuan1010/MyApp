package com.example.dell.myapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.dell.myapp.Fragment.BagsFragment;
import com.example.dell.myapp.Fragment.ClothesFragment;
import com.example.dell.myapp.Fragment.MeFragment;
import com.example.dell.myapp.Fragment.ShoeFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
//BottomNavigationBar要建立依赖，通过compile
public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {
    private BottomNavigationBar mBottomNavigationBar;
    private List<Fragment> mFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();//绑定
        init();
    }

    private void initView() {
        mBottomNavigationBar=(BottomNavigationBar)findViewById(R.id.bottom_navigation_bar);
    }

    private void init() {
        //Fragment初始化
        mFragment=new ArrayList<>();
        mFragment.add(new ClothesFragment());
        mFragment.add(new BagsFragment());
        mFragment.add(new ShoeFragment());
        mFragment.add(new MeFragment());

        //BottomNavigation初始化
        mBottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.nav_clothes_selector,"女装"))
               .addItem(new BottomNavigationItem(R.drawable.nav_bags_selector,"女包"))
               .addItem(new BottomNavigationItem(R.drawable.nav_shoe_selector,"女鞋"))
               .addItem(new BottomNavigationItem(R.drawable.nav_me_selector,"我的"))
               .setMode(BottomNavigationBar.MODE_FIXED)
               .initialise();//initialise()初始化数据
//        链式

        mBottomNavigationBar.setTabSelectedListener(this);
        //设置默认选项
        setDefaultFragment();
    }

    private void setDefaultFragment() {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.container,mFragment.get(0));
        ft.commit();
    }

    @Override
    public void onTabSelected(int position) {
        FragmentManager fm=getSupportFragmentManager();//FragmentManager管理Activity中的Fragment
        FragmentTransaction ft=fm.beginTransaction();//FragmentTransaction管理事务  ，FragmentManager.beginTransaction()开始一个事务。
        ft.replace(R.id.container,mFragment.get(position));
        ft.commit();//提交事务
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
