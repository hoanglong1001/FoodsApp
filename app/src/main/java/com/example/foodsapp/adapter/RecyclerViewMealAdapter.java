package com.example.foodsapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodsapp.R;
import com.example.foodsapp.model.Category;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewMealAdapter extends RecyclerView.Adapter<RecyclerViewMealAdapter.ViewHolder> {

    private Context context;
    private List<Category> categories;
    private onItemClickedListener onItemClickedListener;

    public RecyclerViewMealAdapter(Context context, List<Category> categories) {
        this.context = context;
        this.categories = categories;
    }

    public void setOnItemClickedListener(RecyclerViewMealAdapter.onItemClickedListener onItemClickedListener) {
        this.onItemClickedListener = onItemClickedListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rv_meal, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category category = categories.get(position);
        Picasso.get().load(category.getStrCategoryThumb()).into(holder.imgCategory);
        holder.tvCategory.setText(category.getStrCategory());
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_category)
        ImageView imgCategory;
        @BindView(R.id.tv_category)
        TextView tvCategory;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickedListener.onClicked(v, getAdapterPosition());
                }
            });
        }
    }

    public interface onItemClickedListener {
        void onClicked(View view, int position);
    }
}
