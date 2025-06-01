package com.example.flamassignment.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.flamassignment.Model.FavoriteBook;
import com.example.flamassignment.repository.BookRepository;

import java.util.List;

public class FavoriteViewModel extends AndroidViewModel {

    private final BookRepository repository;
    private final LiveData<List<FavoriteBook>> favoriteBooks;

    public FavoriteViewModel(@NonNull Application application) {
        super(application);
        repository = new BookRepository(application);
        favoriteBooks = repository.getFavorites();
    }

    public void insert(FavoriteBook book) {
        repository.saveBookToRoom(book);
    }

    public LiveData<List<FavoriteBook>> getAllFavorites() {
        return favoriteBooks;
    }
}

