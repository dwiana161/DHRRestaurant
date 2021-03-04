package com.example.dhrrestaurant.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.dhrrestaurant.entity.Location;
import com.example.dhrrestaurant.networks.APIRepo;


import java.util.List;

public class LocationViewModel extends ViewModel{

    public LocationViewModel(){}

    public LiveData<List<Location>> getLocationSuggestionsFromApi(String query)
    {
        APIRepo apiRepo = new APIRepo();
        return apiRepo.getLocationSuggestions(query);
    }

}
