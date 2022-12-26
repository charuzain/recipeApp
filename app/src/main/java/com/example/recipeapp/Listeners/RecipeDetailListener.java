package com.example.recipeapp.Listeners;

import com.example.recipeapp.Models.RecipeDetailResponse;

public interface RecipeDetailListener {
    void didFetch(RecipeDetailResponse response , String message);
    void didError(String message);
}
