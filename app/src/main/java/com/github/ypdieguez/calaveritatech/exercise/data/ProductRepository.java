package com.github.ypdieguez.calaveritatech.exercise.data;

import androidx.paging.PagedList;
import androidx.paging.RxPagedListBuilder;

import com.github.ypdieguez.calaveritatech.exercise.data.db.dao.ProductDao;
import com.github.ypdieguez.calaveritatech.exercise.data.db.entity.Product;
import com.github.ypdieguez.calaveritatech.exercise.data.db.model.ItemDetails;
import com.github.ypdieguez.calaveritatech.exercise.data.db.model.ProductDetails;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class ProductRepository {

    private final ProductDao productDao;

    @Inject
    ProductRepository(ProductDao productDao) {
        this.productDao = productDao;
    }

    public Observable<PagedList<ProductDetails>> loadProducts() {
        return new RxPagedListBuilder<>(productDao.getProducts(), 30)
                .buildObservable();
    }

    public Observable<PagedList<ItemDetails>> loadProductItems(String productId) {
        return new RxPagedListBuilder<>(productDao.getProductItems(productId), 50)
                .buildObservable();
    }
}
