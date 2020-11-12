package com.github.ypdieguez.calaveritatech.exercise.ui.customview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.BindingAdapter;

import com.github.ypdieguez.calaveritatech.exercise.databinding.ViewTitlePriceBinding;

public class TitlePriceView extends ConstraintLayout {

    ViewTitlePriceBinding mBinding;

    public TitlePriceView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mBinding = ViewTitlePriceBinding.inflate(LayoutInflater.from(context), this, true);
    }

    @SuppressLint("SetTextI18n")
    public void bindTo(String title, int price) {
        mBinding.textTitle.setText(title);
        mBinding.textPrice.setText("$" + price + ".00");
    }

    public static class TitlePriceViewBinding {
        @BindingAdapter(value = {"titleText", "priceText"})
        public static void bindText(@NonNull TitlePriceView view, String title, int price) {
            view.bindTo(title, price);
        }
    }
}