package com.example.user.weatherapp.rest;

import com.example.user.weatherapp.model.Example;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EndPoints {
    // 1 деление cnt = 3 ч.
    @GET("/data/2.5/forecast?&units=metric&cnt=168&appid=f3f2763fe63803beef4851d6365c83bc")
    Flowable<Example>getWeatherFromServer(
            @Query("q") String city);
}
