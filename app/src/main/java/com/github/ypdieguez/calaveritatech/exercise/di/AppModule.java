package com.github.ypdieguez.calaveritatech.exercise.di;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.room.Room;

import com.github.ypdieguez.calaveritatech.exercise.data.db.AppDb;
import com.github.ypdieguez.calaveritatech.exercise.data.db.dao.DataDao;
import com.github.ypdieguez.calaveritatech.exercise.data.db.dao.ProductDao;
import com.github.ypdieguez.calaveritatech.exercise.data.remote.APIService;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {
    @Singleton
    @Provides
    public APIService provideAPiService() {
        return new Retrofit.Builder()
                .baseUrl("https://dev.calaverita.tech/faker/V1/")
//                .baseUrl("http://192.168.1.102:3000")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(new OkHttpClient.Builder()
                        .callTimeout(2, TimeUnit.MINUTES)
                        .connectTimeout(20, TimeUnit.SECONDS)
                        .readTimeout(30, TimeUnit.SECONDS).build())
                .build()
                .create(APIService.class);
    }

    @Singleton
    @Provides
    public AppDb provideDb(Application app) {
        return Room
                .databaseBuilder(app, AppDb.class, "calaverita_tech.db")
                .build();
    }

    @Singleton
    @Provides
    public DataDao provideDataDao(@NonNull AppDb db) {
        return db.dataDao();
    }

    @Singleton
    @Provides
    public ProductDao provideProductDao(@NonNull AppDb db) {
        return db.productDao();
    }
}
