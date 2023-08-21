//package sg.edu.rp.c346.id22005564.demoweather;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.annotation.SuppressLint;
//import android.os.Bundle;
//import android.widget.ListView;
//
//import com.loopj.android.http.AsyncHttpClient;
//import com.loopj.android.http.JsonHttpResponseHandler;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.util.ArrayList;
//
//import cz.msebera.android.httpclient.Header;
//
//
//public class MainActivity extends AppCompatActivity {
//
//    ListView lvWeather;
//    AsyncHttpClient client;
//
//    @SuppressLint("MissingInflatedId")
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        lvWeather = findViewById(R.id.lvWeather);
//        client = new AsyncHttpClient();
//
//
//    }
//    @Override
//    protected void onResume() {
//        super.onResume();
//        ArrayList<Weather> alWeather = new ArrayList<Weather>();
//        client.get("https://api.data.gov.sg/v1/transport/carpark-availability", new JsonHttpResponseHandler() {
//            String area;
//            String forecast;
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
//                try {
//                    JSONArray jsonArrItems = response.getJSONArray("items");
//                    JSONObject firstObj = jsonArrItems.getJSONObject(0);
//                    JSONArray jsonArrForecasts = firstObj.getJSONArray("forecasts");
//                    for(int i = 0; i < jsonArrForecasts.length(); i++) {
//                        JSONObject jsonObjForecast = jsonArrForecasts.getJSONObject(i);
//                        area = jsonObjForecast.getString("area");
//                        forecast = jsonObjForecast.getString("forecast");
//                        Weather weather = new Weather(area, forecast);
//                        alWeather.add(weather);
//                    }
//
//                }
//                catch(JSONException e){
//                }
//                //POINT X – Code to display List View
//                WeatherAdapter adapter = new WeatherAdapter(MainActivity.this, alWeather);
//                lvWeather.setAdapter(adapter);
//
//            }//end onSuccess
//        });
//    }//end onResume
//
//
//}
package sg.edu.rp.c346.id22005564.demoweather;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    ListView lvCarpark;
    AsyncHttpClient client;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvCarpark = findViewById(R.id.lvCarpark);
        client = new AsyncHttpClient();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ArrayList<Carpark> carparkList = new ArrayList<>();
        client.get("https://api.data.gov.sg/v1/transport/carpark-availability", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONArray itemsArray = response.getJSONArray("items");
                    JSONObject firstObj = itemsArray.getJSONObject(0);
                    JSONArray carparkDataArray = firstObj.getJSONArray("carpark_data");

                    for (int i = 0; i < carparkDataArray.length(); i++) {
                        JSONObject carparkObj = carparkDataArray.getJSONObject(i);
                        String carparkNumber = carparkObj.getString("carpark_number");

                        JSONArray carparkInfoArray = carparkObj.getJSONArray("carpark_info");
                        JSONObject carparkInfoObj = carparkInfoArray.getJSONObject(0);
                        String lotsAvailable = carparkInfoObj.getString("lots_available");

                        Carpark carpark = new Carpark(carparkNumber, lotsAvailable);
                        carparkList.add(carpark);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                // Code to display List View
                CarparkAdapter adapter = new CarparkAdapter(MainActivity.this, carparkList);
                lvCarpark.setAdapter(adapter);
            }
        });
    }
}


