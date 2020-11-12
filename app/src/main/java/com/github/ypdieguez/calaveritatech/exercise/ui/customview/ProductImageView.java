package com.github.ypdieguez.calaveritatech.exercise.ui.customview;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.github.ypdieguez.calaveritatech.exercise.R;

public class ProductImageView extends AppCompatImageView {

    public ProductImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public static class ProductViewBinding {
        @BindingAdapter(value = {"imageUrl"})
        public static void bindText(@NonNull ProductImageView view, String url) {
            Glide.with(view.getContext())
                    .load(url)
                    .apply(
                            RequestOptions
                                    .placeholderOf(R.drawable.image)
                                    .error(R.drawable.image)
                                    .transform(new CenterCrop(), new RoundedCorners(16))
                    )
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(view);
        }
    }
}
