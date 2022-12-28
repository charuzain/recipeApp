package com.example.recipeapp;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import androidx.room.Room;

import com.example.recipeapp.Models.Recipe;

public class DBManager {

    interface DataBaseListener {
        void insertingRecipeCompleted();

        void alreadyinsertingRecipeCompleted();

        void gettingRecipesCompleted(Recipe[] list);
    }

    DataBaseListener listener;

    ReceipeDatabase recipeDB;
    Handler dbHandler = new Handler(Looper.getMainLooper());

    ReceipeDatabase getDB(Context context) {
        if (recipeDB == null)
            recipeDB = Room.databaseBuilder(context, ReceipeDatabase.class, "recipe_db").build();

        return recipeDB;
    }

    void addToFavorite(Recipe t) {

        MyApp.executorService.execute(new Runnable() {
            @Override
            public void run() {
                Recipe[] list = recipeDB.getDao().getAllReceipes();


                boolean flag = false;
                for (int i = 0; i < list.length; i++) {
                    if (list[i].title.equals(t.title)) {
                        flag = true;
                        dbHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                // notify main thread
                                listener.alreadyinsertingRecipeCompleted();
                            }
                        });
                        break;
                    }
                }
                if (!flag) {
                    recipeDB.getDao().addNewFavRecipe(t);
                    dbHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            // notify main thread
                            listener.insertingRecipeCompleted();
                        }
                    });

                }


            }
        });
    }

    void getAllReceipes() {
        MyApp.executorService.execute(new Runnable() {
            @Override
            public void run() {
                Recipe[] list = recipeDB.getDao().getAllReceipes();
                dbHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        // notify main thread
                        listener.gettingRecipesCompleted(list);
                    }
                });
            }
        });
    }
}
