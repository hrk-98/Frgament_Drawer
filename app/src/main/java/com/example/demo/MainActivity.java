package com.example.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    TabLayout tabelayout;
    ViewPager pager;
    DrawerLayout drawerLayout;
    ImageView menu;
    NavigationView nav_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        pager=findViewById(R.id.viewpager);
        tabelayout=findViewById(R.id.tab);

        tabelayout.addTab(tabelayout.newTab().setText("CHATS"));
        tabelayout.addTab(tabelayout.newTab().setText("STATUS"));
        tabelayout.addTab(tabelayout.newTab().setText("CALLS"));


        FragpageAdapter adapter1=new FragpageAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter1);

        tabelayout.setupWithViewPager(pager);

        nav_view=findViewById(R.id.nav_view);
        menu=findViewById(R.id.menu);
        drawerLayout=findViewById(R.id.drawer);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.about:
                        Toast.makeText(MainActivity.this, "About", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.system:
                        Toast.makeText(MainActivity.this, "System", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.more:
                        Toast.makeText(MainActivity.this, "More", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.setting:
                        Toast.makeText(MainActivity.this, "Setting", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });

    }
}