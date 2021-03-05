package com.example.foodsapp;

import android.content.Context;

import androidx.appcompat.app.AlertDialog;

import com.example.foodsapp.api.FoodClient;
import com.example.foodsapp.api.FoodInterface;

public class Utils {
    public static FoodInterface getApiClient() {
        FoodInterface foodInterface = FoodClient.getFoodClient().create(FoodInterface.class);
        return foodInterface;
    }

    public static AlertDialog showDialogMessage(Context context, String title, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .show();
        if (alertDialog.isShowing()) {
            alertDialog.cancel();
        }
        return alertDialog;
    }
}
