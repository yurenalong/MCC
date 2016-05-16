package com.axalta.mcc.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.axalta.mcc.Fragment.HomePageFragment;
import com.axalta.mcc.Fragment.CenterFragment;
import com.axalta.mcc.Fragment.NewsFragment;
import com.axalta.mcc.R;

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        initTitle();
    }



    public void go(Class<?> clz) {
        Intent intent = new Intent(this, clz);
        startActivity(intent);
    }

    private void initTitle() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitleTextColor(getResources().getColor(R.color.colorPrimary));
        setSupportActionBar(mToolbar);
        final DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar,
                R.string.drawer_open, R.string.drawer_close);
        mDrawerToggle.syncState();//初始化状态
        if(mDrawerLayout!=null){
            mDrawerLayout.setDrawerListener(mDrawerToggle);
        }
        NavigationView mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        //assert mNavigationView != null;
        if (mNavigationView != null) {
            mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem item) {
                    switch (item.getItemId())
                    {
                        case R.id.item_one:
                            getSupportFragmentManager().beginTransaction().replace(R.id.frame_content,new HomePageFragment()).commit();
                            mToolbar.setTitle("首页");

                            break;
                        case R.id.item_two:
                            getSupportFragmentManager().beginTransaction().replace(R.id.frame_content,new NewsFragment()).commit();
                            mToolbar.setTitle("我的留言");
                            break;
                        case R.id.item_three:
                            getSupportFragmentManager().beginTransaction().replace(R.id.frame_content,new CenterFragment()).commit();
                            mToolbar.setTitle("附近的人");
                            break;
                    }
                    item.setChecked(true);//点击了把它设为选中状态
                    mDrawerLayout.closeDrawers();//关闭抽屉
                    return true;
                }
            });
        }
    }
}
