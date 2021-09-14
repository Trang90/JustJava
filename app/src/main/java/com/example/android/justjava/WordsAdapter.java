package com.example.android.justjava;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class WordsAdapter extends ArrayAdapter<Word> {

    public WordsAdapter(Activity context, ArrayList<Word> words) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView==null){
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent,false);
            Word currentWord = getItem(position);
            TextView miWok = (TextView) listItemView.findViewById(R.id.miwok_tv);
            miWok.setText(currentWord.getMiwokTranslation());

            TextView defaultTv = (TextView) listItemView.findViewById(R.id.defaut_tv);
            defaultTv.setText(currentWord.getDefautTranslation());


        }

        return listItemView;
    }
    //    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        // Check if the existing view is being reused, otherwise inflate the view
//        View listItemView = convertView;
//        if(listItemView == null) {
//            listItemView = LayoutInflater.from(getContext()).inflate(
//                    R.layout.list_item, parent, false);
//        }
//
//        // Get the {@link AndroidFlavor} object located at this position in the list
//        Word currentWord = getItem(position);
//
//        // Find the TextView in the list_item.xml layout with the ID version_name
//        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_tv);
//        // Get the version name from the current AndroidFlavor object and
//        // set this text on the name TextView
//        miwokTextView.setText(currentWord.getMiwokTranslation());
//
//        // Find the TextView in the list_item.xml layout with the ID version_number
//        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.defaut_tv);
//        // Get the version number from the current AndroidFlavor object and
//        // set this text on the number TextView
//        defaultTextView.setText(currentWord.getDefautTranslation());
//
//        // Return the whole list item layout (containing 2 TextViews and an ImageView)
//        // so that it can be shown in the ListView
//        return listItemView;
//    }




}

