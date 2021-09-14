package com.example.android.justjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ReportCardAdapter extends ArrayAdapter<ReportCard> {


    public ReportCardAdapter(@NonNull Context context, ArrayList<ReportCard> reportCard) {
        super(context, 0, reportCard);

    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View reportCard = convertView;
        if (reportCard== null){
            reportCard= LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

            ReportCard currentReport = getItem(position);
            TextView reportName = (TextView) reportCard.findViewById(R.id.tv_name);
            reportName.setText(currentReport.getmName());

            TextView reportEng = (TextView) reportCard.findViewById(R.id.tv_english);
            reportEng.setText(currentReport.getmEnglish());

            TextView reportMath = reportCard.findViewById(R.id.tv_math);
            reportMath.setText(currentReport.getmMath());
        }


        return reportCard;
    }
}
