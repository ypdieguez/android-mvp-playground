package com.github.ypdieguez.calaveritatech.exercise.di.main;

import com.github.ypdieguez.calaveritatech.exercise.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = {ProductListModule.class, ProductDetailsModule.class})
    abstract MainActivity contributeMainActivity();
}
