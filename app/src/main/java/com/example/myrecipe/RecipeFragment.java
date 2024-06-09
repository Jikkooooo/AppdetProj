package com.example.myrecipe;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class RecipeFragment extends Fragment {

    private List<String> recipes;
    private List<Dish> allDishes;

    public RecipeFragment(List<String> recipes, List<Dish> allDishes) {
        this.recipes = recipes;
        this.allDishes = allDishes;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipes, container, false);

        TextView recipesTextView = view.findViewById(R.id.recipesTextView);
        LinearLayout recipesButtonsLayout = view.findViewById(R.id.recipesButtonsLayout);

        if (recipes.isEmpty()) {
            recipesTextView.setText("No recipes found with selected ingredients.");
        } else {
            //recipesTextView.setText("Recipes containing selected ingredients:");
            for (String recipe : recipes) {
                Button button = new Button(getContext());
                button.setText(recipe);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        for (Dish dish : allDishes) {
                            if (dish.getIngredient().equals(recipe)) {
                                Intent intent = new Intent(getActivity(), RecipeDetailActivity.class);
                                intent.putExtra("recipeName", dish.getIngredient());
                                intent.putStringArrayListExtra("ingredients", new ArrayList<>(dish.getAllIngredients()));
                                startActivity(intent);
                                break;
                            }
                        }
                    }
                });
                recipesButtonsLayout.addView(button);
            }
        }

        return view;
    }

    public void updateRecipesList(List<String> recipes) {
        this.recipes = recipes;
        if (getView() != null)
        {
            LinearLayout recipesButtonsLayout = getView().findViewById(R.id.recipesButtonsLayout);
            recipesButtonsLayout.removeAllViews();  // Clear existing buttons

            if (recipes.isEmpty()) {
                ((TextView) getView().findViewById(R.id.recipesTextView)).setText("No recipes found with selected ingredients.");
            } else {
                ((TextView) getView().findViewById(R.id.recipesTextView)).setText("Recipes containing selected ingredients:");
                for (String recipe : recipes) {
                    Button button = new Button(getContext());
                    button.setText(recipe);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            for (Dish dish : allDishes) {
                                if (dish.getIngredient().equals(recipe)) {
                                    Intent intent = new Intent(getActivity(), RecipeDetailActivity.class);
                                    intent.putExtra("recipeName", dish.getIngredient());
                                    intent.putStringArrayListExtra("ingredients", new ArrayList<>(dish.getAllIngredients()));
                                    startActivity(intent);
                                    break;
                                }
                            }
                        }
                    });
                    recipesButtonsLayout.addView(button);
                }
            }
        }
    }
}
