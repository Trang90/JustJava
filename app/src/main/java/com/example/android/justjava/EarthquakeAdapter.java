package com.example.android.justjava;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOCATION_SEPARATOR = " of ";

    String cityName;
    String locationOffset;

    public EarthquakeAdapter(@NonNull Context context, List<Earthquake> earthquake) {
        super(context, 0, earthquake);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

            Earthquake currentList = getItem(position);

            TextView magnitude = (TextView) listItem.findViewById(R.id.number);
            GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();
            /**
             * getBackground từ textview, dùng hàm getMagnitudeColor lấy màu, add màu và text vào
             */

            int color = getMagnitudeColor(currentList.getMagnitude());
            magnitudeCircle.setColor(color);
            magnitude.setText(currentList.getMagnitude().toString());

            /**
             * Cách khác để dùng Decimal, thay vì dùng toString().
             */

//            String formatedDecimal = formatMagnitude(currentList.getMagnitude());
//            magnitude.setText(formatedDecimal);


            /**
             * Tách vị trí.
             */

            String wholeLocation = currentList.getLocation();

            //nếu city chứa chữ of (hàm contrains trả về boolean)
            if (wholeLocation.contains(LOCATION_SEPARATOR)) {
                String[] part = wholeLocation.split(LOCATION_SEPARATOR);
                locationOffset = part[0] + LOCATION_SEPARATOR;
                cityName = part[1];
            //nếu ko có thì dùng từ "near the"
            } else {
                locationOffset = getContext().getString(R.string.near_the);
                cityName = wholeLocation;
            }
            TextView city = (TextView) listItem.findViewById(R.id.city);
            city.setText(cityName);

            TextView location = (TextView) listItem.findViewById(R.id.location);
            location.setText(locationOffset);

            /**
             * tách và convert ngày tháng, thời gian
             */
            TextView date = (TextView) listItem.findViewById(R.id.date);

            Date dateObject = new Date(currentList.getDate());

            String formatedDate = formatDate(dateObject);
            date.setText(formatedDate);

            TextView timeView = (TextView) listItem.findViewById(R.id.time);
            String formatedTime = formatTime(dateObject);
            timeView.setText(formatedTime);
        }
        return listItem;
    }

    //(i.e. "Mar 3, 1984")
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    /**
     * Cách khác để dùng Decimal, thay vì dùng toString().
     */
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) magnitude; //làm cho 1.2 thành 1
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }

        //Chuyển magnitudeColorResourceId thành giá trị màu thực tế
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
