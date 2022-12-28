package com.example.recipeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentTransaction;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
//import android.view.View;

import com.example.recipeapp.Adapters.RandomRecipeAdapter;
import com.example.recipeapp.Listeners.RandomRecipeResponseListener;
import com.example.recipeapp.Models.RandomRecipeApiResponse;
import com.example.recipeapp.Models.Recipe;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements DBManager.DataBaseListener {
//ProgressDialog dialog;
//RequestManager manager;
//RandomRecipeAdapter randomRecipeAdapter;
//RecyclerView recyclerView;

    BottomNavigationView bnView;

    RecipesFragment recipeFragment = new RecipesFragment();
    FavoriteRecipeFragment favoriteFragment = new FavoriteRecipeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ((MyApp) getApplication()).dbManager.listener = this;
//
//        ((MyApp)getApplication()).dbManager.getDB(this);

        // new code
//        dialog = new ProgressDialog(this);
//        dialog.setTitle("loading..");
//        manager = new RequestManager(this);
//        manager.getRandomRecipe(randomRecipeResponseListener);
//        dialog.show();


        bnView = findViewById(R.id.bottomNavigationView);


        getSupportFragmentManager().beginTransaction().replace(R.id.navHostFragment , recipeFragment).commit();

        bnView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.recipesFragment) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.navHostFragment, recipeFragment).commit();
                    return true;
                }

                if (item.getItemId() == R.id.favoriteRecipeFragment) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.navHostFragment, favoriteFragment).commit();
                    return true;
                }

                return false;
            }


        });







//bnView.setSelectedItemId(R.id.recipesFragment);


    }

    @Override
    public void insertingRecipeCompleted() {

    }

    @Override
    public void alreadyinsertingRecipeCompleted() {

    }

    @Override
    public void gettingRecipesCompleted(Recipe[] list) {

    }

//    private  final RandomRecipeResponseListener randomRecipeResponseListener = new RandomRecipeResponseListener() {
//        @Override
//        public void didFetch(RandomRecipeApiResponse response, String message) {
//            dialog.dismiss();
//            recyclerView = findViewById(R.id.recycler_random);
//            recyclerView.setHasFixedSize(true);
//            recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this , 1));
//            randomRecipeAdapter = new RandomRecipeAdapter(MainActivity.this , response.recipes);
//            recyclerView.setAdapter(randomRecipeAdapter);
//        }
//
//        @Override
//        public void didError(String message) {
//            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
//        }
//    };
}