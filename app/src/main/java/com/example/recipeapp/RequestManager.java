package com.example.recipeapp;

import android.content.Context;

import com.example.recipeapp.Listeners.RandomRecipeResponseListener;
import com.example.recipeapp.Listeners.RecipeDetailListener;
import com.example.recipeapp.Listeners.SimilarRecipesListener;
import com.example.recipeapp.Models.RandomRecipeApiResponse;
import com.example.recipeapp.Models.RecipeDetailResponse;
import com.example.recipeapp.Models.SimilarRecipeResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class RequestManager {

    Context context;
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.spoonacular.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public RequestManager(Context context) {
        this.context = context;
    }

    // GET RANDOM RECIPES
    public void getRandomRecipe(RandomRecipeResponseListener listener , List<String> tags) {
        CallRandomRecipe callRandomRecipes = retrofit.create(CallRandomRecipe.class);
        Call<RandomRecipeApiResponse> call = callRandomRecipes.callRandomRecipe(context.getString(R.string.api_key), "8",tags);
        call.enqueue(new Callback<RandomRecipeApiResponse>() {
            @Override
            public void onResponse(Call<RandomRecipeApiResponse> call, Response<RandomRecipeApiResponse> response) {
                if (!response.isSuccessful()) {
                    listener.didError(response.message());
                    return;
                }
                listener.didFetch(response.body(), response.message());
            }

            @Override
            public void onFailure(Call<RandomRecipeApiResponse> call, Throwable t) {
                listener.didError(t.getMessage());
            }
        });


    }

    public void getRecipeDetails(RecipeDetailListener listener , int id){
        CallRecipeDetails callRecipeDetails = retrofit.create(CallRecipeDetails.class);
        Call<RecipeDetailResponse> call = callRecipeDetails.callRecipeDetails(id , context.getString(R.string.api_key));
        call.enqueue(new Callback<RecipeDetailResponse>() {
            @Override
            public void onResponse(Call<RecipeDetailResponse> call, Response<RecipeDetailResponse> response) {
                if (!response.isSuccessful()) {
                    listener.didError(response.message());
                    return;
                }
                listener.didFetch(response.body(), response.message());
            }

            @Override
            public void onFailure(Call<RecipeDetailResponse> call, Throwable t) {
                listener.didError(t.getMessage());

            }
        });
    }



    public void getSimilarRecipes(SimilarRecipesListener listener, int id){
    CallSimilarRecipes callSimilarRecipes = retrofit.create(CallSimilarRecipes.class);
    Call<List<SimilarRecipeResponse>> call = callSimilarRecipes.callSimilarRecipe(id,"4",context.getString(R.string.api_key));
    call.enqueue(new Callback<List<SimilarRecipeResponse>>() {
        @Override
        public void onResponse(Call<List<SimilarRecipeResponse>> call, Response<List<SimilarRecipeResponse>> response) {
            if (!response.isSuccessful()) {
                listener.didError(response.message());
                return;
            }
            listener.didFetch(response.body(), response.message());
        }

        @Override
        public void onFailure(Call<List<SimilarRecipeResponse>> call, Throwable t) {
            listener.didError(t.getMessage());

        }
    });
    }




    // Create Model call for API Response
    //Create interface for Random Recipe API Call

    //Interface
    private interface CallRandomRecipe {
        @GET("recipes/random")
        Call<RandomRecipeApiResponse> callRandomRecipe(
                @Query("apiKey") String apiKey,
                @Query("number") String number,
                @Query("tags") List<String> tags

        );

    }

    private interface CallRecipeDetails {
        @GET("recipes/{id}/information")
        Call<RecipeDetailResponse> callRecipeDetails(
                @Path("id") int id,
                @Query("apiKey") String apiKey
//                @Query("number") String number,
//                @Query("tags") List<String> tags

        );

    }

//    recipes/{id}/similar

    private interface CallSimilarRecipes{
        @GET("recipes/{id}/similar")
        Call<List<SimilarRecipeResponse>> callSimilarRecipe(
                @Path("id") int id,
                @Query("number") String number,
                @Query("apiKey") String apiKey
        );
    }

}
