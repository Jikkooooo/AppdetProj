package com.example.myrecipe;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DataEntryActivity extends AppCompatActivity {

    private EditText editTextRecipeName;
    private EditText editTextProcedure;
    private EditText editTextImage;
    private Button buttonAddRecipe;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry);

        editTextRecipeName = findViewById(R.id.editTextRecipeName);
        editTextProcedure = findViewById(R.id.editTextProcedure);
        editTextImage = findViewById(R.id.editTextImage);
        buttonAddRecipe = findViewById(R.id.buttonAddRecipe);

        dbHelper = new DBHelper(this);

        buttonAddRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String recipeName = editTextRecipeName.getText().toString();
                String procedure = editTextProcedure.getText().toString();
                String image = editTextImage.getText().toString();

                if (!recipeName.isEmpty() && !procedure.isEmpty() && !image.isEmpty()) {
                    addRecipeToDatabase(recipeName, procedure, image);
                    Toast.makeText(DataEntryActivity.this, "Recipe added successfully", Toast.LENGTH_SHORT).show();
                    clearFields();
                } else {
                    Toast.makeText(DataEntryActivity.this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void addRecipeToDatabase(String recipeName, String procedure, String image) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBHelper.TABLE1_COLUMN_DISH, recipeName);
        values.put(DBHelper.TABLE1_COLUMN_RECIPE, procedure);
        values.put(DBHelper.TABLE1_COLUMN_IMG, image);
        db.insert(DBHelper.TABLE1_NAME, null, values);
    }

    private void clearFields() {
        editTextRecipeName.setText("");
        editTextProcedure.setText("");
        editTextImage.setText("");
    }
}
