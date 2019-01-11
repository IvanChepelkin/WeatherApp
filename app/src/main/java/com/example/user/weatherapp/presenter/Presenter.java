package com.example.user.weatherapp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.user.weatherapp.model.Example;
import com.example.user.weatherapp.model_view.ModelView;
import com.example.user.weatherapp.rest.NetApiClient;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@InjectViewState
public class Presenter extends MvpPresenter<WeatherView> implements Subscriber<Example> {
    @Override
    public void attachView(WeatherView view) {
        super.attachView(view);
    }

    @Override
    public void onSubscribe(Subscription s) {
        s.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(Example example) {
        setItems(example);
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

    public void setItems(Example example) {
        List <ModelView> listWeather = new ArrayList<>();

        for (int i=0; i <=6; i++) {
                listWeather.add(new ModelView("Москва",
                        example.getList().get(i).getWeather().get(i).getId(),
                        example.getList().get(i).getMain().getTemp(),
                        example.getList().get(i).getMain().getHumidity(),
                        "привет"
                        ));
        }

        getViewState().setWeatherData(listWeather);
    }
}
