package com.example.recipeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
//import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bnView;

    RecipesFragment recipeFragment = new RecipesFragment();
    FavoriteRecipeFragment favoriteFragment = new FavoriteRecipeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}