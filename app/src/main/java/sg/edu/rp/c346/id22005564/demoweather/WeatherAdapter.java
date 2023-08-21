package sg.edu.rp.c346.id22005564.demoweather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WeatherAdapter extends ArrayAdapter<Weather> {
    private Context mContext;
    private ArrayList<Weather> mWeatherList;

    public WeatherAdapter(Context context, ArrayList<Weather> weatherList) {
        super(context, 0, weatherList);
        mContext = context;
        mWeatherList = weatherList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(mContext).inflate(R.layout.row, parent, false);
        }

        Weather currentWeather = mWeatherList.get(position);

        TextView areaTextView = listItem.findViewById(R.id.areaTextView);
        areaTextView.setText(currentWeather.getArea());

        TextView forecastTextView = listItem.findViewById(R.id.forecastTextView);
        forecastTextView.setText(currentWeather.getForecast());

        return listItem;
    }
}

