package com.example.recipeapp;

import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.example.recipeapp.Models.AnalyzedInstruction;
import com.example.recipeapp.Models.ExtendedIngredient;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class RecipeTypeConvertor {
@TypeConverter

public static ArrayList<String> fromString(String value) {
    Type listType = new TypeToken<ArrayList<String>>() {}.getType();
    return new Gson().fromJson(value, listType);
}
    @TypeConverter
    public static String fromArrayList(ArrayList<String> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

    public static Object toString(String value) {
        Type listType = new TypeToken<Object>() {}.getType();
        return new Gson().fromJson(value, listType);
    }
    @TypeConverter
    public static String toObject(Object list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }


    @TypeConverter
    public String fromValuesList(ArrayList<ExtendedIngredient> value) {
        if (value== null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<ExtendedIngredient>>() {}.getType();
        return gson.toJson(value, type);
    }

    @TypeConverter
    public ArrayList<ExtendedIngredient> toOptionValuesList(String value) {
        ArrayList<ExtendedIngredient> result = null;
        if (value != null) {
            Gson gson = new Gson();
            Type type = new TypeToken<List<ExtendedIngredient>>() {
            }.getType();
            result = gson.fromJson(value, type);
        }
        return result;
    }

//
    @TypeConverter
    public String fromValuesToAnalysedList(ArrayList<AnalyzedInstruction> value) {
        if (value== null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<AnalyzedInstruction>>() {}.getType();
        return gson.toJson(value, type);
    }

    @TypeConverter
    public ArrayList<AnalyzedInstruction> toOptionValueList(String value) {
        if (value== null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<AnalyzedInstruction>>() {
        }.getType();
        return gson.fromJson(value, type);
    }


    @TypeConverter
    public String fromValuesToList(ArrayList<Object> value) {
        if (value== null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Object>>() {}.getType();
        return gson.toJson(value, type);
    }

    @TypeConverter
    public ArrayList<Object> toOptionValues(String value) {
        ArrayList<Object> result = null;
        if (value != null) {
            Gson gson = new Gson();
            Type type = new TypeToken<List<AnalyzedInstruction>>() {
            }.getType();
            result = gson.fromJson(value, type);
        }
        return result;
    }



}
