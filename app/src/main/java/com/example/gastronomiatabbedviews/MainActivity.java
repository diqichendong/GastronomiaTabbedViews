package com.example.gastronomiatabbedviews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 paginador = findViewById(R.id.paginador);
        paginador.setAdapter(new ScreenSliderPagerAdapter(this));

        TabLayout pestanyas = findViewById(R.id.pestanyas);
        new TabLayoutMediator(pestanyas, paginador, (tab, position) -> {
            switch (position) {
                case 0: tab.setText("Internacional"); break;
                case 1: tab.setText("Exótico"); break;
                case 2: tab.setText("Tradiciones"); break;
            }
        }).attach();

    }

    private static class ScreenSliderPagerAdapter extends FragmentStateAdapter {

        public ScreenSliderPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            Fragment f = null;

            switch (position) {
                case 0: f = new InternacionalFragment(); break;
                case 1: f = new ExoticoFragment(); break;
                case 2: f = new TradicionesFragment(); break;
            }

            return f;
        }

        @Override
        public int getItemCount() {
            return 3;
        }
    }
}