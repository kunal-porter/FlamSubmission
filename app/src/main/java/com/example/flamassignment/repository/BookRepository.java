package com.example.flamassignment.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.flamassignment.Data.api.BookApiService;
import com.example.flamassignment.Data.api.RetrofitClient;
import com.example.flamassignment.Data.room.AppDatabase;
import com.example.flamassignment.Data.room.BookDao;
import com.example.flamassignment.Model.Book;
import com.example.flamassignment.Model.FavoriteBook;

import java.util.List;

import retrofit2.Callback;

public class BookRepository {
    private BookApiService apiService;
    private BookDao bookDao;

    public BookRepository(Context context) {
        apiService = RetrofitClient.getInstance().create(BookApiService.class);
        bookDao = AppDatabase.getInstance(context).bookDao();
    }

    public void fetchBooks(Callback<List<Book>> callback) {
        apiService.getBooks().enqueue(callback);
    }

    public void saveBookToRoom(FavoriteBook book) {
        new Thread(() -> bookDao.insert(book)).start();
    }

    public LiveData<List<FavoriteBook>> getFavorites() {
        return bookDao.getAllFavorites();
    }
}
