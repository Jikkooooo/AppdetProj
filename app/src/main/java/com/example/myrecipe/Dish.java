package com.example.myrecipe;

import java.util.List;
public class Dish {
    private String ingredient;
    private List<String> ingredients;

    public Dish(String ingredient, List<String> ingredients) {
        this.ingredient = ingredient;
        this.ingredients = ingredients;
    }
    public String getIngredient() {
        return ingredient;
    }
    public List<String> getAllIngredients() {
        return ingredients;
    }
}
