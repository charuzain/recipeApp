package com.example.recipeapp.Listeners;

import com.example.recipeapp.Models.InstructionsResponse;
import com.example.recipeapp.Models.RandomRecipeApiResponse;

import java.util.List;

public interface InstructionsListener {

    void didFetch(List<InstructionsResponse> response, String message);
    void didError(String message);
}
