package com.github.ypdieguez.calaveritatech.exercise.ui.main.productlist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.paging.PagedList;

import com.github.ypdieguez.calaveritatech.exercise.R;
import com.github.ypdieguez.calaveritatech.exercise.data.db.entity.Product;
import com.github.ypdieguez.calaveritatech.exercise.data.db.model.ProductDetails;
import com.github.ypdieguez.calaveritatech.exercise.databinding.FragmentProductListBinding;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

public class ProductListFragment extends DaggerFragment implements ProductListContract.View {

    @Inject
    ProductListPresenter mPresenter;

    private final ProductListAdapter mAdapter = new ProductListAdapter();
    private final CompositeDisposable mDisposable = new CompositeDisposable();


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentProductListBinding mDataBinding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_product_list, container, false);
        mDataBinding.productList.setAdapter(mAdapter);
        return mDataBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.takeView(this);
        mPresenter.getProducts();
    }

    @Override
    public void loadProducts(@NonNull Observable<PagedList<ProductDetails>> productList) {
        mDisposable.add(productList.subscribe(mAdapter::submitList));
    }

    @Override
    public void onStop() {
        super.onStop();
        mDisposable.clear();
    }
}