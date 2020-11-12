package com.github.ypdieguez.calaveritatech.exercise.ui.main.productlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.github.ypdieguez.calaveritatech.exercise.data.db.model.ProductDetails;
import com.github.ypdieguez.calaveritatech.exercise.databinding.ItemProductBinding;

public class ProductListAdapter extends PagedListAdapter<ProductDetails, ProductListAdapter.ProductViewHolder> {

    protected ProductListAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemProductBinding dataBinding =
                ItemProductBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new ProductViewHolder(dataBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        ProductDetails product = getItem(position);
        ProductDetails previousProduct = position > 0 ? getItem(position - 1) : null;
        if (product != null) {
            holder.bindTo(product, previousProduct);
        }
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {

        private final ItemProductBinding mDataBinding;

        public ProductViewHolder(@NonNull ItemProductBinding dataBinding) {
            super(dataBinding.getRoot());
            mDataBinding = dataBinding;
        }

        void bindTo(ProductDetails product, ProductDetails previousProduct) {
            mDataBinding.setProduct(product);
            if (previousProduct == null ||
                    !previousProduct.getCategory().equals(product.getCategory())) {
                mDataBinding.setCategoryVisibility(View.VISIBLE);
            } else {
                mDataBinding.setCategoryVisibility(View.GONE);
            }

            mDataBinding.cardProductContainer.setOnClickListener(v -> {
                NavDirections dir = ProductListFragmentDirections
                        .actionProductListFragmentToProductDetailsFragment(product);
                Navigation.findNavController(v).navigate(dir);

            });
        }
    }


    private static final DiffUtil.ItemCallback<ProductDetails> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<ProductDetails>() {
                @Override
                public boolean areItemsTheSame(@NonNull ProductDetails oldProduct, @NonNull ProductDetails newProduct) {
                    if (oldProduct == null || newProduct == null) {
                        return false;
                    }
                    return oldProduct.getId().equals(newProduct.getId());
                }

                @Override
                public boolean areContentsTheSame(@NonNull ProductDetails oldProduct, @NonNull ProductDetails newProduct) {
                    // TODO: Fix content comparision
                    if (oldProduct == null || newProduct == null) {
                        return false;
                    }
                    return oldProduct.getId().equals(newProduct.getId());
                }
            };
}
