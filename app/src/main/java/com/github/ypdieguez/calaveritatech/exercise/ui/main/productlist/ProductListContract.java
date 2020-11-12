package com.github.ypdieguez.calaveritatech.exercise.ui.main.productlist;

import androidx.paging.PagedList;

import com.github.ypdieguez.calaveritatech.exercise.data.db.entity.Product;
import com.github.ypdieguez.calaveritatech.exercise.data.db.model.ProductDetails;
import com.github.ypdieguez.calaveritatech.exercise.ui.BasePresenter;
import com.github.ypdieguez.calaveritatech.exercise.ui.BaseView;

import io.reactivex.Observable;

/**
 * This specifies the contract between the view and the presenter.
 */
public class ProductListContract {
    public interface View extends BaseView<Presenter> {
        void loadProducts(Observable<PagedList<ProductDetails>> products);
    }

    public interface Presenter extends BasePresenter<View> {
        void getProducts();
    }
}
