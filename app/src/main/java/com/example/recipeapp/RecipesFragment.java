package com.example.recipeapp;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.recipeapp.Adapters.RandomRecipeAdapter;
import com.example.recipeapp.Listeners.RandomRecipeResponseListener;
import com.example.recipeapp.Models.RandomRecipeApiResponse;


public class RecipesFragment extends Fragment {

    ProgressDialog dialog;
    RequestManager manager;
    RandomRecipeAdapter randomRecipeAdapter;
    RecyclerView recyclerView;

//        dialog = new ProgressDialog(this);
//        dialog.setTitle("loading..");
//        manager = new RequestManager(this);
//        manager.getRandomRecipe(randomRecipeResponseListener);
//        dialog.show();


    public RecipesFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        dialog = new ProgressDialog(getActivity());
//        dialog.setTitle("loading..");
//        manager = new RequestManager(getActivity());
//        manager.getRandomRecipe(randomRecipeResponseListener);
//        dialog.show();


    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dialog = new ProgressDialog(getActivity());
        dialog.setTitle("loading..");
        manager = new RequestManager(getActivity());
        manager.getRandomRecipe(randomRecipeResponseListener);
        dialog.show();
//        recyclerView.setAdapter(randomRecipeAdapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_recipes, container, false);
        recyclerView = view.findViewById(R.id.recycler_random);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity() , 1));
//        recyclerView.setAdapter(randomRecipeAdapter);

        return view;
    }

        private  final RandomRecipeResponseListener randomRecipeResponseListener = new RandomRecipeResponseListener() {


            @Override
            public void didFetch(RandomRecipeApiResponse response, String message) {
                dialog.dismiss();
//                recyclerView = findViewById(R.id.recycler_random);
//                recyclerView.setHasFixedSize(true);
//                recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this , 1));
                randomRecipeAdapter = new RandomRecipeAdapter(getActivity() , response.recipes);
                recyclerView.setAdapter(randomRecipeAdapter);
            }

            @Override
        public void didError(String message) {
            Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
        }
    };
}