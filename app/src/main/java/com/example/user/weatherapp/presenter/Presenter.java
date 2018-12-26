package com.example.user.weatherapp.presenter;

import com.arellomobile.mvp.MvpPresenter;
import com.example.user.weatherapp.model.WeatherModel;
import com.example.user.weatherapp.rest.NetApiClient;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class Presenter extends MvpPresenter<WeatherView> implements Subscriber<WeatherModel>{
    @Override
    public void attachView(WeatherView view) {
        super.attachView(view);
        loadData();
    }

    @Override
    public void onSubscribe(Subscription s) {

    }

    @Override
    public void onNext(WeatherModel weatherModel) {

    }

    @Override
    public void onError(Throwable t) {

    }

    @Override
    public void onComplete() {

    }

    private void loadData() {
        getViewState().startLoad();
        NetApiClient.getInstance().getWeather("Moscow").subscribe(this);
    }
}
