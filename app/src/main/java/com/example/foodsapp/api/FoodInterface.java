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

    @GET("filter.php")
    Call<Meals> getMealsCategory(@Query("c") String category);

    @GET("search.php")
    Call<Meals> getMealByName(@Query("s") String name);
}
