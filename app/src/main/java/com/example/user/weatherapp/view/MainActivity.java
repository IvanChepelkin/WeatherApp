package com.example.user.weatherapp.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.user.weatherapp.R;
import com.example.user.weatherapp.model.Weather;
import com.example.user.weatherapp.presenter.Presenter;
import com.example.user.weatherapp.presenter.WeatherView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends MvpAppCompatActivity implements WeatherView {
    @InjectPresenter
    Presenter presenter;
    @BindView(R.id.cityName)
    EditText cityName;
    @BindView(R.id.recView)
    RecyclerView recView;
//    @BindView(R.id.ok)
//    Button ok;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Привязываем наши вюшки к этому классу
        ButterKnife.bind(this);
    }

    @OnClick(R.id.ok)
    void onSaveClick(){
        presenter.loadData(cityName.getText().toString());

    }

    @Override
    public void showError(Throwable e) {
        Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setWeatherData(Weather weather) {
        recView.setLayoutManager(new LinearLayoutManager(this));
        recView.setHasFixedSize(false);
        RecViewAdapter recViewAdapter = new RecViewAdapter(weather);
        recView.setAdapter(recViewAdapter);
    }

    @Override
    public void startLoad() {

    }

    @Override
    public void finishLoad() {

    }
}
