package com.example.foodsapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.foodsapp.R;
import com.example.foodsapp.model.Meal;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ViewPagerHomeAdapter extends PagerAdapter {

    private List<Meal> meals;
    private Context context;
    private onItemClickListener onItemClickListener;

    public ViewPagerHomeAdapter(List<Meal> meals, Context context) {
        this.meals = meals;
        this.context = context;
    }

    public void setOnItemClickListener(ViewPagerHomeAdapter.onItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_vp_banner, container, false);
        ImageView imgBanner = view.findViewById(R.id.img_banner);
        TextView tvBanner = view.findViewById(R.id.tv_banner);
        Meal meal = meals.get(position);
        Picasso.get().load(meal.getStrMealThumb()).into(imgBanner);
        tvBanner.setText(meal.getStrMeal());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(v, position);
            }
        });
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return meals.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    public interface onItemClickListener {
        void onItemClick(View view, int position);
    }
}
