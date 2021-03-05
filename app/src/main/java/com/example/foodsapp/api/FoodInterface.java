package com.example.foodsapp.api;

import com.example.foodsapp.model.Categories;
import com.example.foodsapp.model.Meal;
import com.example.foodsapp.model.Meals;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FoodInterface {
    @GET("search.php")
    Call<Meals> getMeals(@Query("f") String keyword);

    @GET("categories.php")
    Call<Categories> getCategories();
}
