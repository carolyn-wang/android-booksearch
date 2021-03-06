package com.codepath.android.booksearch.activities;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.codepath.android.booksearch.R;
import com.codepath.android.booksearch.models.Book;

import org.parceler.Parcels;


public class BookDetailActivity extends AppCompatActivity {
    private ImageView ivBookCover;
    private TextView tvTitle;
    private TextView tvAuthor;
    String imageUrl;
    Book book;

    private androidx.appcompat.widget.Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        // Fetch views
        ivBookCover = (ImageView) findViewById(R.id.ivBookCover);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvAuthor = (TextView) findViewById(R.id.tvAuthor);

        // Extract book object from intent extras
        book = (Book) Parcels.unwrap(getIntent().getParcelableExtra(Book.class.getSimpleName()));
        Log.i("Book Detail", book.getTitle());


        tvTitle.setText(book.getTitle());
        tvAuthor.setText(book.getAuthor());
        // get and set cover image
        imageUrl = book.getCoverUrl();
        Glide.with(this).load(imageUrl).into(ivBookCover);

        // update ActionBar text
//        ActionBar actionBar = getSupportActionBar(); // or getActionBar();
//        getSupportActionBar().setTitle(book.getTitle()); // set the top title


        // Checkpoint #5
        // Reuse the Toolbar previously used in the detailed activity by referring to this guide
        // Follow using a Toolbar guide to set the Toolbar as the ActionBar.
        // Change activity title to reflect the book title by referring to the Configuring The ActionBar guide.
        // (Bonus) Get additional book information like publisher and publish_year from the Books API and display in details view.

        //  Set the Toolbar as the ActionBar
        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_book_detail, menu);
        // Checkpoint #6
        // Add Share Intent
        // see http://guides.codepath.org/android/Sharing-Content-with-Intents#shareactionprovider
        // (Bonus) Share book title and cover image using the same intent.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
