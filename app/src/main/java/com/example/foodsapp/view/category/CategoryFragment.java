package com.example.foodsapp.view.category;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.foodsapp.R;
import com.example.foodsapp.Utils;
import com.example.foodsapp.adapter.RecyclerViewMealAdapter;
import com.example.foodsapp.adapter.RecyclerViewMealCategoryAdapter;
import com.example.foodsapp.model.Category;
import com.example.foodsapp.model.Meal;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.foodsapp.adapter.ViewPagerCategoryAdapter.CATEGORY_DES;
import static com.example.foodsapp.adapter.ViewPagerCategoryAdapter.CATEGORY_IMG;
import static com.example.foodsapp.adapter.ViewPagerCategoryAdapter.CATEGORY_NAME;

public class CategoryFragment extends Fragment implements CategoryView, RecyclerViewMealCategoryAdapter.onItemClickListener {

    @BindView(R.id.imgCategory)
    ImageView imgCategory;
    @BindView(R.id.imgCategoryBg)
    ImageView imgCategoryBg;
    @BindView(R.id.tvCategory)
    TextView tvCategory;
    @BindView(R.id.rvCategory)
    RecyclerView rvCategory;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.rlCategory)
    RelativeLayout rlCategory;
    AlertDialog.Builder dialogInfo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            tvCategory.setText(getArguments().getString(CATEGORY_DES));
            Picasso.get().load(getArguments().getString(CATEGORY_IMG))
                    .into(imgCategory);
            Picasso.get().load(getArguments().getString(CATEGORY_IMG))
                    .into(imgCategoryBg);
            dialogInfo = new AlertDialog.Builder(getActivity())
                    .setTitle(getArguments().getString(CATEGORY_NAME))
                    .setMessage(getArguments().getString(CATEGORY_DES));
            dialogInfo.setNegativeButton("CLOSE", ((dialog, which) -> dialog.dismiss()));

            CategoryPresenter presenter = new CategoryPresenter(this);
            presenter.setMealCategory(getArguments().getString(CATEGORY_NAME));
        }
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setMealCategory(List<Meal> meals) {
        RecyclerViewMealCategoryAdapter adapter = new RecyclerViewMealCategoryAdapter(meals, getActivity(), this);
        rvCategory.setLayoutManager(new GridLayoutManager(getActivity(), 2, RecyclerView.VERTICAL, false));
        rvCategory.setHasFixedSize(true);
        rvCategory.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onErrorLoading(String message) {
        Utils.showDialogMessage(getContext(), "Error", message);
    }

    @Override
    public void onItemClick(View view, int position) {

    }

    @OnClick(R.id.rlCategory)
    public void onClick() {
        dialogInfo.show();
    }
}