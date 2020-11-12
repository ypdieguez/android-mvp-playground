package com.github.ypdieguez.calaveritatech.exercise.ui.main.productlist;

import androidx.paging.PagedList;

import com.github.ypdieguez.calaveritatech.exercise.data.ProductRepository;
import com.github.ypdieguez.calaveritatech.exercise.data.db.model.ProductDetails;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class ProductListPresenter implements ProductListContract.Presenter {

    private ProductListContract.View view;

    private final ProductRepository repository;
    private Observable<PagedList<ProductDetails>> productList;

    @Inject
    ProductListPresenter(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void takeView(ProductListContract.View view) {
        this.view = view;
    }

    @Override
    public void dropView() {
        this.view = null;
    }

    @Override
    public void getProducts() {
        if (productList == null) productList = repository.loadProducts();
        view.loadProducts(productList);
    }
}
