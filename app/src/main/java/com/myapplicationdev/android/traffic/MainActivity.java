package com.myapplicationdev.android.traffic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    ListView lv;
   CustomAdapter adapter;

    AsyncHttpClient client;

    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<cameras> alCam= new ArrayList<cameras>();

        client.get("https://api.data.gov.sg/v1/transport/traffic-images", new JsonHttpResponseHandler() {

            int camId;
//            int imageId;
            String timestamp;
            String imageUrl;

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONArray jsonArrItems = response.getJSONArray("items");
                    JSONObject firstObj = jsonArrItems.getJSONObject(0);
                    JSONArray jsonArrCam = firstObj.getJSONArray("cameras");
                    for(int i = 0; i < jsonArrCam.length(); i++) {
                        JSONObject jsonObjCam = jsonArrCam.getJSONObject(i);
                        camId = jsonObjCam.getInt("camera_id");
//                        imageId = jsonObjCam.getInt("timestamp");
                        timestamp = jsonObjCam.getString("timestamp");
                        imageUrl = jsonObjCam.getString("image");
                        cameras cam = new cameras(timestamp, imageUrl);
                        alCam.add(cam);
                    }
                }
                catch(JSONException e){

                }

                //POINT X – Code to display List View
                adapter = new CustomAdapter(MainActivity.this, R.layout.row, alCam);
                lv.setAdapter(adapter);

            }//end onSuccess
        });
    }//end onResume

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);
        client = new AsyncHttpClient();

    }
}