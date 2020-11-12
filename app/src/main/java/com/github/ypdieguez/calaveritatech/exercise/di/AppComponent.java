package com.github.ypdieguez.calaveritatech.exercise.di;

import android.app.Application;

import com.github.ypdieguez.calaveritatech.exercise.App;
import com.github.ypdieguez.calaveritatech.exercise.di.fetch.FetchDataActivityModule;
import com.github.ypdieguez.calaveritatech.exercise.di.main.MainActivityModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(
        modules = {
                AndroidSupportInjectionModule.class,
                AppModule.class,
                FetchDataActivityModule.class,
                MainActivityModule.class
        }
)
public interface AppComponent extends AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application app);

        AppComponent build();
    }
}
