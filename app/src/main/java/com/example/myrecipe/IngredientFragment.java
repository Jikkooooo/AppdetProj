package com.example.myrecipe;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

public class IngredientFragment extends Fragment {

    private List<String> ingredients;
    private Ingredients mainActivity;

    public IngredientFragment(List<String> ingredients, Ingredients mainActivity) {
        this.ingredients = ingredients;
        this.mainActivity = mainActivity;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ingredients, container, false);

        GridLayout ingredientsLayout = view.findViewById(R.id.ingredientsLayout);

        for (String ingredient : ingredients) {
            Button button = new Button(getContext());
            button.setText(ingredient);
            button.setTag(ingredient);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainActivity.toggleIngredient((String) v.getTag(), button);
                }
            });


            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = 0;
            params.height = GridLayout.LayoutParams.WRAP_CONTENT;
            params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1, 1f);
            button.setLayoutParams(params);

            ingredientsLayout.addView(button);
        }

        return view;
    }
}
