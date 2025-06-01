package com.example.flamassignment.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "favorites")
public class FavoriteBook {
    @PrimaryKey
    public int id;
    public String title;
    public String author;
    public String thumbnailUrl;
    public String description;
    public float rating;
}
