package com.example.myrecipe;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "RecipeDatabase.db";
    private static final int DATABASE_VERSION = 1;

    //Table 1
    static final String TABLE1_NAME = "my_recipe";
    private static final String TABLE1_COLUMN_ID = "_id";
    static final String TABLE1_COLUMN_DISH = "recipe_name";
    static final String TABLE1_COLUMN_RECIPE = "procedure";
    static final String TABLE1_COLUMN_IMG = "img";

    //Table 2
    static final String TABLE2_NAME = "users";
    private static final String TABLE2_COLUMN_ID = "_id";
    static final String TABLE2_COLUMN_UNAME = "uname";
    static final String TABLE2_COLUMN_PW = "password";

    //Table 3
    static final String TABLE3_NAME = "ingredient_list";
    private static final String TABLE3_COLUMN_ID = "_id";
    static final String TABLE3_COLUMN_NAME = "ingredient";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable1 = "CREATE TABLE " + TABLE1_NAME + " (" +
                TABLE1_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TABLE1_COLUMN_DISH + " TEXT, " +
                TABLE1_COLUMN_IMG + " TEXT ," +
                TABLE1_COLUMN_RECIPE + " TEXT)";
        db.execSQL(createTable1);

        String createTable2 = "CREATE TABLE " + TABLE2_NAME + " (" +
                TABLE2_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TABLE2_COLUMN_UNAME + " TEXT, " +
                TABLE2_COLUMN_PW + " TEXT)";
        db.execSQL(createTable2);

        String createTable3 = "CREATE TABLE " + TABLE3_NAME + " (" +
                TABLE3_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TABLE3_COLUMN_NAME + " TEXT)";
        db.execSQL(createTable3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE1_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE2_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE3_NAME);
        onCreate(db);
    }

    public ArrayList<String> getAllIngredients() {
        ArrayList<String> ingredients = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE3_NAME, null);

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String ingredient = cursor.getString(cursor.getColumnIndex(TABLE3_COLUMN_NAME));
                ingredients.add(ingredient);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return ingredients;
    }

    // Method to add a ingredients name to the database
    public void addIngredient(String ingredient) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TABLE3_COLUMN_NAME, ingredient);

        db.insert(TABLE3_NAME, null, values);
        db.close();
    }

    /*//PARA SA ADD NG DETAILS SA DATABASE TABLE
    public void addRecipe(String dish, String recipe, String img) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_DISH, dish);
        contentValues.put(COLUMN_RECIPE, recipe);
        contentValues.put(COLUMN_IMG, img);

        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
        } else {
        }
    }

//PARA MAGDROP NG TABLE
    public void deleteTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }*/
}
