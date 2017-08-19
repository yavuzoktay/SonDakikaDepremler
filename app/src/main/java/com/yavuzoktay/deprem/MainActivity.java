package com.yavuzoktay.deprem;



import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.yavuzoktay.deprem.fragments.FragmentA;
import com.yavuzoktay.deprem.fragments.FragmentB;
import com.yavuzoktay.deprem.fragments.FragmentC;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private BottomNavigationView navigation;
    private ViewPager viewPager;

    private FragmentA fragmentA = new FragmentA();
    private FragmentB fragmentB = new FragmentB();
    private FragmentC fragmentC = new FragmentC();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setTitle("Depremler");

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.addOnPageChangeListener(this);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);


        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);



        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return fragmentA;
                    case 1:
                        return fragmentB;
                    case 2:
                        return fragmentC;
                }
                return null;
            }

            @Override
            public int getCount() {
                return 3;
            }
        });
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            viewPager.setCurrentItem(item.getOrder());
            return true;
        }

    };

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        navigation.getMenu().getItem(position).setChecked(true);
        //setTitle(String.valueOf(position));
        switch (position) {
            case 0:
                setTitle("Depremler");
                break;
            case 1:
                setTitle("Büyük Depremler");
                break;
            case 2:
                setTitle("Önemli Depremler");
                break;
       }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

}