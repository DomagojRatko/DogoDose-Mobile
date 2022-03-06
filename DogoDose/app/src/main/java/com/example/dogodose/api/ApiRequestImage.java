package com.example.dogodose.api;

import android.widget.Toast;
import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.example.dogodose.MainActivity;
import com.google.gson.Gson;

public class ApiRequestImage {

    private Toast toast;
    private static String GET_IMAGE;

    public ApiRequestImage(MainActivity main, String api_url) {

        Cache cache = new DiskBasedCache (main.getCacheDir(), 1024*1024);
        Network network = new BasicNetwork(new HurlStack());
        RequestQueue requestQueue = new RequestQueue(cache, network);
        requestQueue.start();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, api_url, this::toGson, error -> {
            toast = Toast.makeText(main, "Network or API server error! (ERROR:IMAGE)", Toast.LENGTH_SHORT);
            toast.show();
        });
        requestQueue.add(stringRequest);

    }

    private void toGson(String response) {
        Gson gson = new Gson();
        ImageValueAPI imageValueAPI = gson.fromJson(response, ImageValueAPI.class);
        GET_IMAGE = imageValueAPI.getMessage();
    }

    public String getGET_IMAGE() { return GET_IMAGE; }
}
