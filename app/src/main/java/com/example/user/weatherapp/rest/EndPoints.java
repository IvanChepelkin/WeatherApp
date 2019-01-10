package com.example.user.weatherapp.rest;

import com.example.user.weatherapp.model_presenter.Example;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EndPoints {
    @GET("/data/2.5/forecast?&units=metric&cnt=7&appid=f3f2763fe63803beef4851d6365c83bc")
    Flowable<Example>getWeatherFromServer(
            @Query("q") String city);
}
