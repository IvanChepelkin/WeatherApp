package com.example.user.weatherapp.presenter;

import com.arellomobile.mvp.MvpView;
import com.example.user.weatherapp.model.WeatherModel;

import java.util.List;

public interface WeatherView extends MvpView {
    void showError(Throwable e);

    void setWeatherData(WeatherModel repsModels);

    void startLoad();

    void finishLoad();
}
