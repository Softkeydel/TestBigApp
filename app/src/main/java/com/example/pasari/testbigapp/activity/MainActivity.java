package com.example.pasari.testbigapp.activity;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.pasari.testbigapp.R;
import com.example.pasari.testbigapp.adapter.TopSliderAdapter;
import com.example.pasari.testbigapp.adapter.ViewPagerAdapter;
import com.example.pasari.testbigapp.fragment.CommonFragment;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    private Toolbar toolbar;
    private DrawerLayout drawer;
    private TabLayout tabLayout;
    private ViewPager viewPager,intro_slider;
    private LinearLayout pager_indicator;
    private ImageView[] dots;

    private TopSliderAdapter mAdapter;
    private int dotsCount;
    private String[] tabHeader={"VIDEOS","IMAGES","MILESTONE"};
    private int[] tabIcons_sel = {
            R.drawable.select_video,
            R.drawable.select_image,
            R.drawable.select_milestone
    };
    private int[] tabIcons = {
            R.drawable.video,
            R.drawable.image,
            R.drawable.milestone
    };

    private int[] mImageResources = {
            R.drawable.abc1,
            R.drawable.abc2,
            R.drawable.abc3,
    };





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        intro_slider = (ViewPager) findViewById(R.id.intro_slider);
        pager_indicator = (LinearLayout) findViewById(R.id.viewpager_count_dots);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);


        setUI();




        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                System.out.println("Dukchhe");
                setUptabUI(tab.getPosition(),getResources().getColor(R.color.colorPrimary),tabIcons_sel);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                setUptabUI(tab.getPosition(),getResources().getColor(R.color.text_color),tabIcons);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                System.out.println("Dukchhe");
            }
        });

    }


    private void setUI(){
        try{

            setSupportActionBar(toolbar);

            ////////////////////////
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.setDrawerListener(toggle);
            toggle.syncState();

            ///////////////////////
            mAdapter = new TopSliderAdapter(MainActivity.this, mImageResources);
            intro_slider.setAdapter(mAdapter);
            intro_slider.setCurrentItem(0);
            intro_slider.setOnPageChangeListener(this);
            setUiPageViewController();

            ///////////////////
            setupViewPager(viewPager);
            tabLayout.setupWithViewPager(viewPager);
            for(int i=0;i<tabHeader.length;i++){
                setUptabUI(i,getResources().getColor(R.color.text_color),tabIcons);
            }

            setUptabUI( tabLayout.getSelectedTabPosition(),getResources().getColor(R.color.colorPrimary),tabIcons_sel);

        }catch (Exception e){
            /////////////////////
        }

    }


    private void setUptabUI(int position,int color,int[] icon){
        TextView tab = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tab.setText(tabHeader[position]);
        tab.setTextColor(color);
        tab.setCompoundDrawablesWithIntrinsicBounds(0, icon[position], 0, 0);
        tabLayout.getTabAt(position).setCustomView(null);
        tabLayout.getTabAt(position).setCustomView(tab);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new CommonFragment(), tabHeader[0]);
        adapter.addFrag(new CommonFragment(), tabHeader[1]);
        adapter.addFrag(new CommonFragment(), tabHeader[2]);
        viewPager.setAdapter(adapter);
    }



    private void setUiPageViewController() {

        dotsCount = mAdapter.getCount();
        dots = new ImageView[dotsCount];

        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(4, 0, 4, 0);

            pager_indicator.addView(dots[i], params);
        }
        dots[0].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < dotsCount; i++) {
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));
        }
        dots[position].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
