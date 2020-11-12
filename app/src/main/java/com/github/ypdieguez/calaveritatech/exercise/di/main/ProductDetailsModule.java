package com.github.ypdieguez.calaveritatech.exercise.di.main;

import com.github.ypdieguez.calaveritatech.exercise.ui.main.productdetails.ProductDetailsContract;
import com.github.ypdieguez.calaveritatech.exercise.ui.main.productdetails.ProductDetailsFragment;
import com.github.ypdieguez.calaveritatech.exercise.ui.main.productdetails.ProductDetailsPresenter;
import com.github.ypdieguez.calaveritatech.exercise.ui.main.productlist.ProductListPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class ProductDetailsModule {
    @ContributesAndroidInjector
    abstract ProductDetailsFragment contributeProductDetailsFragment();

    @Binds
    abstract ProductDetailsContract.Presenter bindProductDetailsPresenter(ProductDetailsPresenter presenter);
}
