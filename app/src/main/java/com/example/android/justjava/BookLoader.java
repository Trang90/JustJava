package com.example.android.justjava;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.util.List;

public class BookLoader extends AsyncTaskLoader<List<Book>> {

    private static final String LOG_TAG = BookLoader.class.getName();
    /** Query URL */
    private String mUrl;

    public BookLoader(@NonNull Context context, String url) {
        super(context);
        mUrl=url;
    }

    @Override
    public void onStartLoading(){
        forceLoad();
        Log.i("On start loading", ": Force loaded!");
    }

    @Nullable
    @Override
    public List<Book> loadInBackground() {
        if( mUrl ==null){
            return null;
        }
        // Perform the network request, parse the response, and extract a list of books.
        List<Book> books = Utils.fetchBookData(mUrl);
        Log.i(LOG_TAG, ": Loaded in background!");
        return books;

    }
}
