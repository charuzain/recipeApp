package com.example.recipeapp.Models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.ArrayList;

@Entity
public class Recipe implements Parcelable, Serializable {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String title;
    public String summary;
    public boolean vegetarian;
    public boolean vegan;
    public boolean glutenFree;
    public boolean dairyFree;
    public boolean veryHealthy;
    public boolean cheap;
    public boolean veryPopular;
    public boolean sustainable;
    public boolean lowFodmap;
    public int weightWatcherSmartPoints;
    public String gaps;
    public int preparationMinutes;
    public int cookingMinutes;
    public int aggregateLikes;
    public int healthScore;
    public String creditsText;
    public String license;
    public String sourceName;
    public double pricePerServing;
    public ArrayList<String> diets;
    public ArrayList<ExtendedIngredient> extendedIngredients;

    public int readyInMinutes;
    public int servings;
    public String sourceUrl;
    public String image;
    public String imageType;


    public ArrayList<String> dishTypes;

    public ArrayList<String> occasions;
    public String instructions;
    public ArrayList<AnalyzedInstruction> analyzedInstructions;
    public ArrayList<Object> cuisines;
    public Object originalId;
    public String spoonacularSourceUrl;

    public Recipe(int id, String title, String summary, boolean vegetarian, boolean vegan, boolean glutenFree, boolean dairyFree, boolean veryHealthy, boolean cheap, boolean veryPopular, boolean sustainable, boolean lowFodmap, int weightWatcherSmartPoints, String gaps, int preparationMinutes, int cookingMinutes, int aggregateLikes, int healthScore, String creditsText, String license, String sourceName, double pricePerServing, ArrayList<String> diets, ArrayList<ExtendedIngredient> extendedIngredients, int readyInMinutes, int servings, String sourceUrl, String image, String imageType, ArrayList<String> dishTypes, ArrayList<String> occasions, String instructions, ArrayList<AnalyzedInstruction> analyzedInstructions, ArrayList<Object> cuisines, Object originalId, String spoonacularSourceUrl) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.vegetarian = vegetarian;
        this.vegan = vegan;
        this.glutenFree = glutenFree;
        this.dairyFree = dairyFree;
        this.veryHealthy = veryHealthy;
        this.cheap = cheap;
        this.veryPopular = veryPopular;
        this.sustainable = sustainable;
        this.lowFodmap = lowFodmap;
        this.weightWatcherSmartPoints = weightWatcherSmartPoints;
        this.gaps = gaps;
        this.preparationMinutes = preparationMinutes;
        this.cookingMinutes = cookingMinutes;
        this.aggregateLikes = aggregateLikes;
        this.healthScore = healthScore;
        this.creditsText = creditsText;
        this.license = license;
        this.sourceName = sourceName;
        this.pricePerServing = pricePerServing;
        this.diets = diets;
        this.extendedIngredients = extendedIngredients;
        this.readyInMinutes = readyInMinutes;
        this.servings = servings;
        this.sourceUrl = sourceUrl;
        this.image = image;
        this.imageType = imageType;
        this.dishTypes = dishTypes;
        this.occasions = occasions;
        this.instructions = instructions;
        this.analyzedInstructions = analyzedInstructions;
        this.cuisines = cuisines;
        this.originalId = originalId;
        this.spoonacularSourceUrl = spoonacularSourceUrl;
    }

    protected Recipe(Parcel in) {
        vegetarian = in.readByte() != 0;
        vegan = in.readByte() != 0;
        glutenFree = in.readByte() != 0;
        dairyFree = in.readByte() != 0;
        veryHealthy = in.readByte() != 0;
        cheap = in.readByte() != 0;
        veryPopular = in.readByte() != 0;
        sustainable = in.readByte() != 0;
        lowFodmap = in.readByte() != 0;
        weightWatcherSmartPoints = in.readInt();
        gaps = in.readString();
        preparationMinutes = in.readInt();
        cookingMinutes = in.readInt();
        aggregateLikes = in.readInt();
        healthScore = in.readInt();
        creditsText = in.readString();
        license = in.readString();
        sourceName = in.readString();
        pricePerServing = in.readDouble();
        id = in.readInt();
        title = in.readString();
        readyInMinutes = in.readInt();
        servings = in.readInt();
        sourceUrl = in.readString();
        image = in.readString();
        imageType = in.readString();
        summary = in.readString();
        dishTypes = in.createStringArrayList();
        diets = in.createStringArrayList();
        occasions = in.createStringArrayList();
        instructions = in.readString();
        spoonacularSourceUrl = in.readString();
    }

    public static final Creator<Recipe> CREATOR = new Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeString(summary);
        parcel.writeString(image);
    }


}
