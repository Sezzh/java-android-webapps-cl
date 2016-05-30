package com.sezzh.smood.activities;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.sezzh.smood.R;
import com.sezzh.smood.ui.fragments.ColorDetailFragment;

public class ColorActivity extends AppCompatActivity implements
        ColorDetailFragment.OnSelectedListener {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_color);

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
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.content_fragment, new ColorDetailFragment())
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSelectedItem(Uri itemUri) {

    }
}
