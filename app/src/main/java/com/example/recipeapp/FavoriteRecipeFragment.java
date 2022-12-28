package com.example.recipeapp;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recipeapp.Adapters.FavoriteRecipeAdapter;
import com.example.recipeapp.Models.Recipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;


public class FavoriteRecipeFragment extends Fragment  implements DBManager.DataBaseListener {
    TextView no_data_textView;
    ImageView no_data_imageView;
    RecyclerView favoriteRecipeRecyclerView;
    ArrayList<Recipe> recipe_list = new ArrayList<>(0);
    ProgressDialog dialog;
    FavoriteRecipeAdapter favoriteRecipeAdapter;

    public FavoriteRecipeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment FavoriteRecipeFragment.
     */
    // TODO: Rename and change types and number of parameters
//    public static FavoriteRecipeFragment newInstance(String param1, String param2) {
//        FavoriteRecipeFragment fragment = new FavoriteRecipeFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        setContentView(R.layout.fragment_favorite_recipe);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Favorite recipe");

//        setContentView(R.layout.fragment_favorite_recipe);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_favorite_recipe, container, false);

        favoriteRecipeRecyclerView = view.findViewById(R.id.favoriteRecipeRecyclerView);
favoriteRecipeAdapter = new FavoriteRecipeAdapter(getActivity(),recipe_list);

favoriteRecipeRecyclerView.setAdapter(favoriteRecipeAdapter);
        favoriteRecipeRecyclerView.setHasFixedSize(true);
        favoriteRecipeRecyclerView.setLayoutManager(new GridLayoutManager(getActivity() , 1));
        no_data_textView = view.findViewById(R.id.no_data_textView);
//favoriteRecipeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;

    }

    @Override
    public void onResume() {
        super.onResume();
//        ((MyApp) requireContext()).dbManager.getDB(getActivity());
//        ((MyApp) getContext()).dbManager.getAllReceipes();
//        ((MyApp) getContext()).dbManager.listener = this;

    }

    @Override
    public void insertingRecipeCompleted() {
        Toast.makeText(getActivity(),"Recipe is successfully added to Favourite list",Toast.LENGTH_LONG).show();

    }

    @Override
    public void alreadyinsertingRecipeCompleted() {
        Log.e("alreadyinserting::","ttt" );
        Toast.makeText(getActivity(),"Already added",Toast.LENGTH_LONG).show();
    }

    @Override
    public void gettingRecipesCompleted(Recipe[] list) {
//        recipe_list = new ArrayList( Arrays.asList(list));
//        if(recipe_list.size() == 0){
//            no_data_textView.setVisibility(View.VISIBLE);
//            favoriteRecipeRecyclerView.setVisibility(View.GONE);
//        }else{
//            no_data_textView.setVisibility(View.GONE);
//            favoriteRecipeRecyclerView.setVisibility(View.VISIBLE);
//        }
//       favoriteRecipeAdapter.list = recipe_list;
//       favoriteRecipeAdapter.notifyDataSetChanged();
    }

    }
