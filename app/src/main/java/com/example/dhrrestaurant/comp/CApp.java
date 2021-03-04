package com.example.dhrrestaurant.comp;

import android.app.Application;


import com.example.dhrrestaurant.networks.APIClient;

import retrofit2.Retrofit;

public class CApp extends Application {

    private static Retrofit apiClient;

    @Override
    public void onCreate()
    {
        super.onCreate();
        apiClient = APIClient.getClient();
    }

    public static Retrofit getAPIClient()
    {
        return apiClient;
    }
}
