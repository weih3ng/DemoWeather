package sg.edu.rp.c346.id22005564.demoweather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class CarparkAdapter extends ArrayAdapter<Carpark> {
    private Context mContext;
    private ArrayList<Carpark> mCarparkList;

    public CarparkAdapter(Context context, ArrayList<Carpark> carparkList) {
        super(context, 0, carparkList);
        mContext = context;
        mCarparkList = carparkList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(mContext).inflate(R.layout.row_carpark, parent, false);
        }

        Carpark currentCarpark = mCarparkList.get(position);

        TextView carparkNumberTextView = listItem.findViewById(R.id.carparkNumberTextView);
        carparkNumberTextView.setText(currentCarpark.getCarparkNumber());

        TextView availabilityTextView = listItem.findViewById(R.id.availabilityTextView);
        String availability = "Available: " + currentCarpark.getLotsAvailable();
        availabilityTextView.setText(availability);

        return listItem;
    }
}

