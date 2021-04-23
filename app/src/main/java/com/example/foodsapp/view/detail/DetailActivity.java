package com.example.foodsapp.view.detail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.foodsapp.R;
import com.example.foodsapp.Utils;
import com.example.foodsapp.model.Meal;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.foodsapp.view.home.HomeActivity.MEALNAME;

public class DetailActivity extends AppCompatActivity implements DetailView {

    @BindView(R.id.appbar)
    AppBarLayout appBar;

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;

    @BindView(R.id.imgThumb)
    ImageView imgThumb;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.tvCategory)
    TextView tvCategory;

    @BindView(R.id.tvCountry)
    TextView tvCountry;

    @BindView(R.id.instructions)
    TextView instructions;

    @BindView(R.id.ingredient)
    TextView ingredient;

    @BindView(R.id.measure)
    TextView measure;

    @BindView(R.id.youtube)
    TextView youtube;

    @BindView(R.id.source)
    TextView source;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        DetailPresenter presenter = new DetailPresenter(this);
        presenter.setDetailMeal(getIntent().getStringExtra(MEALNAME));

        setAppBar();
    }

    private void setAppBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        collapsingToolbar.setExpandedTitleColor(getResources().getColor(R.color.colorWhite));
        collapsingToolbar.setCollapsedTitleTextColor(getResources().getColor(R.color.colorPrimary));
        collapsingToolbar.setContentScrimColor(getResources().getColor(R.color.colorWhite));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        MenuItem item = menu.findItem(R.id.favorite);
        Drawable itemDrawable = item.getIcon();
        setColorItemAppBar(itemDrawable);
        return super.onCreateOptionsMenu(menu);
    }

    private void setColorItemAppBar(Drawable item) {
        appBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if ((collapsingToolbar.getHeight() + verticalOffset) < (2 * ViewCompat.getMinimumHeight(collapsingToolbar))) {
                    item.setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);
                    toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);
                } else {
                    item.setColorFilter(getResources().getColor(R.color.colorWhite), PorterDuff.Mode.SRC_ATOP);
                    toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.colorWhite), PorterDuff.Mode.SRC_ATOP);
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void setMeal(Meal meal) {
        collapsingToolbar.setTitle(meal.getStrMeal());
        Picasso.get().load(meal.getStrMealThumb())
                .into(imgThumb);
        tvCategory.setText(meal.getStrCategory());
        tvCountry.setText(meal.getStrArea());
        instructions.setText(meal.getStrInstructions());
        if (!meal.getStrIngredient1().isEmpty()) {
            ingredient.append("\n \u2022 " + meal.getStrIngredient1());
        }
        if (!meal.getStrIngredient2().isEmpty()) {
            ingredient.append("\n \u2022 " + meal.getStrIngredient2());
        }
        if (!meal.getStrIngredient3().isEmpty()) {
            ingredient.append("\n \u2022 " + meal.getStrIngredient3());
        }
        if (!meal.getStrIngredient4().isEmpty()) {
            ingredient.append("\n \u2022 " + meal.getStrIngredient4());
        }
        if (!meal.getStrIngredient5().isEmpty()) {
            ingredient.append("\n \u2022 " + meal.getStrIngredient5());
        }
        if (!meal.getStrIngredient6().isEmpty()) {
            ingredient.append("\n \u2022 " + meal.getStrIngredient6());
        }
        if (!meal.getStrIngredient7().isEmpty()) {
            ingredient.append("\n \u2022 " + meal.getStrIngredient7());
        }
        if (!meal.getStrIngredient8().isEmpty()) {
            ingredient.append("\n \u2022 " + meal.getStrIngredient8());
        }
        if (!meal.getStrIngredient9().isEmpty()) {
            ingredient.append("\n \u2022 " + meal.getStrIngredient9());
        }
        if (!meal.getStrIngredient10().isEmpty()) {
            ingredient.append("\n \u2022 " + meal.getStrIngredient10());
        }
        if (!meal.getStrIngredient11().isEmpty()) {
            ingredient.append("\n \u2022 " + meal.getStrIngredient11());
        }
        if (!meal.getStrIngredient12().isEmpty()) {
            ingredient.append("\n \u2022 " + meal.getStrIngredient12());
        }
        if (!meal.getStrIngredient13().isEmpty()) {
            ingredient.append("\n \u2022 " + meal.getStrIngredient13());
        }
        if (!meal.getStrIngredient14().isEmpty()) {
            ingredient.append("\n \u2022 " + meal.getStrIngredient14());
        }
        if (!meal.getStrIngredient15().isEmpty()) {
            ingredient.append("\n \u2022 " + meal.getStrIngredient15());
        }
        if (!meal.getStrIngredient16().isEmpty()) {
            ingredient.append("\n \u2022 " + meal.getStrIngredient16());
        }
        if (!meal.getStrIngredient17().isEmpty()) {
            ingredient.append("\n \u2022 " + meal.getStrIngredient17());
        }
        if (!meal.getStrIngredient18().isEmpty()) {
            ingredient.append("\n \u2022 " + meal.getStrIngredient18());
        }
        if (!meal.getStrIngredient19().isEmpty()) {
            ingredient.append("\n \u2022 " + meal.getStrIngredient19());
        }
        if (!meal.getStrIngredient20().isEmpty()) {
            ingredient.append("\n \u2022 " + meal.getStrIngredient20());
        }

        if (!meal.getStrMeasure1().isEmpty() && !Character.isWhitespace(meal.getStrMeasure1().charAt(0))) {
            measure.append("\n : " + meal.getStrMeasure1());
        }
        if (!meal.getStrMeasure2().isEmpty() && !Character.isWhitespace(meal.getStrMeasure2().charAt(0))) {
            measure.append("\n : " + meal.getStrMeasure2());
        }
        if (!meal.getStrMeasure3().isEmpty() && !Character.isWhitespace(meal.getStrMeasure3().charAt(0))) {
            measure.append("\n : " + meal.getStrMeasure3());
        }
        if (!meal.getStrMeasure4().isEmpty() && !Character.isWhitespace(meal.getStrMeasure4().charAt(0))) {
            measure.append("\n : " + meal.getStrMeasure4());
        }
        if (!meal.getStrMeasure5().isEmpty() && !Character.isWhitespace(meal.getStrMeasure5().charAt(0))) {
            measure.append("\n : " + meal.getStrMeasure5());
        }
        if (!meal.getStrMeasure6().isEmpty() && !Character.isWhitespace(meal.getStrMeasure6().charAt(0))) {
            measure.append("\n : " + meal.getStrMeasure6());
        }
        if (!meal.getStrMeasure7().isEmpty() && !Character.isWhitespace(meal.getStrMeasure7().charAt(0))) {
            measure.append("\n : " + meal.getStrMeasure7());
        }
        if (!meal.getStrMeasure8().isEmpty() && !Character.isWhitespace(meal.getStrMeasure8().charAt(0))) {
            measure.append("\n : " + meal.getStrMeasure8());
        }
        if (!meal.getStrMeasure9().isEmpty() && !Character.isWhitespace(meal.getStrMeasure9().charAt(0))) {
            measure.append("\n : " + meal.getStrMeasure9());
        }
        if (!meal.getStrMeasure10().isEmpty() && !Character.isWhitespace(meal.getStrMeasure10().charAt(0))) {
            measure.append("\n : " + meal.getStrMeasure10());
        }
        if (!meal.getStrMeasure11().isEmpty() && !Character.isWhitespace(meal.getStrMeasure11().charAt(0))) {
            measure.append("\n : " + meal.getStrMeasure11());
        }
        if (!meal.getStrMeasure12().isEmpty() && !Character.isWhitespace(meal.getStrMeasure12().charAt(0))) {
            measure.append("\n : " + meal.getStrMeasure12());
        }
        if (!meal.getStrMeasure13().isEmpty() && !Character.isWhitespace(meal.getStrMeasure13().charAt(0))) {
            measure.append("\n : " + meal.getStrMeasure13());
        }
        if (!meal.getStrMeasure14().isEmpty() && !Character.isWhitespace(meal.getStrMeasure14().charAt(0))) {
            measure.append("\n : " + meal.getStrMeasure14());
        }
        if (!meal.getStrMeasure15().isEmpty() && !Character.isWhitespace(meal.getStrMeasure15().charAt(0))) {
            measure.append("\n : " + meal.getStrMeasure15());
        }
        if (!meal.getStrMeasure16().isEmpty() && !Character.isWhitespace(meal.getStrMeasure16().charAt(0))) {
            measure.append("\n : " + meal.getStrMeasure16());
        }
        if (!meal.getStrMeasure17().isEmpty() && !Character.isWhitespace(meal.getStrMeasure17().charAt(0))) {
            measure.append("\n : " + meal.getStrMeasure17());
        }
        if (!meal.getStrMeasure18().isEmpty() && !Character.isWhitespace(meal.getStrMeasure18().charAt(0))) {
            measure.append("\n : " + meal.getStrMeasure18());
        }
        if (!meal.getStrMeasure19().isEmpty() && !Character.isWhitespace(meal.getStrMeasure19().charAt(0))) {
            measure.append("\n : " + meal.getStrMeasure19());
        }
        if (!meal.getStrMeasure20().isEmpty() && !Character.isWhitespace(meal.getStrMeasure20().charAt(0))) {
            measure.append("\n : " + meal.getStrMeasure20());
        }

        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(meal.getStrYoutube()));
                startActivity(intent);
            }
        });

        source.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(meal.getStrSource()));
                startActivity(intent);
            }
        });
    }

    @Override
    public void onErrorLoading(String message) {
        Utils.showDialogMessage(this, "Error", message);
    }
}