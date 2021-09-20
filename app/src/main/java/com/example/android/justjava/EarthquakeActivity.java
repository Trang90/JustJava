package com.example.android.justjava;


import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import com.example.android.justjava.databinding.EarthquakeActivityBinding;

import java.util.ArrayList;
import java.util.List;


public class EarthquakeActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<List<Earthquake>> {

    private static final String LOG_TAG = EarthquakeActivity.class.getName();

    /**
     * Constant value for the earthquake loader ID. We can choose any integer.
     * This really only comes into play if you're using multiple loaders.
     */
    private static final int EARTHQUAKE_LOADER_ID = 1;

    private EarthquakeActivityBinding binding;
    private static final String USGS_REQUEST_URL =
            "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&minmag=6&limit=10";
    private EarthquakeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= EarthquakeActivityBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        mAdapter = new EarthquakeAdapter(this, new ArrayList<Earthquake>());

        //hiện bank textview, sau đó sẽ add text "not found" ở onLoadFinished
        binding.list.setEmptyView(binding.emptyView);


        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        binding.list.setAdapter(mAdapter);

        binding.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Earthquake currentEarthquake = mAdapter.getItem(position);
                Uri earthquakeUri = Uri.parse(currentEarthquake.getUrl());

                Intent intent= new Intent (Intent.ACTION_VIEW, earthquakeUri);
                startActivity(intent);
            }
        });




        // Get a reference to the ConnectivityManager to check state of network connectivity
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        // Get details on the currently active default data network
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        // If there is a network connection, fetch data
        if (networkInfo != null && networkInfo.isConnected()) {// Get a reference to the LoaderManager, in order to interact with loaders.
            LoaderManager.getInstance(this).initLoader(EARTHQUAKE_LOADER_ID, null, this);


        } else {
            // Otherwise, display error
            // First, hide loading indicator so error message will be visible

            binding.loadingIndicator.setVisibility(View.GONE);
            binding.emptyView.setText(R.string.no_internet_connection);
        }


        }


    @NonNull
    @Override
    public Loader<List<Earthquake>> onCreateLoader(int i, Bundle bundle) {
        // Create a new loader for the given URL
        Log.i (LOG_TAG,"Test: onCreateLoader()");
        return new EarthquakeLoader(this, USGS_REQUEST_URL);

    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<Earthquake>> loader, List<Earthquake> earthquakes) {
// Clear the adapter of previous earthquake data
        // Set empty state text to display "No earthquakes found."
        binding.loadingIndicator.setVisibility(View.GONE);
        binding.emptyView.setText(R.string.no_earthquakes);

        // Clear the adapter of previous earthquake data
        mAdapter.clear();
        // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (earthquakes != null && !earthquakes.isEmpty()) {
            mAdapter.addAll(earthquakes);
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<Earthquake>> loader) {
// Loader reset, so we can clear out our existing data.
        Log.i (LOG_TAG,"Test: onLoaderReset()");
        mAdapter.clear();
    }





    }
