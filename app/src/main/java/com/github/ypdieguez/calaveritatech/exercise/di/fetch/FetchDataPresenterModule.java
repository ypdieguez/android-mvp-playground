package com.github.ypdieguez.calaveritatech.exercise.di.fetch;


import com.github.ypdieguez.calaveritatech.exercise.ui.fetch.FetchDataContract;
import com.github.ypdieguez.calaveritatech.exercise.ui.fetch.FetchDataPresenter;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class FetchDataPresenterModule {
    @Binds
    abstract FetchDataContract.Presenter bindFetchDataPresenter(FetchDataPresenter presenter);
}
