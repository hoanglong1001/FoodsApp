package com.example.foodsapp.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodsapp.R;
import com.example.foodsapp.model.Meal;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewMealCategoryAdapter extends RecyclerView.Adapter<RecyclerViewMealCategoryAdapter.ViewHolder> {

    private List<Meal> meals;
    private Context context;
    private onItemClickListener onItemClickListener;

    public RecyclerViewMealCategoryAdapter(List<Meal> meals, Context context, RecyclerViewMealCategoryAdapter.onItemClickListener onItemClickListener) {
        this.meals = meals;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rv_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvMeal.setText(meals.get(position).getStrMeal());
        Picasso.get().load(meals.get(position).getStrMealThumb())
                .into(holder.imgMeal);
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.imgMeal)
        ImageView imgMeal;
        @BindView(R.id.tvMeal)
        TextView tvMeal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(v, getAdapterPosition());
        }
    }

    public interface onItemClickListener {
        void onItemClick(View view, int position);
    }
}
