package com.example.user.weatherapp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.user.weatherapp.model.Main;
import com.example.user.weatherapp.model.Weather;
import com.example.user.weatherapp.rest.NetApiClient;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@InjectViewState
public class Presenter extends MvpPresenter<WeatherView> implements Subscriber<Weather> {
    @Override
    public void attachView(WeatherView view) {
        super.attachView(view);
        loadData();
    }

    @Override
    public void onSubscribe(Subscription s) {
        s.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(Weather weather) {
        getViewState().setWeatherData(weather);
    }

    @Override
    public void onError(Throwable t) {
        getViewState().showError(t);
        getViewState().finishLoad();
    }

    @Override
    public void onComplete() {

    }

    private void loadData() {
        getViewState().startLoad();
        NetApiClient.getInstance().getWeather().subscribe(this);
    }
}
