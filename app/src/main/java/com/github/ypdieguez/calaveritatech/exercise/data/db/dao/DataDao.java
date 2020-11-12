package com.github.ypdieguez.calaveritatech.exercise.data.db.dao;

import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.github.ypdieguez.calaveritatech.exercise.data.db.entity.Category;
import com.github.ypdieguez.calaveritatech.exercise.data.db.entity.Extra;
import com.github.ypdieguez.calaveritatech.exercise.data.db.entity.Item;
import com.github.ypdieguez.calaveritatech.exercise.data.db.entity.Product;

import java.util.List;

@Dao
public abstract class DataDao {
    @Transaction
    public void updateData(@NonNull List<Category> categories) {

        // Clear db
        deleteItems();
        deleteExtras();
        deleteProducts();
        deleteCategories();

        for (Category category : categories) {
            // Add category id from products
            String categoryId = category.getProductDetails().get(0).getCategoryId();
            category.setId(categoryId);
            // Insert category
            insertCategory(category);

            // Update products
            for (Product product : category.getProductDetails()) {
                // Insert product, add category id is not necessary (comes with product)
                insertProduct(product);

                // Update extras
                for (Extra extra : product.getExtras()) {
                    // Add product id to extra
                    extra.setProductId(product.getId());
                    // Update extra
                    insertExtra(extra);

                    // Update items
                    for (Item item : extra.getItems()) {
                        // Add extra id to item
                        item.setExtraId(extra.getId());
                        // Insert item
                        insertItem(item);
                    }
                }
            }
        }
    }

    @Insert
    abstract void insertCategory(Category category);

    @Update
    abstract int updateCategory(Category category);

    @Query("SELECT * FROM categories WHERE id = :id")
    abstract Category getCategory(String id);

    @Insert
    abstract void insertProduct(Product product);

    @Update
    abstract int updateProduct(Product product);

    @Insert
    abstract void insertExtra(Extra extra);

    @Update
    abstract int updateExtra(Extra extra);

    @Insert
    abstract void insertItem(Item item);

    @Update
    abstract int updateItem(Item item);

    @Query("DELETE FROM categories")
    abstract void deleteCategories();

    @Query("DELETE FROM products")
    abstract void deleteProducts();

    @Query("DELETE FROM extras")
    abstract void deleteExtras();

    @Query("DELETE FROM items")
    abstract void deleteItems();
}
