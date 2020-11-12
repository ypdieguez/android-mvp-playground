package com.github.ypdieguez.calaveritatech.exercise.data.db.converter;

import androidx.room.TypeConverter;

import com.github.ypdieguez.calaveritatech.exercise.data.db.entity.Price;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class PriceConverter {
    @TypeConverter
    public String fromPriceList(List<Price> prices) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Price>>() {
        }.getType();
        return gson.toJson(prices, type);
    }

    @TypeConverter
    public List<Price> toPriceList(String prices) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Price>>() {
        }.getType();
        return gson.fromJson(prices, type);
    }
}
