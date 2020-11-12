package com.github.ypdieguez.calaveritatech.exercise.di.fetch;

import com.github.ypdieguez.calaveritatech.exercise.ui.fetch.FetchDataActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FetchDataActivityModule {
    @ContributesAndroidInjector(modules = {FetchDataPresenterModule.class})
    abstract FetchDataActivity contributeFetchDataActivity();
}
