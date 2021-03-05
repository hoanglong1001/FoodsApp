package com.example.foodsapp.view.home;

import com.example.foodsapp.model.Categories;
import com.example.foodsapp.model.Category;
import com.example.foodsapp.model.Meal;
import com.example.foodsapp.model.Meals;

import java.util.List;

public interface HomeView {
    void showLoading();
    void hideLoading();
    void setBanner(List<Meal> meals);
    void setCategories(List<Category> categories);
    void onErrorLoading(String message);
}
