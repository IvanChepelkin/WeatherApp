package com.example.user.weatherapp.rest;

import com.example.user.weatherapp.model.Weather;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class NetApiClient {
    private static final NetApiClient ourInstance = new NetApiClient();

    public static NetApiClient getInstance() {
        return ourInstance;
    }

    // возвр объект с  методами для выхода в сеть
    private EndPoints netApi = new ServiceGenerator().createService(EndPoints.class);

    private NetApiClient() {
    }

    public Flowable<Weather> getWeather(String city) {
        return netApi.getWeatherFromServer(city)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
