package com.example.dhrrestaurant.adapters;

import com.example.dhrrestaurant.entity.Categories;
import com.example.dhrrestaurant.entity.Restaurants;


public interface AdapterInterface {
    void onClick(Restaurants.Restaurant restaurant);
    void onClickSeeAll(Categories.Category category);
}
