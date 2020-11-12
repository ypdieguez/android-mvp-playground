package com.github.ypdieguez.calaveritatech.exercise.ui.main.productdetails;

import androidx.paging.PagedList;

import com.github.ypdieguez.calaveritatech.exercise.data.db.model.ItemDetails;
import com.github.ypdieguez.calaveritatech.exercise.data.db.model.ProductDetails;
import com.github.ypdieguez.calaveritatech.exercise.ui.BasePresenter;
import com.github.ypdieguez.calaveritatech.exercise.ui.BaseView;

import io.reactivex.Observable;

public class ProductDetailsContract {
    public interface View extends BaseView<Presenter> {
        void loadProductItems(Observable<PagedList<ItemDetails>> items);
    }

    public interface Presenter extends BasePresenter<View> {
        void getProductItems(String productId);
    }
}
