package com.github.ypdieguez.calaveritatech.exercise.di.main;

import com.github.ypdieguez.calaveritatech.exercise.ui.main.productlist.ProductListContract;
import com.github.ypdieguez.calaveritatech.exercise.ui.main.productlist.ProductListFragment;
import com.github.ypdieguez.calaveritatech.exercise.ui.main.productlist.ProductListPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ProductListModule {
    @ContributesAndroidInjector
    abstract ProductListFragment contributeProductListFragment();

    @Binds
    abstract ProductListContract.Presenter bindProductListPresenter(ProductListPresenter presenter);
}
