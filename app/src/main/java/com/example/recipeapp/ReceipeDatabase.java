package com.example.recipeapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.recipeapp.Models.Recipe;

@Database(version = 1,entities = {Recipe.class})
@TypeConverters(RecipeTypeConvertor.class)
public abstract class ReceipeDatabase extends RoomDatabase {

    public abstract RecipesDAO getDao();
}


