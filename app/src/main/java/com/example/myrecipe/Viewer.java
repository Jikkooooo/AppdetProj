package com.example.myrecipe;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Viewer extends AppCompatActivity {

    private TextView recipeNameTextView;
    private TextView ingredientsTextView;
    private TextView procedureTextView;
    private ImageView recipeImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewer);

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
}
