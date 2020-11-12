package com.github.ypdieguez.calaveritatech.exercise.data.remote;


import com.github.ypdieguez.calaveritatech.exercise.data.db.entity.Category;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface APIService {
    @GET("categoriasWithProd.php")
//    @GET("data")
    Observable<List<Category>> fetchData();
}
