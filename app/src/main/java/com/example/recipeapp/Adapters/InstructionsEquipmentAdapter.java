package com.example.recipeapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipeapp.Models.Equipment;
import com.example.recipeapp.Models.Ingredient;
import com.example.recipeapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class InstructionsEquipmentAdapter extends RecyclerView.Adapter<InstructionsEquipmentAdapterViewHolder> {

    Context context;
    List<Equipment> list;

    public InstructionsEquipmentAdapter(Context context, List<Equipment> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public InstructionsEquipmentAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InstructionsEquipmentAdapterViewHolder(LayoutInflater.from(context).inflate(R.layout.list_instructions_step_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull InstructionsEquipmentAdapterViewHolder holder, int position) {
        holder.textView_instructions_step_item.setText(list.get(position).name);
        holder.textView_instructions_step_item.setSelected(true);
//        Picasso.get().load("https://spoonacular.com/cdn/ingredients_100x100/"+list.get(position).image).into(holder.imageView_instructions_step_item);
        Picasso.get().load("https://spoonacular.com/cdn/equipment_100x100/"+list.get(position).image).into(holder.imageView_instructions_step_item);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}


class InstructionsEquipmentAdapterViewHolder extends RecyclerView.ViewHolder{
    TextView textView_instructions_step_item;
    ImageView imageView_instructions_step_item;

    public InstructionsEquipmentAdapterViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView_instructions_step_item = itemView.findViewById(R.id.imageView_instructions_step_item);
        textView_instructions_step_item = itemView.findViewById(R.id.textView_instructions_step_item);
    }
}