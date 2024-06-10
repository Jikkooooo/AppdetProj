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

public class Meat extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    public CardView card1, card2, card3, card4, card5, card6, card7, card8;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.cv1:
                Intent intent1 = new Intent(this, Viewer.class);
                intent1.putExtra("recipeName", "Adobo");
                intent1.putExtra("ingredients", "Chicken , Pork, Soy sauce, Vinegar, Garlic, Bay leaves, Peppercorns");
                intent1.putExtra("procedure", "Marinate chicken or pork in a mixture of soy sauce, vinegar, garlic, bay leaves, and peppercorns for at least 30 minutes. Sear the meat in oil until browned. Optionally, sauté onions until translucent. Add reserved marinade, water, and sugar, then simmer until tender. Adjust seasoning and thickness of sauce as desired. Serve hot with rice."); // Example data
                intent1.putExtra("imageResourceId", R.drawable.adobo);
                startActivity(intent1);
                break;
            case R.id.cv2:
                Intent intent2 = new Intent(this, Viewer.class);
                intent2.putExtra("recipeName", "Dinuguan");
                intent2.putExtra("ingredients", "Pork, Pork blood, Vinegar, Garlic, Chili peppers, Onions");
                intent2.putExtra("procedure", "Marinate chicken or pork in a mixture of soy sauce, vinegar, garlic, bay leaves, and peppercorns for at least 30 minutes. Sear the meat in oil until browned. Optionally, sauté onions until translucent. Add reserved marinade, water, and sugar, then simmer until tender. Adjust seasoning and thickness of sauce as desired. Serve hot with rice."); // Example data
                intent2.putExtra("imageResourceId", R.drawable.dinuguan);
                startActivity(intent2);
                break;
            case R.id.cv3:
                Intent  intent3 = new Intent(this, Viewer.class);
                intent3.putExtra("recipeName", "Lechon");
                intent3.putExtra("ingredients", "Pork, Salt, Garlic, Lemongrass");
                intent3.putExtra("procedure", "Clean and dry a whole pig. Marinate with soy sauce, calamansi juice, garlic, onions, black pepper, and salt. Stuff cavity with lemongrass, bay leaves, garlic, onions, and green apples. Skewer pig onto a spit and roast over charcoal, rotating slowly. Baste with oil and milk mixture every 30 minutes. Roast until skin is crisp and internal temperature reaches 160°F. Rest before carving and serve with lechon sauce or vinegar dip."); // Example data
                intent3.putExtra("imageResourceId", R.drawable.lechon);
                startActivity(intent3);
                break;
            case R.id.cv4:
                Intent intent4= new Intent(this, Viewer.class);
                intent4.putExtra("recipeName", "Kare-Kare");
                intent4.putExtra("ingredients", "Pork\", \" Tamarind\" , \"Radish\", \"Okra\", \"Spinach\"");
                intent4.putExtra("procedure", "Boil water and add tomatoes and onions. Add pork and cook until tender. Add radish, kangkong, string beans, and green chilies, and cook until vegetables are tender. Dissolve sinigang mix or tamarind in water, add to pot, and simmer. Season with fish sauce or salt. Add water spinach and cook until wilted. Adjust sourness and serve hot with rice.");
                intent4.putExtra("imageResourceId", R.drawable.karekare);
                startActivity(intent4);
                break;
            case R.id.cv5:
                Intent intent5= new Intent(this, Viewer.class);
                intent5.putExtra("recipeName", "Tinola");
                intent5.putExtra("ingredients", "Chicken \", \"Pork\", \"Soy sauce\", \"Vinegar\", \"Garlic\", \"Bay leaves\", \"Peppercorns");
                intent5.putExtra("procedure", "Marinate chicken or pork in a mixture of soy sauce, vinegar, garlic, bay leaves, and peppercorns for at least 30 minutes. Sear the meat in oil until browned. Optionally, sauté onions until translucent. Add reserved marinade, water, and sugar, then simmer until tender. Adjust seasoning and thickness of sauce as desired. Serve hot with rice."); // Example data
                intent5.putExtra("imageResourceId", R.drawable.tinola);
                startActivity(intent5);
                break;
            case R.id.cv6:
                Intent intent6= new Intent(this, Viewer.class);
                intent6.putExtra("recipeName", "Bistek Tagalog");
                intent6.putExtra("ingredients", "Chicken \", \"Pork\", \"Soy sauce\", \"Vinegar\", \"Garlic\", \"Bay leaves\", \"Peppercorns");
                intent6.putExtra("procedure", "Marinate chicken or pork in a mixture of soy sauce, vinegar, garlic, bay leaves, and peppercorns for at least 30 minutes. Sear the meat in oil until browned. Optionally, sauté onions until translucent. Add reserved marinade, water, and sugar, then simmer until tender. Adjust seasoning and thickness of sauce as desired. Serve hot with rice."); // Example data
                intent6.putExtra("imageResourceId", R.drawable.bistektagalog);
                startActivity(intent6);
                break;
            case R.id.cv7:
                Intent intent7= new Intent(this, Viewer.class);
                intent7.putExtra("recipeName", "Bicol Express");
                intent7.putExtra("ingredients", "Chicken \", \"Pork\", \"Soy sauce\", \"Vinegar\", \"Garlic\", \"Bay leaves\", \"Peppercorns");
                intent7.putExtra("procedure", "Marinate chicken or pork in a mixture of soy sauce, vinegar, garlic, bay leaves, and peppercorns for at least 30 minutes. Sear the meat in oil until browned. Optionally, sauté onions until translucent. Add reserved marinade, water, and sugar, then simmer until tender. Adjust seasoning and thickness of sauce as desired. Serve hot with rice."); // Example data
                intent7.putExtra("imageResourceId", R.drawable.bicolexpress);
                startActivity(intent7);
                break;
            case R.id.cv8:
                Intent intent8= new Intent(this, Viewer.class);
                intent8.putExtra("recipeName", "Sisig");
                intent8.putExtra("ingredients", "Chicken \", \"Pork\", \"Soy sauce\", \"Vinegar\", \"Garlic\", \"Bay leaves\", \"Peppercorns");
                intent8.putExtra("procedure", "Marinate chicken or pork in a mixture of soy sauce, vinegar, garlic, bay leaves, and peppercorns for at least 30 minutes. Sear the meat in oil until browned. Optionally, sauté onions until translucent. Add reserved marinade, water, and sugar, then simmer until tender. Adjust seasoning and thickness of sauce as desired. Serve hot with rice."); // Example data
                intent8.putExtra("imageResourceId", R.drawable.sisig);
                startActivity(intent8);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_meat);

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
        navigationView.setCheckedItem(R.id.nav_recipe);

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

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}


