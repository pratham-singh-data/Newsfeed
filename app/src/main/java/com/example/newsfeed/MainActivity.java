package com.example.newsfeed;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout mainTabSelector;

    TabItem homeTabItem;
    TabItem techTabItem;
    TabItem healthTabItem;
    TabItem scienceTabItem;
    TabItem sportsTabItem;
    TabItem businessTabItem;
    TabItem entertainmentTabItem;

    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainTabSelector = findViewById(R.id.mainTabSelector);
        homeTabItem = findViewById(R.id.homeTabItem);
        techTabItem = findViewById(R.id.techTabItem);
        healthTabItem = findViewById(R.id.healthTabItem);
        scienceTabItem = findViewById(R.id.scienceTabItem);
        businessTabItem = findViewById(R.id.businessTabItem);
        sportsTabItem = findViewById(R.id.sportsTabItem);
        entertainmentTabItem = findViewById(R.id.entertainmentTabItem);
        ViewPager viewPager = findViewById(R.id.fragmentContainer);

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), 7);
        viewPager.setAdapter(pagerAdapter);

        mainTabSelector.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                if(tab.getPosition() >= 0 && tab.getPosition() <= 6){
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mainTabSelector));
    }
}