package com.example.recipeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recipeapp.Adapters.IngredientsAdapter;
import com.example.recipeapp.Adapters.InstructionsAdapter;
import com.example.recipeapp.Adapters.SimilarRecipeAdapter;
import com.example.recipeapp.Listeners.InstructionsListener;
import com.example.recipeapp.Listeners.RecipeClickListener;
import com.example.recipeapp.Listeners.RecipeDetailListener;
import com.example.recipeapp.Listeners.SimilarRecipesListener;
import com.example.recipeapp.Models.InstructionsResponse;
import com.example.recipeapp.Models.Recipe;
import com.example.recipeapp.Models.RecipeDetailResponse;
import com.example.recipeapp.Models.SimilarRecipeResponse;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Objects;

public class RecipeDetailActivity extends AppCompatActivity implements DBManager.DataBaseListener{

    int id;
    TextView textView_meal_name ,textView_meal_source, textView_meal_summary;
    ImageView imageView_meal_image;
    RecyclerView recycler_meal_ingredients,recycler_meal_similar,recycler_meal_instructions;
    RequestManager manager;
    ProgressDialog dialog;
    IngredientsAdapter ingredientsAdapter;
    SimilarRecipeAdapter similarRecipeAdapter;
    InstructionsAdapter instructionsAdapter;
    Recipe recipe;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

//        TOOLBAR

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);


        findViews();





id = Integer.parseInt(getIntent().getStringExtra("id"));
        manager = new RequestManager(this);
        manager.getRecipeDetails(recipeDetailListener , id);
        manager.getSimilarRecipes(similarRecipesListener,id);
        manager.getInstructions(instructionsListener , id);
        dialog = new ProgressDialog(this);
        dialog.setTitle("Loading Recipe Details");
        dialog.show();

    }

    private void findViews() {
        recipe = (Recipe) getIntent().getSerializableExtra("response");
        textView_meal_name = findViewById(R.id.textView_meal_name);
        textView_meal_source = findViewById(R.id.textView_meal_source);
        textView_meal_summary = findViewById(R.id.textView_meal_summary);
        imageView_meal_image = findViewById(R.id.imageView_meal_image);
        recycler_meal_ingredients = findViewById(R.id.recycler_meal_ingredients);
        recycler_meal_similar = findViewById(R.id.recycler_meal_similar);
        recycler_meal_instructions = findViewById(R.id.recycler_meal_instructions);
        //----------------------------//
        //----------------------------//
        //----------------------------//
//        ((MyApp)getApplication()).dbManager.getDB(this);
    }



    private final RecipeDetailListener recipeDetailListener = new RecipeDetailListener() {
        @Override
        public void didFetch(RecipeDetailResponse response, String message) {
dialog.dismiss();
textView_meal_name.setText(response.title);

textView_meal_source.setText(response.sourceName);
textView_meal_summary.setText(response.summary);
            Picasso.get().load(response.image).into(imageView_meal_image);
recycler_meal_ingredients.setHasFixedSize(true);
recycler_meal_ingredients.setLayoutManager(new LinearLayoutManager(RecipeDetailActivity.this,LinearLayoutManager.HORIZONTAL,false));
ingredientsAdapter= new IngredientsAdapter(RecipeDetailActivity.this,response.extendedIngredients);
recycler_meal_ingredients.setAdapter(ingredientsAdapter);
        }

        @Override
        public void didError(String message) {
            Toast.makeText(RecipeDetailActivity.this, message, Toast.LENGTH_SHORT).show();

        }
    };

    private final SimilarRecipesListener similarRecipesListener = new SimilarRecipesListener() {
        @Override
        public void didFetch(List<SimilarRecipeResponse> response, String message) {
            recycler_meal_similar.setHasFixedSize(true);
            recycler_meal_similar.setLayoutManager(new LinearLayoutManager(RecipeDetailActivity.this , LinearLayoutManager.HORIZONTAL,false));
            similarRecipeAdapter = new SimilarRecipeAdapter(RecipeDetailActivity.this , response,recipeClickListener);
            recycler_meal_similar.setAdapter(similarRecipeAdapter);
        }

        @Override
        public void didError(String message) {
            Toast.makeText(RecipeDetailActivity.this, message, Toast.LENGTH_SHORT).show();

        }
    };


    private final RecipeClickListener recipeClickListener = new RecipeClickListener() {
        @Override
        public void onRecipeClicked(String id) {
//            Toast.makeText(RecipeDetailActivity.this , id,Toast.LENGTH_SHORT).show();
            startActivity(new Intent(RecipeDetailActivity.this , RecipeDetailActivity.class).putExtra("id",id));



        }
    };

    private final InstructionsListener instructionsListener = new InstructionsListener() {
        @Override
        public void didFetch(List<InstructionsResponse> response, String message) {
recycler_meal_instructions.setHasFixedSize(true);
recycler_meal_instructions.setLayoutManager(new LinearLayoutManager(RecipeDetailActivity.this , LinearLayoutManager.VERTICAL , false));
instructionsAdapter = new InstructionsAdapter(RecipeDetailActivity.this , response);
recycler_meal_instructions.setAdapter(instructionsAdapter);
        }

        @Override
        public void didError(String message) {

        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.details_menu,menu);
       return true;
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.favorite_menu){

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Are you sure you want to save "+ textView_meal_name.getText()+ "to the Favorite List??");
//            Toast.makeText(this, "Are you sure you want to save "+textView_meal_name.getText() + "to the DB??", Toast.LENGTH_SHORT).show();
            builder.setNegativeButton("No",null);
            builder.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {


                    ((MyApp)getApplication()).dbManager.addToFavorite(recipe);
                }
            });
            builder.create().show();


        }
        return super.onOptionsItemSelected(item);

    }



    @Override
    public void insertingRecipeCompleted() {
        Toast.makeText(RecipeDetailActivity.this,"Recipe is successfully added to Favourite list",Toast.LENGTH_LONG).show();

    }

    @Override
    public void gettingRecipesCompleted(Recipe[] list) {

    }
    @Override
    public void alreadyinsertingRecipeCompleted() {
        Log.e("alreadyinserting::","ttt" );
        Toast.makeText(RecipeDetailActivity.this,"Already added",Toast.LENGTH_LONG).show();

    }



}