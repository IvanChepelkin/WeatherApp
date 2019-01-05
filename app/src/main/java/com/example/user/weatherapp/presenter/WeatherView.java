package com.example.user.weatherapp.presenter;

import com.arellomobile.mvp.MvpView;
import com.example.user.weatherapp.model.Weather;

public interface WeatherView extends MvpView {

    void showError(Throwable e);

    void setWeatherData(Weather weather);

    void startLoad();

    void finishLoad();
}
