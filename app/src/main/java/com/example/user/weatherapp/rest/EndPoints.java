package com.example.user.weatherapp.rest;

import com.example.user.weatherapp.model.Main;
import com.example.user.weatherapp.model.Weather;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface EndPoints {
    @GET("/data/2.5/weather?q=Moscow&units=metric&appid=f3f2763fe63803beef4851d6365c83bc")
    Flowable<Weather>getWeatherFromServer();
}
