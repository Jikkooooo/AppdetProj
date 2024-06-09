package com.example.myrecipe;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class ViewRecipe extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    // VARIABLES
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_recipe);

        // INITIALIZING COMPONENTS
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

        // Set navigation item selected listener
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_recipe);

        // Get dishes from Data class
        List<Dish> dishes = Data.getAllDishes();

        // Display only the ingredients of the first dish
        if (!dishes.isEmpty()) {
            displayIngredients(dishes.get(0));
        }
    }

    private void displayIngredients(Dish dish) {
        StringBuilder ingredientsText = new StringBuilder();
        //StringBuilder dishText = new StringBuilder(); ifelse
        List<String> ingredients = dish.getAllIngredients();
        for (String ingredient : ingredients) {
            ingredientsText.append("- ").append(ingredient).append("\n");
        }

        TextView tvIngredients = findViewById(R.id.tvIngredients);
        tvIngredients.setText(ingredientsText.toString());
    }

    // Prevent the app from exiting when back pressed while the navigation drawer is open
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
        Intent intent;
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                intent = new Intent(this, Home.class);
                startActivity(intent);
                break;

            case R.id.nav_recipe:
                intent = new Intent(this, Ingredients.class);
                startActivity(intent);
                break;

            case R.id.nav_ingredients:
                intent = new Intent(this, Ingredients.class);
                startActivity(intent);
                break;

            default:
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
