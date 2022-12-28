package com.example.recipeapp;

import android.app.Application;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyApp extends Application {
//    public static Executor executorService;

    static ExecutorService executorService = Executors.newFixedThreadPool(4);
    DBManager dbManager = new DBManager();

}
