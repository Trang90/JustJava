package com.example.android.justjava;

import static android.view.View.GONE;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import java.util.ArrayList;
import java.util.List;

public class BookActivity extends  AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Book>>  {

    public static final String LOG_TAG = BookActivity.class.getSimpleName();

    private static final int BOOK_LOADER_ID = 1;

    ListView bookListView;
    boolean isConnected;

    private String mUrlRequestGoogleBooks = "";

    private TextView mEmptyStateTextView;

    private View circleProgressBar;

    private BookAdapter mAdapter;
    private SearchView mSearchViewField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        // Get a reference to the ConnectivityManager to check state of network connectivity
        final ConnectivityManager cm  = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        /**
         * At the beginning check the connection with internet and save result to (boolean) variable isConnected
         * Checking if network is available
         * If TRUE - work with LoaderManager
         * If FALSE - hide loading spinner and show emptyStateTextView
         */
        checkConnection(cm);

        bookListView = (ListView) findViewById(R.id.list);
        mAdapter = new BookAdapter( this, new ArrayList<Book>());
        bookListView.setAdapter(mAdapter);

        mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);
        bookListView.setEmptyView(mEmptyStateTextView);

        // Circle progress
        circleProgressBar = findViewById(R.id.loading_indicator);

        // Search button
        Button mSearchButton = (Button) findViewById(R.id.search_button);

        // Search field
        mSearchViewField = (SearchView) findViewById(R.id.search_view_field);
        mSearchViewField.onActionViewExpanded();
        mSearchViewField.setIconified(true);
        mSearchViewField.setQueryHint("Enter a book title");


        if (isConnected) {
            // Update URL and restart loader to displaying new result of searching
            updateQueryUrl(mSearchViewField.getQuery().toString());
            restartLoader();
            Log.i(LOG_TAG, "Search value: " + mSearchViewField.getQuery().toString());
        } else {
            mAdapter.clear();

            circleProgressBar.setVisibility(View.GONE);
            // Set mEmptyStateTextView visible
            mEmptyStateTextView.setVisibility(View.VISIBLE);
            // ...and display message: "No internet connection."
            mEmptyStateTextView.setText(R.string.no_internet_connection);
        }

        // Set an item click listener on the Search Button, which sends a request to
        // Google Books API based on value from Search View
        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check connection status
                checkConnection(cm);

                if (isConnected){
                    updateQueryUrl(mSearchViewField.getQuery().toString());
                    restartLoader();
                } else {
                    // Clear the adapter of previous book data
                    mAdapter.clear();
                    // Set mEmptyStateTextView visible
                    mEmptyStateTextView.setVisibility(View.VISIBLE);
                    // ...and display message: "No internet connection."
                    mEmptyStateTextView.setText(R.string.no_internet_connection);
                }

            }
        });

        bookListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Book currentBook = mAdapter.getItem(position);
                Uri bookUri = Uri.parse(currentBook.getUrlBook());

                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, bookUri);
                startActivity(websiteIntent);

            }
        });
    }

    /**
     * Check if query contains spaces if YES replace these with PLUS sign
     *
     * @param searchValue - user data from SearchView
     * @return improved String URL for making HTTP request
     */
    private String updateQueryUrl(String searchValue) {

        if (searchValue.contains(" ")) {
            searchValue = searchValue.replace(" ", "+");
        }

        StringBuilder sb = new StringBuilder();
        sb.append("https://www.googleapis.com/books/v1/volumes?q=").append(searchValue).append("&filter=paid-ebooks&maxResults=40");
        mUrlRequestGoogleBooks = sb.toString();
        return mUrlRequestGoogleBooks;
    }


    @NonNull
    @Override
    public Loader<List<Book>> onCreateLoader(int id, @Nullable Bundle args) {
        Log.i("There is no instance", ": Created new one loader at the beginning!");
        // Create a new loader for the given URL
        updateQueryUrl(mSearchViewField.getQuery().toString());
        return new BookLoader(this, mUrlRequestGoogleBooks);
    }


    @Override
    public void onLoadFinished(@NonNull androidx.loader.content.Loader<List<Book>> loader, List<Book> books) {
        circleProgressBar.setVisibility(GONE);
        mEmptyStateTextView.setText(R.string.no_books);
        mAdapter.clear();
        // If there is a valid list of {@link Book}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (books != null && !books.isEmpty()) {
            mAdapter.addAll(books);
        }
    }

    @Override
    public void onLoaderReset(@NonNull androidx.loader.content.Loader<List<Book>> loader) {
        mAdapter.clear();
        Log.i(LOG_TAG, ": Loader reset, so we can clear out our existing data!");
    }




    public void checkConnection(ConnectivityManager connectivityManager) {
        // Status of internet connection
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        if (activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting()) {
            isConnected = true;

            Log.i(LOG_TAG, "INTERNET connection status: " + String.valueOf(isConnected) + ". It's time to play with LoaderManager :)");

        } else {
            isConnected = false;

        }
    }

    public void restartLoader() {
        mEmptyStateTextView.setVisibility(GONE);
        circleProgressBar.setVisibility(View.VISIBLE);
        getSupportLoaderManager().restartLoader(BOOK_LOADER_ID, null, BookActivity.this);
    }




}