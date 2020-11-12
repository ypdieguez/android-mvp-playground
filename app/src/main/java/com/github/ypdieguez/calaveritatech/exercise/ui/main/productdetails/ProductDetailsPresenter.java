package com.github.ypdieguez.calaveritatech.exercise.ui.main.productdetails;

import androidx.paging.PagedList;

import com.github.ypdieguez.calaveritatech.exercise.data.ProductRepository;
import com.github.ypdieguez.calaveritatech.exercise.data.db.model.ItemDetails;

import javax.inject.Inject;

import io.reactivex.Observable;

public class ProductDetailsPresenter implements ProductDetailsContract.Presenter {

    ProductDetailsContract.View view;

    private final ProductRepository repository;
    private String lastProductId = "";
    private Observable<PagedList<ItemDetails>> itemList;

    @Inject
    ProductDetailsPresenter(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void takeView(ProductDetailsContract.View view) {
        this.view = view;
    }

    @Override
    public void dropView() {
        this.view = null;
    }

    @Override
    public void getProductItems(String productId) {
        if (!lastProductId.equals(productId)) {
            lastProductId = productId;
            itemList = repository.loadProductItems(productId);
        }

        view.loadProductItems(itemList);
    }
}
