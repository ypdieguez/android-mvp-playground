package com.github.ypdieguez.calaveritatech.exercise.data.db.dao;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Query;

import com.github.ypdieguez.calaveritatech.exercise.data.db.model.ItemDetails;
import com.github.ypdieguez.calaveritatech.exercise.data.db.model.ProductDetails;

@Dao
public interface ProductDao {
    @Query("SELECT categories.category, products.id, products.title, products.description, " +
            "products.image_url, products.prices " +
            "FROM products JOIN categories ON products.category_id = categories.id")
    DataSource.Factory<Integer, ProductDetails> getProducts();

    @Query("SELECT extras.title, extras.description, items.id, items.name, items.price" +
            " FROM extras INNER JOIN items ON extras.id = items.extra_id" +
            " WHERE extras.product_id = :productId")
    DataSource.Factory<Integer, ItemDetails> getProductItems(String productId);
}