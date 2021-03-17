package com.example.foodsapp.view.category;

import com.example.foodsapp.model.Category;
import com.example.foodsapp.model.Meal;

import java.util.List;

public interface CategoryView {
    void showLoading();
    void hideLoading();
    void setMealCategory(List<Meal> meals);
    void onErrorLoading(String message);
}
