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
import com.sezzh.smood.ui.ColorListFragment;

import java.util.ArrayList;
import java.util.List;


public class ColorsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private FloatingActionButton fab;
    private ViewPager viewPager;
    private TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_colors);
        this.toolbar = (Toolbar) this.findViewById(R.id.toolbar);
        assert toolbar != null;
        this.toolbar.setNavigationIcon(R.drawable.ic_arrow_back_24dp);
        this.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        this.setSupportActionBar(this.toolbar);
        this.viewPager = (ViewPager) this.findViewById(R.id.viewpager);
        this.setupViewPager();
        this.tabLayout = (TabLayout) this.findViewById(R.id.tabs);
        assert this.tabLayout != null;
        this.tabLayout.setupWithViewPager(this.viewPager);
        this.fab = (FloatingActionButton) this.findViewById(R.id.fab);
        this.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ColorsActivity", "" + viewPager
                        .getAdapter()
                        .getPageTitle(viewPager.getCurrentItem()));

            }
        });

    }

    private void setupViewPager() {
        ViewPagerAdapter adapter =
                new ViewPagerAdapter(this.getSupportFragmentManager());
        adapter.addFragment(
                new ColorListFragment(),
                this.getResources().getString(R.string.tab_colors_title)
        );
        adapter.addFragment(
                new ColorListFragment(),
                this.getResources()
                        .getString(R.string.tab_color_palettes_title)
        );
        this.viewPager.setAdapter(adapter);
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
