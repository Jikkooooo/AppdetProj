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

public class Dessert extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    public CardView card1, card2, card3, card4, card5, card6, card7, card8;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.cv1:
                Intent intent1 = new Intent(this, Viewer.class);
                intent1.putExtra("recipeName", "Hako-Halo");
                intent1.putExtra("ingredients", "Chicken , Pork, Soy sauce, Vinegar, Garlic, Bay leaves, Peppercorns");
                intent1.putExtra("procedure", "Marinate chicken or pork in a mixture of soy sauce, vinegar, garlic, bay leaves, and peppercorns for at least 30 minutes. Sear the meat in oil until browned. Optionally, sauté onions until translucent. Add reserved marinade, water, and sugar, then simmer until tender. Adjust seasoning and thickness of sauce as desired. Serve hot with rice."); // Example data
                intent1.putExtra("imageResourceId", R.drawable.halohalo);
                startActivity(intent1);
                break;
            case R.id.cv2:
                Intent intent2 = new Intent(this, Viewer.class);
                intent2.putExtra("recipeName", "Puto");
                intent2.putExtra("ingredients", "Chicken , Pork, Soy sauce, Vinegar, Garlic, Bay leaves, Peppercorns");
                intent2.putExtra("procedure", "Marinate chicken or pork in a mixture of soy sauce, vinegar, garlic, bay leaves, and peppercorns for at least 30 minutes. Sear the meat in oil until browned. Optionally, sauté onions until translucent. Add reserved marinade, water, and sugar, then simmer until tender. Adjust seasoning and thickness of sauce as desired. Serve hot with rice."); // Example data
                intent2.putExtra("imageResourceId", R.drawable.puto);
                startActivity(intent2);
                break;
            case R.id.cv3:
                Intent intent3 = new Intent(this, Viewer.class);
                intent3.putExtra("recipeName", "Turon");
                intent3.putExtra("ingredients", "Chicken , Pork, Soy sauce, Vinegar, Garlic, Bay leaves, Peppercorns");
                intent3.putExtra("procedure", "Marinate chicken or pork in a mixture of soy sauce, vinegar, garlic, bay leaves, and peppercorns for at least 30 minutes. Sear the meat in oil until browned. Optionally, sauté onions until translucent. Add reserved marinade, water, and sugar, then simmer until tender. Adjust seasoning and thickness of sauce as desired. Serve hot with rice."); // Example data
                intent3.putExtra("imageResourceId", R.drawable.turon);
                startActivity(intent3);
                break;
            case R.id.cv4:
                Intent intent4 = new Intent(this, Viewer.class);
                intent4.putExtra("recipeName", "Sapin-Sapin");
                intent4.putExtra("ingredients", "Chicken , Pork, Soy sauce, Vinegar, Garlic, Bay leaves, Peppercorns");
                intent4.putExtra("procedure", "Marinate chicken or pork in a mixture of soy sauce, vinegar, garlic, bay leaves, and peppercorns for at least 30 minutes. Sear the meat in oil until browned. Optionally, sauté onions until translucent. Add reserved marinade, water, and sugar, then simmer until tender. Adjust seasoning and thickness of sauce as desired. Serve hot with rice."); // Example data
                intent4.putExtra("imageResourceId", R.drawable.sapinsapin);
                startActivity(intent4);
                break;
            case R.id.cv5:
                Intent intent5 = new Intent(this, Viewer.class);
                intent5.putExtra("recipeName", "Bibingka");
                intent5.putExtra("ingredients", "Chicken , Pork, Soy sauce, Vinegar, Garlic, Bay leaves, Peppercorns");
                intent5.putExtra("procedure", "Marinate chicken or pork in a mixture of soy sauce, vinegar, garlic, bay leaves, and peppercorns for at least 30 minutes. Sear the meat in oil until browned. Optionally, sauté onions until translucent. Add reserved marinade, water, and sugar, then simmer until tender. Adjust seasoning and thickness of sauce as desired. Serve hot with rice."); // Example data
                intent5.putExtra("imageResourceId", R.drawable.bibingka);
                startActivity(intent5);
                break;
            case R.id.cv6:
                Intent intent6 = new Intent(this, Viewer.class);
                intent6.putExtra("recipeName", "Taho");
                intent6.putExtra("ingredients", "Chicken , Pork, Soy sauce, Vinegar, Garlic, Bay leaves, Peppercorns");
                intent6.putExtra("procedure", "Marinate chicken or pork in a mixture of soy sauce, vinegar, garlic, bay leaves, and peppercorns for at least 30 minutes. Sear the meat in oil until browned. Optionally, sauté onions until translucent. Add reserved marinade, water, and sugar, then simmer until tender. Adjust seasoning and thickness of sauce as desired. Serve hot with rice."); // Example data
                intent6.putExtra("imageResourceId", R.drawable.taho);
                startActivity(intent6);
                break;
            case R.id.cv7:
                Intent intent7 = new Intent(this, Viewer.class);
                intent7.putExtra("recipeName", "Uber Halaya");
                intent7.putExtra("ingredients", "Chicken , Pork, Soy sauce, Vinegar, Garlic, Bay leaves, Peppercorns");
                intent7.putExtra("procedure", "Marinate chicken or pork in a mixture of soy sauce, vinegar, garlic, bay leaves, and peppercorns for at least 30 minutes. Sear the meat in oil until browned. Optionally, sauté onions until translucent. Add reserved marinade, water, and sugar, then simmer until tender. Adjust seasoning and thickness of sauce as desired. Serve hot with rice."); // Example data
                intent7.putExtra("imageResourceId", R.drawable.ubehalaya);
                startActivity(intent7);
                break;
            case R.id.cv8:
                Intent intent8 = new Intent(this, Viewer.class);
                intent8.putExtra("recipeName", "Buko Pandan");
                intent8.putExtra("ingredients", "Chicken , Pork, Soy sauce, Vinegar, Garlic, Bay leaves, Peppercorns");
                intent8.putExtra("procedure", "Marinate chicken or pork in a mixture of soy sauce, vinegar, garlic, bay leaves, and peppercorns for at least 30 minutes. Sear the meat in oil until browned. Optionally, sauté onions until translucent. Add reserved marinade, water, and sugar, then simmer until tender. Adjust seasoning and thickness of sauce as desired. Serve hot with rice."); // Example data
                intent8.putExtra("imageResourceId", R.drawable.bukopandan);
                startActivity(intent8);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dessert);

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

        card1 = findViewById(R.id.cv1);
        card2 = findViewById(R.id.cv2);
        card3 = findViewById(R.id.cv3);
        card4 = findViewById(R.id.cv4);
        card5 = findViewById(R.id.cv5);
        card6 = findViewById(R.id.cv6);
        card7 = findViewById(R.id.cv7);
        card8 = findViewById(R.id.cv8);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);
        card6.setOnClickListener(this);
        card7.setOnClickListener(this);
        card8.setOnClickListener(this);


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

            case R.id.nav_upload:
                i= new Intent(this, DataEntryActivity.class);
                startActivity(i);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}

