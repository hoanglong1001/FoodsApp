package com.example.foodsapp.view.home;

import android.icu.number.Scale;

import com.example.foodsapp.Utils;
import com.example.foodsapp.model.Categories;
import com.example.foodsapp.model.Category;
import com.example.foodsapp.model.Meals;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenter {
    HomeView homeView;

    public HomePresenter(HomeView homeView) {
        this.homeView = homeView;
    }

    public void getMealBanner() {
        homeView.showLoading();

        Call<Meals> call = Utils.getApiClient().getMeals("e");
        call.enqueue(new Callback<Meals>() {
            @Override
            public void onResponse(Call<Meals> call, Response<Meals> response) {
                homeView.hideLoading();
                if (response.isSuccessful() && response.body() != null) {
                    homeView.setBanner(response.body().getMeals());
                } else {
                    homeView.onErrorLoading(response.message());
                }
            }

            @Override
            public void onFailure(Call<Meals> call, Throwable t) {
                homeView.hideLoading();
                homeView.onErrorLoading(t.getMessage());
            }
        });
    }

    public void getMealCategories() {
        homeView.showLoading();

        Call<Categories> call = Utils.getApiClient().getCategories();
        call.enqueue(new Callback<Categories>() {
            @Override
            public void onResponse(Call<Categories> call, Response<Categories> response) {
                homeView.hideLoading();
                if (response.isSuccessful() && response.body() != null) {
                    homeView.setCategories(response.body().getCategories());
                } else {
                    homeView.onErrorLoading(response.message());
                }
            }

            @Override
            public void onFailure(Call<Categories> call, Throwable t) {
                homeView.hideLoading();
                homeView.onErrorLoading(t.getMessage());
            }
        });
    }
}
