package com.sezzh.smood.activities;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.sezzh.smood.R;
import com.sezzh.smood.ui.fragments.ColorListFragment;
import com.sezzh.smood.ui.ColorPaletteListFragment;

import java.util.ArrayList;
import java.util.List;


public class ColorsActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private FloatingActionButton mFab;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_colors);
        this.mToolbar = (Toolbar) this.findViewById(R.id.toolbar);
        assert mToolbar != null;
        this.mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_24dp);
        this.mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        this.setSupportActionBar(this.mToolbar);
        this.mViewPager = (ViewPager) this.findViewById(R.id.viewpager);
        this.setupViewPager();
        this.mTabLayout = (TabLayout) this.findViewById(R.id.tabs);
        assert this.mTabLayout != null;
        this.mTabLayout.setupWithViewPager(this.mViewPager);
        this.mFab = (FloatingActionButton) this.findViewById(R.id.fab);
        this.mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ColorsActivity", "" + mViewPager
                        .getAdapter()
                        .getPageTitle(mViewPager.getCurrentItem()));

            }
        });

    }

    private void setupViewPager() {
        ViewPagerAdapter mAdapter =
                new ViewPagerAdapter(this.getSupportFragmentManager());
        mAdapter.addFragment(
                new ColorListFragment(),
                this.getResources().getString(R.string.tab_colors_title)
        );
        mAdapter.addFragment(
                new ColorPaletteListFragment(),
                this.getResources()
                        .getString(R.string.tab_color_palettes_title)
        );
        this.mViewPager.setAdapter(mAdapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<Fragment>();
        private final List<String> mFragmentTitleList =
                new ArrayList<String>();

        public ViewPagerAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return this.mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            this.mFragmentList.add(fragment);
            this.mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return this.mFragmentTitleList.get(position);
        }
    }

}
