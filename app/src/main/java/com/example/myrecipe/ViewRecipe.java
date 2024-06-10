package com.example.myrecipe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
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
    DBHelper dbHelper = new DBHelper(this);

    @SuppressLint("DiscouragedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_recipe);

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

        // Get dishes from Data class
        List<Dish> dishes = Data.getAllDishes();
        TextView recipeNameTextView = findViewById(R.id.recipeName);
        TextView tvRecipe = findViewById(R.id.tvRecipe);
        ImageView imageView = findViewById(R.id.imageView);

        // Display only the ingredients of the first dish
        if (!dishes.isEmpty()) {
            displayIngredients(dishes.get(0));
        }

        String recipeName = getIntent().getStringExtra("recipeName");
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] columns = {DBHelper.TABLE1_COLUMN_DISH, DBHelper.TABLE1_COLUMN_RECIPE, DBHelper.TABLE1_COLUMN_IMG};
        String selection = DBHelper.TABLE1_COLUMN_DISH + "=?";
        String[] selectionArgs = {recipeName};

        Cursor cursor = db.query(DBHelper.TABLE1_NAME, columns, selection, selectionArgs, null, null, null);
        if (cursor.moveToFirst()) {
            @SuppressLint("Range") String dish_name = cursor.getString(cursor.getColumnIndex(DBHelper.TABLE1_COLUMN_DISH));
            @SuppressLint("Range") String store_recipe = cursor.getString(cursor.getColumnIndex(DBHelper.TABLE1_COLUMN_RECIPE));
            @SuppressLint("Range") String recipe_img = cursor.getString(cursor.getColumnIndex(DBHelper.TABLE1_COLUMN_IMG));

            int imageResId = getResources().getIdentifier(recipe_img, "drawable", getPackageName());
            if (imageResId != 0) { // Check if the resource exists
                imageView.setImageResource(imageResId);
            } else {
                imageResId = getResources().getIdentifier("noimg", "drawable", getPackageName());
                imageView.setImageResource(imageResId);
            }
            recipeNameTextView.setText(dish_name);
            tvRecipe.setText(store_recipe);

        } else {
            Log.d("Home", "No record found in database for: " + recipeName);
        }
        cursor.close();
        db.close();
    }

    private void displayIngredients(Dish dish) {
        StringBuilder ingredientsText = new StringBuilder();
        List<String> ingredients = dish.getAllIngredients();
        for (String ingredient : ingredients) {
            ingredientsText.append("- ").append(ingredient).append("\n");
        }

        TextView tvIngredients = findViewById(R.id.tvIngredients);
        tvIngredients.setText(ingredientsText.toString());
    }

    // New method to scan a TextView of another layout and compare it to the dish ArrayList
    private void scanAndDisplayIngredients(int layoutId, int textViewId, List<Dish> dishes) {
        LayoutInflater inflater = LayoutInflater.from(this);
        View layoutView = inflater.inflate(R.layout.activity_meat, null);
        TextView textView = layoutView.findViewById(R.id.tvMeat1);
        String textViewContent = textView.getText().toString();

        for (Dish dish : dishes) {
            if (dish.getIngredient().equalsIgnoreCase(textViewContent)) {
                displayIngredients(dish);
                break;
            }
        }
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
