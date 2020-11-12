package com.github.ypdieguez.calaveritatech.exercise.ui.main.productdetails;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.paging.DataSource;
import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.github.ypdieguez.calaveritatech.exercise.R;
import com.github.ypdieguez.calaveritatech.exercise.data.db.model.ItemDetails;
import com.github.ypdieguez.calaveritatech.exercise.data.db.model.ProductDetails;
import com.github.ypdieguez.calaveritatech.exercise.databinding.ItemProductDetailsHeaderBinding;
import com.github.ypdieguez.calaveritatech.exercise.databinding.ItemProductDetailsItemBinding;

class ProductDetailsAdapter extends PagedListAdapter<ItemDetails, RecyclerView.ViewHolder> {

    private static final int VIEW_HEADER = 657;
    private static final int VIEW_ITEM = 970;
    private static final int VIEW_EMPTY = 846;

    private ProductDetails mProduct;
    private boolean isEmpty = false;

    protected ProductDetailsAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        if (viewType == VIEW_ITEM) {
            ItemProductDetailsItemBinding itemBinding =
                    ItemProductDetailsItemBinding.inflate(inflater, viewGroup, false);
            return new ItemViewHolder(itemBinding);
        } else if (viewType == VIEW_HEADER) {
            ItemProductDetailsHeaderBinding headerBinding =
                    ItemProductDetailsHeaderBinding.inflate(inflater, viewGroup, false);
            return new HeaderViewHolder(headerBinding);
        } else {
            return new RecyclerView.ViewHolder(
                    inflater.inflate(R.layout.item_details_empty, viewGroup, false)
            ) {
                @Override
                public String toString() {
                    return super.toString();
                }
            };
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemDetails item = getItem(position);
            ItemDetails previousItem = position > 0 ? getItem(position - 1) : null;
            ((ItemViewHolder) holder).bindTo(item, previousItem);
        } else if (holder instanceof HeaderViewHolder) {
            ItemDetails item = getItem(position);
            ((HeaderViewHolder) holder).bindTo(mProduct, item);
        }
    }

    @Override
    public void submitList(@Nullable PagedList<ItemDetails> pagedList) {
        super.submitList(pagedList);
        isEmpty = pagedList.getLoadedCount() == 0;
        if (isEmpty) notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return !isEmpty ? super.getItemCount() : 1;
    }

    @Override
    public int getItemViewType(int position) {
        return !isEmpty ? position == 0 ? VIEW_HEADER : VIEW_ITEM : VIEW_EMPTY;
    }

    public void setHeader(ProductDetails product) {
        this.mProduct = product;
    }

    static class HeaderViewHolder extends RecyclerView.ViewHolder {

        private final ItemProductDetailsHeaderBinding mBinding;

        public HeaderViewHolder(@NonNull ItemProductDetailsHeaderBinding headerBinding) {
            super(headerBinding.getRoot());
            mBinding = headerBinding;
        }

        public void bindTo(ProductDetails product, ItemDetails item) {
            mBinding.setProduct(product);
            mBinding.setItem(item);
        }
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {

        private final ItemProductDetailsItemBinding mBinding;

        public ItemViewHolder(@NonNull ItemProductDetailsItemBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public void bindTo(ItemDetails item, ItemDetails previousItem) {
            mBinding.setItem(item);
            mBinding.setHeaderVisibility(
                    previousItem == null || !previousItem.getTitle().equals(item.getTitle())
                            ? View.VISIBLE : View.GONE
            );
        }
    }

    private static final DiffUtil.ItemCallback<ItemDetails> DIFF_CALLBACK = new DiffUtil.ItemCallback<ItemDetails>() {
        @Override
        public boolean areItemsTheSame(@NonNull ItemDetails oldItem, @NonNull ItemDetails newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull ItemDetails oldItem, @NonNull ItemDetails newItem) {
            return oldItem.getId().equals(newItem.getId());
        }
    };
}
