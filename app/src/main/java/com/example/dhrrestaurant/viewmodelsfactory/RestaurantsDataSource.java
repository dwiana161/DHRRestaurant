package com.example.dhrrestaurant.viewmodelsfactory;

import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;
import android.util.Log;


import com.example.dhrrestaurant.comp.ProgressBarInterface;
import com.example.dhrrestaurant.entity.Categories;
import com.example.dhrrestaurant.entity.Constant;
import com.example.dhrrestaurant.entity.Restaurants;
import com.example.dhrrestaurant.networks.APIRepo;

import java.util.List;

public class RestaurantsDataSource  extends PageKeyedDataSource<Long, Restaurants> {

    private Categories.Category category;
    long cityId;
    APIRepo apiRepo;
    private ProgressBarInterface progressBarInterface;

    public RestaurantsDataSource(Categories.Category category, long cityId, ProgressBarInterface progressBarInterface)
    {
        this.category = category;
        this.cityId = cityId;
        this.progressBarInterface = progressBarInterface;
        apiRepo = new APIRepo();
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Long> params, @NonNull LoadInitialCallback<Long, Restaurants> callback) {
        progressBarInterface.showProgress();
        List<Restaurants> result = apiRepo.getRestaurantsFromAPIAsPaging(cityId, Constant.TYPE_CITY, 0, category.getId());
        progressBarInterface.hideProgress();
        callback.onResult(result,null, 1L);
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Long> params, @NonNull LoadCallback<Long, Restaurants> callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Long> params, @NonNull LoadCallback<Long, Restaurants> callback) {

        long nextKey = (params.key == apiRepo.getTotalPages()) ? null : params.key + 1;
        Log.d("fatal", "nextKey:" + nextKey);
        long start = (Constant.LOAD_PAGE_SIZE * (nextKey - 1));
        progressBarInterface.showProgress();
        List<Restaurants> result = apiRepo.getRestaurantsFromAPIAsPaging(cityId, Constant.TYPE_CITY, start, category.getId());
        progressBarInterface.hideProgress();
        callback.onResult(result, nextKey);
    }
}
