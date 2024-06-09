package com.example.myrecipe;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener{

    // VARIABLES
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        // INITIALIZING VIEWS
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        // TOOLBAR
        setSupportActionBar(toolbar);

        // Drawer Menu
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Navigation view item click listener
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        card1 = findViewById(R.id.cv1);
        card2 = findViewById(R.id.cv2);
        card3 = findViewById(R.id.cv3);
        card4 = findViewById(R.id.cv4);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);


    }


    // Para di agad magexit yung app pagnabackPress habang nasa navigation drawer
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    Intent i;
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                break;
            case R.id.nav_recipe:
                i = new Intent(this, Recipe.class);
                startActivity(i);
                break;
            case R.id.nav_ingredients:
                i = new Intent(this, Ingredients.class);
                startActivity(i);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public CardView card1, card2, card3, card4;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.cv1:
                Intent intent1 = new Intent(this, Meat.class);
                startActivity(intent1);
                break;
            case R.id.cv2:
                Intent intent2 = new Intent(this, Veggies.class);
                startActivity(intent2);
                break;
            case R.id.cv3:
                Intent  intent3 = new Intent(this, Fish.class);
                startActivity(intent3);
                break;
            case R.id.cv4:
                Intent intent4= new Intent(this, Meat.class);
                startActivity(intent4);
                break;
        }
    }
}
