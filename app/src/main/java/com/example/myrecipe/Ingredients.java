package com.example.myrecipe;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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

public class Ingredients extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    DBHelper dbHelper;
    ViewPager viewPager;
    TabLayout tabLayout;
    List<String> allIngredients;
    List<Dish> allDishes;
    RecipeFragment recipeFragment;
    private List<String> selectedIngredients = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_ingredients);

        dbHelper = new DBHelper(this);


        ViewPager viewPager = findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tabLayout);

        recipeFragment = new RecipeFragment(new ArrayList<>(), allDishes);

        allIngredients = dbHelper.getAllIngredients();
        allDishes = Data.getAllDishes();

        setupViewPager();

        // Initialize recipe fragment
        recipeFragment = new RecipeFragment(new ArrayList<>(), allDishes);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new IngredientFragment(allIngredients, this), "Ingredients");
        adapter.addFragment(recipeFragment, "Recipes");
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

        // Navigation view item click listener
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_ingredients);

    }

    private void setupViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent i;
        switch (item.getItemId()) {
            case R.id.nav_home:
                i = new Intent(this, Home.class);
                startActivity(i);
                break;
            case R.id.nav_recipe:
                i = new Intent(this, Recipe.class);
                startActivity(i);
                break;
            case R.id.nav_ingredients:
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    public void toggleIngredient(String ingredient, Button button) {
        if (selectedIngredients.contains(ingredient)) {
            selectedIngredients.remove(ingredient);
            button.setBackgroundColor(Color.TRANSPARENT);
        } else {
            selectedIngredients.add(ingredient);
            button.setBackgroundColor(Color.LTGRAY);
        }

        updateRecipesList();
    }

    private void updateRecipesList() {
        List<String> matchedRecipes = new ArrayList<>();

        for (Dish dish : allDishes) {
            boolean containsAnySelected = false;
            for (String selectedIngredient : selectedIngredients) {
                if (dish.getAllIngredients().contains(selectedIngredient)) {
                    containsAnySelected = true;
                    break;
                }
            }
            if (containsAnySelected) {
                matchedRecipes.add(dish.getIngredient());
            }
        }

        recipeFragment.updateRecipesList(matchedRecipes);
    }

                private static class ViewPagerAdapter extends FragmentPagerAdapter {

                    private final List<Fragment> fragmentList = new ArrayList<>();
                    private final List<String> fragmentTitleList = new ArrayList<>();

                    public ViewPagerAdapter(FragmentManager manager) {
                        super(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
                    }

                    @Override
                    public Fragment getItem(int position) {
                        return fragmentList.get(position);
                    }

                    @Override
                    public int getCount() {
                        return fragmentList.size();
                    }

                    public void addFragment(Fragment fragment, String title) {
                        fragmentList.add(fragment);
                        fragmentTitleList.add(title);
                    }

                    @Override
                    public CharSequence getPageTitle(int position) {
                        return fragmentTitleList.get(position);
                    }
                }
            }
