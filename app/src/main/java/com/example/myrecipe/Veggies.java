package com.example.myrecipe;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Veggies extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    public CardView card1, card2, card3, card4, card5;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.cv1:
                Intent intent1 = new Intent(this, Veggies.class);
                startActivity(intent1);
                break;
            case R.id.cv2:
                Intent intent2 = new Intent(this, Veggies.class);
                startActivity(intent2);
                break;
            case R.id.cv3:
                Intent  intent3 = new Intent(this, Veggies.class);
                startActivity(intent3);
                break;
            case R.id.cv4:
                Intent intent4= new Intent(this, Veggies.class);
                startActivity(intent4);
                break;
            case R.id.cv5:
                Intent intent5= new Intent(this, Veggies.class);
                startActivity(intent5);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_veggies);

        //IINITIALIZING NG ILALAGAY SA SCREEN
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        //TOOLBAR
        setSupportActionBar(toolbar);

        //Drawer Menu
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //Para maclick yung mga navigation buttons
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_ingredients);

        card1 = findViewById(R.id.cv1);
        card2 = findViewById(R.id.cv2);
        card3 = findViewById(R.id.cv3);
        card4 = findViewById(R.id.cv4);
        card5 = findViewById(R.id.cv5);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);
    }

    //Para di agad magexit  yung app pagnabackPress habang nasa navigation drawer
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Intent i;
        switch (menuItem.getItemId()) {

            case R.id.nav_home:
                i = new Intent(this, Home.class);
                startActivity(i);
                break;

            case R.id.nav_ingredients:
                i= new Intent(this, Ingredients.class);
                startActivity(i);
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}