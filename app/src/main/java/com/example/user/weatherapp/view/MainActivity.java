package com.example.user.weatherapp.view;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.user.weatherapp.R;
import com.example.user.weatherapp.model_view.ModelView;
import com.example.user.weatherapp.presenter.Presenter;
import com.example.user.weatherapp.presenter.WeatherView;

import java.util.List;

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
    public void setWeatherData(List<ModelView> listWeather) {
        Typeface typeWeather = Typeface.createFromAsset(getAssets(),"fonts/weathericons-regular-webfont.ttf");
        recView.setLayoutManager(new LinearLayoutManager(this));
        recView.setHasFixedSize(false);
        RecViewAdapter recViewAdapter = new RecViewAdapter(listWeather,typeWeather);
        recView.setAdapter(recViewAdapter);
    }

    @Override
    public void startLoad() {

    }

    @Override
    public void finishLoad() {

    }
}
