package com.example.user.weatherapp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.user.weatherapp.R;
import com.example.user.weatherapp.model.Example;
import com.example.user.weatherapp.model_view.ModelView;
import com.example.user.weatherapp.rest.NetApiClient;
import com.example.user.weatherapp.rest.UserComponent;
import com.example.user.weatherapp.rest.DaggerUserComponent;
import com.example.user.weatherapp.rest.UserApi;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

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

        NetApiClient netApiClient = new NetApiClient();
        netApiClient.getWeather(city).subscribe(this);

        //NetApiClient.getInstance().getWeather(city).subscribe(this);


    }

    public void setItems(Example example) {
        List<ModelView> listWeather = new ArrayList<>();

        for (int i = 0; i < example.getList().size(); i++) {
            //добавляем прогноз только раз за 1 день
            if (i == 0 || i % 8 == 0) {
                listWeather.add(new ModelView(example.getCity().getName(),
                        example.getList().get(i).getDtTxt(),
                        setIconWeather(example.getList().get(i).getWeather().get(0).getId()),
                        example.getList().get(i).getMain().getHumidity(),
                        example.getList().get(i).getMain().getPressure(),
                        example.getList().get(i).getMain().getTemp()
                ));
            }
        }

        getViewState().setWeatherData(listWeather);
    }

    public int setIconWeather(int id) {

        int idIcon = 0;
        int count = id / 100;

        switch (count) {
            case 2:
                idIcon = R.string.weather_thunder;
                break;
            case 3:
                idIcon = R.string.weather_drizzle;
                break;
            case 5:
                idIcon = R.string.weather_rainy;
                break;
            case 6:
                idIcon = R.string.weather_snowy;
                break;
            case 7:
                idIcon = R.string.weather_foggy;
                break;
            case 8:
                idIcon = R.string.weather_cloudy;
                break;
        }
        return idIcon;
    }


}
