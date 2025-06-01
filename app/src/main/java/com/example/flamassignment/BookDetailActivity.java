package com.example.flamassignment;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.flamassignment.Model.Book;

public class BookDetailActivity extends AppCompatActivity {

    private TextView textTitle, textAuthor, textRating, textDescription;
    private Button buttonFavorite;
    private Book book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        textTitle = findViewById(R.id.textTitle);
        textAuthor = findViewById(R.id.textAuthor);
        textRating = findViewById(R.id.textRating);
        textDescription = findViewById(R.id.textDescription);
        buttonFavorite = findViewById(R.id.buttonFavorite);

        book = (Book) getIntent().getSerializableExtra("book");

        if (book != null) {
            textTitle.setText(book.title);
            textAuthor.setText(book.author);
            textRating.setText("Rating: " + book.rating);
            textDescription.setText(book.description);
        }

        buttonFavorite.setOnClickListener(v -> {
            Toast.makeText(this, "Book saved to favorites!", Toast.LENGTH_SHORT).show();
        });
    }
}
