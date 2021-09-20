package com.example.android.justjava;

import androidx.appcompat.app.AppCompatActivity;


import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.android.justjava.databinding.ActivityMainBinding;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

//public class MainActivity extends AppCompatActivity {
//
//    private ActivityMainBinding binding;
//    /** Tag for the log messages */
//    public static final String LOG_TAG = MainActivity.class.getSimpleName();
//
//    /** URL to query the USGS dataset for earthquake information */
//    private static final String USGS_REQUEST_URL =
//            "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2016-01-01&endtime=2016-05-02&minfelt=50&minmagnitude=5";
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        EarthquakeAsynctask task = new EarthquakeAsynctask();
//        task.execute(USGS_REQUEST_URL);
//
//
//    }
//
//    /**
//     * Update the screen to display information from the given {@link Event}.
//     */
//    private void updateUi(Event earthquake) {
//        TextView titleTextView = (TextView) findViewById(R.id.title);
//        titleTextView.setText(earthquake.title);
//
//        TextView tsunamiTextView = (TextView) findViewById(R.id.number_of_people);
//        tsunamiTextView.setText(getString(R.string.num_people_felt_it, earthquake.numOfPeople));
//
//        TextView magnitudeTextView = (TextView) findViewById(R.id.perceived_magnitude);
//        magnitudeTextView.setText(earthquake.perceivedStrength);
//    }
//
//    private class EarthquakeAsynctask extends AsyncTask<String, Void, Event>{
//
//        @Override
//        protected Event doInBackground(String... url) {
//            if (url.length < 1 || url[0] == null) {
//                return null;
//            }
//            // Perform the HTTP request for earthquake data and process the response.
//            Event result = Utils.fetchEarthquakeData(url[0]);
//            return result;
//        }
//        @Override
//        protected void onPostExecute(Event result){
//// If there is no result, do nothing.
//            if (result == null) {
//                return;
//            }
//// Update the information displayed to the user.
//            updateUi(result);
//        }
//    }
//}


