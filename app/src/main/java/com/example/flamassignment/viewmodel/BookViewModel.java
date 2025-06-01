package com.example.flamassignment.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.flamassignment.Model.Book;
import com.example.flamassignment.Model.FavoriteBook;
import com.example.flamassignment.repository.BookRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookViewModel extends AndroidViewModel {
    private MutableLiveData<List<Book>> books = new MutableLiveData<>();
    private BookRepository repository;

    public BookViewModel(@NonNull Application application) {
        super(application);
        repository = new BookRepository(application);
    }

    public LiveData<List<Book>> getBooks() {
        return books;
    }

    public void fetchBooks() {
        repository.fetchBooks(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                books.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                // Log error or fallback
            }
        });
    }

    public void saveToFavorites(Book book) {
        FavoriteBook fav = new FavoriteBook();
        fav.id = book.id;
        fav.title = book.title;
        fav.author = book.author;
        fav.description = book.description;
        fav.thumbnailUrl = book.thumbnailUrl;
        fav.rating = book.rating;
        repository.saveBookToRoom(fav);
    }

    public LiveData<List<FavoriteBook>> getFavorites() {
        return repository.getFavorites();
    }
}
