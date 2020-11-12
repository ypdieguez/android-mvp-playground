package com.github.ypdieguez.calaveritatech.exercise.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.github.ypdieguez.calaveritatech.exercise.data.db.dao.DataDao;
import com.github.ypdieguez.calaveritatech.exercise.data.db.dao.ProductDao;
import com.github.ypdieguez.calaveritatech.exercise.data.db.entity.Category;
import com.github.ypdieguez.calaveritatech.exercise.data.db.entity.Extra;
import com.github.ypdieguez.calaveritatech.exercise.data.db.entity.Item;
import com.github.ypdieguez.calaveritatech.exercise.data.db.entity.Product;

/**
 * Main database.
 */
@Database(
        entities = {
                Category.class,
                Product.class,
                Extra.class,
                Item.class
        },
        version = 1,
        exportSchema = false
)
public abstract class AppDb extends RoomDatabase {
    public abstract ProductDao productDao();

    public abstract DataDao dataDao();
}