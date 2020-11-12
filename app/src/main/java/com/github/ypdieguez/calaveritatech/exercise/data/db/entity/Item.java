package com.github.ypdieguez.calaveritatech.exercise.data.db.entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "items")
public class Item {
    @ForeignKey(entity = Product.class, parentColumns = {"id"}, childColumns = {"extra_id"}, onDelete = CASCADE)
    @ColumnInfo(name = "extra_id")
    String extraId;

    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    @NonNull
    String id = "";

    @ColumnInfo(name = "name")
    @SerializedName("nombre")
    String name;

    @ColumnInfo(name = "price")
    @SerializedName("precio")
    int price;

    @ColumnInfo(name = "status")
    @SerializedName("status")
    int status;

    public String getExtraId() {
        return extraId;
    }

    public void setExtraId(String extraId) {
        this.extraId = extraId;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}