package com.example.foodsapp.view.category;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.foodsapp.R;
import com.example.foodsapp.adapter.ViewPagerCategoryAdapter;
import com.example.foodsapp.model.Category;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.foodsapp.view.home.HomeActivity.CATEGORIES;
import static com.example.foodsapp.view.home.HomeActivity.POSITION;

public class CategoryActivity extends AppCompatActivity {

    @BindView(R.id.toolbarCategory)
    Toolbar toolbarCategory;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPagerCategory)
    ViewPager viewPagerCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        ButterKnife.bind(this);

        setupToolbar();
        initViewPager();
    }

    private void initViewPager() {
        Intent intent = getIntent();
        if (intent != null) {
            List<Category> categories = (List<Category>) intent.getSerializableExtra(CATEGORIES);
            int position = intent.getIntExtra(POSITION, 0);
            ViewPagerCategoryAdapter adapter = new ViewPagerCategoryAdapter(getSupportFragmentManager(),
                    FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, categories);
            viewPagerCategory.setAdapter(adapter);
            tabLayout.setupWithViewPager(viewPagerCategory);
            viewPagerCategory.setCurrentItem(position);
            adapter.notifyDataSetChanged();
        }
    }

    private void setupToolbar() {
        setSupportActionBar(toolbarCategory);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Category");
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return true;
        }
    }
}