package com.example.user.weatherapp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.user.weatherapp.model.Weather;
import com.example.user.weatherapp.rest.NetApiClient;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@InjectViewState
public class Presenter extends MvpPresenter<WeatherView> implements Subscriber<Weather> {
    @Override
    public void attachView(WeatherView view) {
        super.attachView(view);
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

    public void loadData(String city) {
        getViewState().startLoad();
        NetApiClient.getInstance().getWeather(city).subscribe(this);
    }
}
