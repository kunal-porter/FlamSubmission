package com.example.flamassignment.Data.api;

import com.example.flamassignment.Model.Book;

import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;

public interface BookApiService {
    @GET("v1/e7e5f17d-5f6f-42f3-b678-1e72e2b1f389")
     Call<List<Book>> getBooks();
}
