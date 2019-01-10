package com.example.user.weatherapp.presenter;

import com.arellomobile.mvp.MvpView;
import com.example.user.weatherapp.model_presenter.Example;

public interface WeatherView extends MvpView {

    void showError(Throwable e);

    void setWeatherData(Example example);

    void startLoad();

    void finishLoad();
}
