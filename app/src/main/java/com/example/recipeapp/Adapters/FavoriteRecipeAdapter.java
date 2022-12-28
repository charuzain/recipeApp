package com.example.recipeapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipeapp.Listeners.RecipeClickListener;
import com.example.recipeapp.Models.Recipe;
import com.example.recipeapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FavoriteRecipeAdapter extends RecyclerView.Adapter<FavoriteRecipeViewHolder> {
    Context context;
    public ArrayList<Recipe> list;
//    RecipeClickListener listener;

    public FavoriteRecipeAdapter(Context context, ArrayList<Recipe> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public FavoriteRecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FavoriteRecipeViewHolder(LayoutInflater.from(context).inflate(R.layout.favorite_recipe_row_ayout,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteRecipeViewHolder holder, int position) {
holder.favorite_title_textView.setText(list.get(position).title);
holder.favorite_title_textView.setSelected(true);
holder.favorite_heart_textView.setText(list.get(position).aggregateLikes+" Likes");
holder.favorite_description_textView.setText(list.get(position).summary);
holder. favorite_clock_textView.setText(list.get(position).readyInMinutes+" mins");
holder.favorite_serving_textView.setText(list.get(position).servings+" Servings");

        Picasso.get().load(list.get(position).image).into(holder. favorite_recipe_imageView );

//        holder.favorite_row_cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                listener.onRecipeClicked(String.valueOf(list.get(holder.getAdapterPosition()).id));
//            }
//        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class FavoriteRecipeViewHolder extends RecyclerView.ViewHolder{
    CardView favorite_row_cardView;
    ImageView favorite_recipe_imageView,favorite_heart_imageView,favorite_clock_imageView,favorite_serving_imageView;
    TextView favorite_title_textView,favorite_description_textView,favorite_heart_textView,
            favorite_clock_textView,favorite_serving_textView;

    public FavoriteRecipeViewHolder(@NonNull View itemView) {

        super(itemView);
        favorite_row_cardView  = itemView.findViewById(R.id.favorite_row_cardView);
        favorite_recipe_imageView = itemView.findViewById(R.id.favorite_recipe_imageView);
        favorite_heart_imageView = itemView.findViewById(R.id.favorite_heart_imageView);
        favorite_clock_imageView = itemView.findViewById(R.id.favorite_clock_imageView);
        favorite_serving_imageView = itemView.findViewById(R.id.favorite_serving_imageView);
        favorite_description_textView = itemView.findViewById(R.id.favorite_description_textView);
        favorite_title_textView = itemView.findViewById(R.id.favorite_title_textView);
        favorite_heart_textView = itemView.findViewById(R.id.favorite_heart_textView);
        favorite_clock_textView = itemView.findViewById(R.id.favorite_clock_textView);
        favorite_serving_textView = itemView.findViewById(R.id.favorite_serving_textView);





    }
}