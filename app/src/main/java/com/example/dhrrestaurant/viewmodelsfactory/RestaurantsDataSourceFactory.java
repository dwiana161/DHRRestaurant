package com.example.dhrrestaurant.viewmodelsfactory;

import android.arch.paging.DataSource;

import com.example.dhrrestaurant.comp.ProgressBarInterface;
import com.example.dhrrestaurant.entity.Categories;


public class RestaurantsDataSourceFactory extends DataSource.Factory{

    private com.example.dhrrestaurant.viewmodelsfactory.RestaurantsDataSource feedDataSource;
    private Categories.Category category;
    private long cityId;
    private ProgressBarInterface progressBarInterface;

    public RestaurantsDataSourceFactory(Categories.Category category, long cityId, ProgressBarInterface progressBarInterface)
    {
        this.category = category;
        this.cityId = cityId;
        this.progressBarInterface = progressBarInterface;
    }

    @Override
    public DataSource create() {
        feedDataSource = new com.example.dhrrestaurant.viewmodelsfactory.RestaurantsDataSource(category, cityId, progressBarInterface);
        return feedDataSource;
    }
}
