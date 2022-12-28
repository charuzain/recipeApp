package com.example.recipeapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.TypeConverters;

import com.example.recipeapp.Models.Recipe;


@Dao
public interface RecipesDAO {

    @Insert
    void addNewFavRecipe(Recipe recipe);

    @Query("select * from Recipe")
    Recipe[] getAllReceipes();

    @Delete
    void deleteACity(Recipe dc);

}


