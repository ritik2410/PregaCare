package com.example.pregacare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    //TextView info1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabLayout tabLayout1 = findViewById(R.id.tabLayout);
        ViewPager viewPager1 = findViewById(R.id.viewpager);
        Toolbar toolbar = findViewById(R.id.toolbar);
        //info1 = findViewById(R.id.link1);
        setSupportActionBar(toolbar);

        PagerAdapter pagerAdapter = new PagerActivity(getSupportFragmentManager());

        if (viewPager1 != null) {
            viewPager1.setAdapter(pagerAdapter);
            tabLayout1.setupWithViewPager(viewPager1);
        }
    }
}