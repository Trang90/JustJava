package com.example.android.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.android.justjava.databinding.ActivityMainBinding;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<ReportCard> cards = new ArrayList<>();


        ReportCardAdapter adapter = new ReportCardAdapter(this, cards);
        binding.numberGridView.setAdapter(adapter);
            }


//    public void openNumberLists (View view) {
//
//        Intent intent = new Intent(this, NumberActivity.class);
//        startActivity(intent);
//
//    }

}


