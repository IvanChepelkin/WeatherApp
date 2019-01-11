package com.example.user.weatherapp.presenter;

import com.arellomobile.mvp.MvpView;

import com.example.user.weatherapp.model_view.ModelView;

import java.util.List;

public interface WeatherView extends MvpView {

    void showError(Throwable e);

    void setWeatherData(List <ModelView> listWeather);

    void startLoad();

    void finishLoad();
}
