package com.example.recipeapp.Listeners;

import com.example.recipeapp.Models.RecipeDetailResponse;
import com.example.recipeapp.Models.SimilarRecipeResponse;

import java.util.List;

public interface SimilarRecipesListener {
    void didFetch(List<SimilarRecipeResponse> response , String message);
    void didError(String message);
}
