package com.example.user.weatherapp.rest;

import com.example.user.weatherapp.model.WeatherModel;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EndPoints {
    @GET("/data/2.5/weather?q={city}&units=metric")
    Flowable<List<WeatherModel>> getWeatherFromServer(
            @Path("city") String city);
}
