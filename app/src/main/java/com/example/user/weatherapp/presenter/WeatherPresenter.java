package com.example.user.weatherapp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.user.weatherapp.model_presenter.Example;
import com.example.user.weatherapp.rest.NetApiClient;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@InjectViewState
public class WeatherPresenter extends MvpPresenter<WeatherView> implements Subscriber<Example> {
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
        getViewState().setWeatherData(example);
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

// Данное расширение для класса WeatherPresenter написано с учетом моих
// наискуднейших знаний языка Java. Почти все методы придуманы и их 
// нужно заменить на что-то значимое, но надеюсь ты во всем разберешься :)
public class WeatherPresenter implements IWeatherPresenter {
    void loadWeather() {
        // вызов сервиса загрузки погоды
        Weather weather = WeatherService.instance.loadWeather()
        // проверка правильности загруженных данных
        if weather.isLoader {
            // отображаем погоду на экране
            view.setWeatherData(weather)
        } else {
            // отображаем на экране ошибку
            view.showError()
        }
        
    }
}