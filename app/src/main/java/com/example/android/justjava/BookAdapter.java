package com.example.android.justjava;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {

    private static final String LOG_TAG = BookAdapter.class.getSimpleName();

    public BookAdapter(@NonNull Context context, List<Book> book) {
        super(context, 0, book);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            Book currentBook = getItem(position);

            TextView titleBookTextView = (TextView) listItemView.findViewById(R.id.book_title);
            TextView authorBookTextView = (TextView) listItemView.findViewById(R.id.author);
            ImageView coverImageView = (ImageView) listItemView.findViewById(R.id.cover_image);
            TextView priceBookTextView = (TextView) listItemView.findViewById(R.id.book_price);
            TextView languageCode = (TextView) listItemView.findViewById(R.id.country_code);
            TextView currencyCode = (TextView) listItemView.findViewById(R.id.currency_code);

            // Set proper value in each fields
            assert currentBook != null;
            titleBookTextView.setText(currentBook.getTitle());
            authorBookTextView.setText(currentBook.getAuthor());
            Picasso.get().load(currentBook.getImageUrl()).into(coverImageView);
            priceBookTextView.setText(String.valueOf(formatPrice(currentBook.getPrice())));
            languageCode.setText(currentBook.getLanguage());
            currencyCode.setText(currentBook.getCurrency());

            Log.i(LOG_TAG, "ListView has been returned");


        }

        return listItemView;
    }

    private String formatPrice(double price) {
        DecimalFormat priceFormat = new DecimalFormat("0.00");
        return priceFormat.format(price);
    }
}
