package com.github.ypdieguez.calaveritatech.exercise.data.db.entity;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Price implements Parcelable {
    @SerializedName("titulo")
    private String title;

    @SerializedName("descripcion")
    private String description;

    @SerializedName("precio")
    int price;

    protected Price(@NonNull Parcel in) {
        title = in.readString();
        description = in.readString();
        price = in.readInt();
    }

    public static final Creator<Price> CREATOR = new Creator<Price>() {
        @NonNull
        @Override
        public Price createFromParcel(Parcel in) {
            return new Price(in);
        }

        @NonNull
        @Override
        public Price[] newArray(int size) {
            return new Price[size];
        }
    };

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(description);
        dest.writeInt(price);
    }
}