package com.example.myrecipe;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Viewer extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private TextView recipeNameTextView;
    private TextView ingredientsTextView;
    private TextView procedureTextView;
    private ImageView recipeImageView;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewer);

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

        // Set navigation item selected listener
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_view);
        // Initialize views
        recipeImageView = findViewById(R.id.imageView);
        recipeNameTextView = findViewById(R.id.recipeName);
        ingredientsTextView = findViewById(R.id.tvIngredients);
        procedureTextView = findViewById(R.id.tvRecipe);

        // Get data from intent
        String recipeName = getIntent().getStringExtra("recipeName");
        String ingredients = getIntent().getStringExtra("ingredients");
        String procedure = getIntent().getStringExtra("procedure");
        int imageResourceId = getIntent().getIntExtra("imageResourceId", R.drawable.android);


        // Update views with data
        recipeNameTextView.setText(recipeName);
        ingredientsTextView.setText(ingredients);
        procedureTextView.setText(procedure);
        recipeImageView.setImageResource(imageResourceId);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Intent intent;
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                intent = new Intent(this, Home.class);
                startActivity(intent);
                break;

            case R.id.nav_ingredients:
                intent = new Intent(this, Ingredients.class);
                startActivity(intent);
                break;

            case R.id.nav_upload:
                intent= new Intent(this, DataEntryActivity.class);
                startActivity(intent);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
