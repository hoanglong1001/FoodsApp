package com.example.foodsapp.view.detail;

import com.example.foodsapp.model.Meal;

public interface DetailView {
    void hideLoading();
    void showLoading();
    void setMeal(Meal meal);
    void onErrorLoading(String message);
}
