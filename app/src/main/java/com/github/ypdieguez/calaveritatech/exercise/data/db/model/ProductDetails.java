package com.github.ypdieguez.calaveritatech.exercise.data.db.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.TypeConverters;

import com.github.ypdieguez.calaveritatech.exercise.data.db.converter.PriceConverter;
import com.github.ypdieguez.calaveritatech.exercise.data.db.entity.Price;

import java.util.List;

public class ProductDetails implements Parcelable {
    @ColumnInfo(name = "category")
    private String category;

    @ColumnInfo(name = "id")
    private String id;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "image_url")
    private String imageUrl;

    @TypeConverters(PriceConverter.class)
    @ColumnInfo(name = "prices")
    private List<Price> prices;

    public ProductDetails() {
    }

    protected ProductDetails(@NonNull Parcel parcel) {
        category = parcel.readString();
        id = parcel.readString();
        title = parcel.readString();
        description = parcel.readString();
        imageUrl = parcel.readString();
        parcel.readTypedList(prices, Price.CREATOR);
    }

    public static final Creator<ProductDetails> CREATOR = new Creator<ProductDetails>() {
        @NonNull
        @Override
        public ProductDetails createFromParcel(Parcel in) {
            return new ProductDetails(in);
        }

        @NonNull
        @Override
        public ProductDetails[] newArray(int size) {
            return new ProductDetails[size];
        }
    };

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(category);
        dest.writeString(id);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(imageUrl);
        dest.writeTypedList(prices);
    }
}
