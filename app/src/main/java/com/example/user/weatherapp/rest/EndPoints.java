package com.example.user.weatherapp.rest;

import com.example.user.weatherapp.model.Main;
import com.example.user.weatherapp.model.Weather;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EndPoints {
    @GET("/data/2.5/weather?&units=metric&appid=f3f2763fe63803beef4851d6365c83bc")
    Flowable<Weather>getWeatherFromServer(
            @Query("q") String city);
}
