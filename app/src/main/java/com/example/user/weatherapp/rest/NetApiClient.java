package com.example.user.weatherapp.rest;

import com.example.user.weatherapp.model.Example;

import javax.inject.Singleton;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class NetApiClient {

    UserComponent daggerUserComponent = DaggerUserComponent.builder().build();
    private UserApi netApi = daggerUserComponent.getUserApiService();

    public NetApiClient() {
    }

    public Flowable<Example> getWeather(String city) {
        return netApi.getWeatherFromServer(city)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
