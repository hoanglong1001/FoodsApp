package com.example.foodsapp.view.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodsapp.R;
import com.example.foodsapp.Utils;
import com.example.foodsapp.adapter.RecyclerViewMealAdapter;
import com.example.foodsapp.adapter.ViewPagerHomeAdapter;
import com.example.foodsapp.model.Category;
import com.example.foodsapp.model.Meal;
import com.example.foodsapp.model.Meals;
import com.example.foodsapp.view.category.CategoryActivity;
import com.example.foodsapp.view.detail.DetailActivity;
import com.example.foodsapp.view.detail.DetailPresenter;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity implements HomeView {

    public static final String CATEGORIES = "categories";
    public static final String POSITION = "position";
    public static final String MEALNAME = "meal_name";

    @BindView(R.id.viewpagerBanner)
    ViewPager viewPagerBanner;
    @BindView(R.id.rv_meal_category)
    RecyclerView rvMealCategory;
    @BindView(R.id.shimmer_viewpager)
    View shimmerViewpagerBanner;
    @BindView(R.id.ll_shimmer_recyclerview)
    View shimmerRvMeal;

    HomePresenter homePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        homePresenter = new HomePresenter(this);
        homePresenter.getMealBanner();
        homePresenter.getMealCategories();
    }

    @Override
    public void showLoading() {
        shimmerRvMeal.setVisibility(View.VISIBLE);
        shimmerViewpagerBanner.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        shimmerRvMeal.setVisibility(View.GONE);
        shimmerViewpagerBanner.setVisibility(View.GONE);
    }

    @Override
    public void setBanner(List<Meal> meals) {
        ViewPagerHomeAdapter viewPagerHomeAdapter = new ViewPagerHomeAdapter(meals, this);
        viewPagerBanner.setAdapter(viewPagerHomeAdapter);
        viewPagerBanner.setPadding(20, 0, 100, 0);
        viewPagerHomeAdapter.notifyDataSetChanged();
        viewPagerHomeAdapter.setOnItemClickListener(new ViewPagerHomeAdapter.onItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                TextView mealName = view.findViewById(R.id.tv_banner);
                Intent intent = new Intent(HomeActivity.this, DetailActivity.class);
                intent.putExtra(MEALNAME, mealName.getText().toString());
                startActivity(intent);
            }
        });
    }

    @Override
    public void setCategories(List<Category> categories) {
        RecyclerViewMealAdapter recyclerViewMealAdapter = new RecyclerViewMealAdapter(this, categories);
        rvMealCategory.setLayoutManager(new GridLayoutManager(this, 3, RecyclerView.VERTICAL, false));
        rvMealCategory.setAdapter(recyclerViewMealAdapter);
        rvMealCategory.setHasFixedSize(true);
        recyclerViewMealAdapter.notifyDataSetChanged();
        recyclerViewMealAdapter.setOnItemClickedListener(new RecyclerViewMealAdapter.onItemClickedListener() {
            @Override
            public void onClicked(View view, int position) {
                Intent intent = new Intent(HomeActivity.this, CategoryActivity.class);
                intent.putExtra(CATEGORIES, (Serializable) categories);
                intent.putExtra(POSITION, position);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onErrorLoading(String message) {
        Utils.showDialogMessage(this, "Error", message);
    }
}