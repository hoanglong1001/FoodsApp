package com.example.foodsapp.view.detail;

import com.example.foodsapp.Utils;
import com.example.foodsapp.model.Meals;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailPresenter {
    private DetailView view;

    public DetailPresenter(DetailView view) {
        this.view = view;
    }

    public void setDetailMeal(String mealName) {
        view.showLoading();
        Call<Meals> call = Utils.getApiClient().getMealByName(mealName);
        call.enqueue(new Callback<Meals>() {
            @Override
            public void onResponse(Call<Meals> call, Response<Meals> response) {
                view.hideLoading();
                if (response.isSuccessful() && response.body() != null) {
                    view.setMeal(response.body().getMeals().get(0));
                } else {
                    view.onErrorLoading(response.message());
                }
            }

            @Override
            public void onFailure(Call<Meals> call, Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getMessage());
            }
        });
    }
}
