package com.example.dell.myapp.Fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.myapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShoeFragment extends Fragment {
   private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private View mView;
    private List<Fragment> mFragment;

    public ShoeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        mView= inflater.inflate(R.layout.fragment_shoe, container, false);

        initView();
        init();

        return mView;
    }

    private void initView() {
        mTabLayout=(TabLayout)mView.findViewById(R.id.tab_layout);
        mViewPager=(ViewPager)mView.findViewById(R.id.view_pager);
    }

    private void init() {
        mFragment=new ArrayList<>();
        mFragment.add(new LeisureShoeFragment());
        mFragment.add(new GymShoesFragment());

        //当Fragment嵌套Fragment时，里面需要用getChildFragmentManager来获得FragmentManager
        mViewPager.setAdapter(new MyViewPagerFragmentAdapter(getChildFragmentManager()));

        //TabLayout与ViewPager关联
        mTabLayout.setupWithViewPager(mViewPager);

        mTabLayout.getTabAt(0).setText("休闲鞋");
        mTabLayout.getTabAt(1).setText("运动鞋");
    }

    public class MyViewPagerFragmentAdapter extends FragmentPagerAdapter {

        public MyViewPagerFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragment.get(position);
        }

        @Override
        public int getCount() {
            return mFragment.size();
        }
    }

}
