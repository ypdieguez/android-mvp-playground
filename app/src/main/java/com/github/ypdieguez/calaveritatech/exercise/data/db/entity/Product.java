package com.github.ypdieguez.calaveritatech.exercise.data.db.entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.github.ypdieguez.calaveritatech.exercise.data.db.converter.PriceConverter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "products")
public class Product {
    @ForeignKey(entity = Category.class, parentColumns = {"id"}, childColumns = {"category_id"}, onDelete = CASCADE)
    @ColumnInfo(name = "category_id")
    @SerializedName("id")
    private String categoryId;

    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("tiendaId")
    @NonNull
    private String id = "";

    @ColumnInfo(name = "title")
    @SerializedName("titulo")
    private String title;

    @ColumnInfo(name = "description")
    @SerializedName("descripcion")
    private String description;

    @ColumnInfo(name = "image_url")
    @SerializedName("urlImagen")
    private String imageUrl;

    @ColumnInfo(name = "status")
    @SerializedName("status")
    private int status;

    @ColumnInfo(name = "discount")
    @SerializedName("descuento")
    private int discount;

    @TypeConverters(PriceConverter.class)
    @ColumnInfo(name = "prices")
    @SerializedName("precios")
    private List<Price> prices;

    @Ignore
    @SerializedName("extras")
    private List<Extra> extras;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    public List<Extra> getExtras() {
        return extras;
    }

    public void setExtras(List<Extra> extras) {
        this.extras = extras;
    }
}