package com.example.foodsapp.adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.foodsapp.model.Category;
import com.example.foodsapp.view.category.CategoryFragment;

import java.util.List;

public class ViewPagerCategoryAdapter extends FragmentPagerAdapter {

    public static final String CATEGORY_NAME = "category_name";
    public static final String CATEGORY_IMG = "category_img";
    public static final String CATEGORY_DES = "category_des";

    private List<Category> categories;

    public ViewPagerCategoryAdapter(@NonNull FragmentManager fm, int behavior, List<Category> categories) {
        super(fm, behavior);
        this.categories = categories;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        CategoryFragment categoryFragment = new CategoryFragment();
        Bundle bundle = new Bundle();
        bundle.putString(CATEGORY_NAME, categories.get(position).getStrCategory());
        bundle.putString(CATEGORY_IMG, categories.get(position).getStrCategoryThumb());
        bundle.putString(CATEGORY_DES, categories.get(position).getStrCategoryDescription());
        categoryFragment.setArguments(bundle);
        return categoryFragment;
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return categories.get(position).getStrCategory();
    }
}
