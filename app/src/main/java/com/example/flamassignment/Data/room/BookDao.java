package com.example.flamassignment.Data.room;

import androidx.lifecycle.LiveData;
import androidx.room.*;

import com.example.flamassignment.Model.FavoriteBook;

import java.util.List;

@Dao
public interface BookDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(FavoriteBook book);

    @Query("SELECT * FROM favorites")
    LiveData<List<FavoriteBook>> getAllFavorites();
}