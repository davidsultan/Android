package com.example.tablayoutwithkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.tablayoutwithkotlin.fragments.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout;
    private lateinit var viewPager: ViewPager;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)

        tabLayout.addTab(tabLayout.newTab().setText("Home"))
        tabLayout.addTab(tabLayout.newTab().setText("Favorites"))
        tabLayout.addTab(tabLayout.newTab().setText("Settings"))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        val adapter = ViewPagerAdapter(this, supportFragmentManager, tabLayout.tabCount)
        viewPager.adapter = adapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }
}