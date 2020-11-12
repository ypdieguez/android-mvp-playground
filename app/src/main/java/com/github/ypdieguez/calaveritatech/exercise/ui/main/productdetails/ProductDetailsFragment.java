package com.github.ypdieguez.calaveritatech.exercise.ui.main.productdetails;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.paging.PagedList;

import com.github.ypdieguez.calaveritatech.exercise.R;
import com.github.ypdieguez.calaveritatech.exercise.data.db.model.ItemDetails;
import com.github.ypdieguez.calaveritatech.exercise.data.db.model.ProductDetails;
import com.github.ypdieguez.calaveritatech.exercise.databinding.FragmentProductDetailsListBinding;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

public class ProductDetailsFragment extends DaggerFragment implements ProductDetailsContract.View {

    @Inject
    ProductDetailsContract.Presenter mPresenter;

    FragmentProductDetailsListBinding mBinding;
    ProductDetailsAdapter mAdapter = new ProductDetailsAdapter();
    ProductDetails mProduct;

    private final CompositeDisposable mDisposable = new CompositeDisposable();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProduct = ProductDetailsFragmentArgs.fromBundle(getArguments()).getProduct();
        mAdapter.setHeader(mProduct);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_product_details_list,
                        container, false);

        mBinding.productDetailsList.setAdapter(mAdapter);

        return mBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.takeView(this);
        mPresenter.getProductItems(mProduct.getId());
    }

    @Override
    public void onStop() {
        super.onStop();
        mDisposable.clear();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.dropView();
    }

    @Override
    public void loadProductItems(@NonNull Observable<PagedList<ItemDetails>> items) {
        mDisposable.add(items.subscribe(mAdapter::submitList));
    }
}