package com.example.user.weatherapp.view;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.user.weatherapp.R;
import com.example.user.weatherapp.model.Example;
import com.example.user.weatherapp.presenter.Presenter;
import com.example.user.weatherapp.presenter.WeatherView;

public class RecViewAdapter extends RecyclerView.Adapter<RecViewAdapter.RecViewHolder>{

    private Example example;
    private Typeface typeWeather;

    public RecViewAdapter(Example example, Typeface typeWeather) {
        this.example = example;
        this.typeWeather = typeWeather;
    }

    @NonNull
    @Override
    public RecViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rec_view_data_weather, viewGroup, false);
        return new RecViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecViewHolder recViewHolder, int i) {
//        String temper = String.valueOf(weatherDay.getMain().getTemp());
//        String press = String.valueOf(weatherDay.getMain().getPressure());
//        String humi = String.valueOf(weatherDay.getMain().getHumidity());
//        String tempMa = String.valueOf(weatherDay.getMain().getTempMax());
//        String tempMi = String.valueOf(weatherDay.getMain().getTempMin());

        String temper = String.valueOf(Math.round(example.getList().get(i).getMain().getTemp()));
        String press = String.valueOf(Math.round((example.getList().get(i).getMain().getPressure()*100)/133.32));
        String humi = String.valueOf(example.getList().get(i).getMain().getHumidity());



        recViewHolder.temp.setText(temper);
        recViewHolder.pressure.setText(press);
        recViewHolder.humidity.setText(humi);
//       recViewHolder.tempMax.setText(tempMa);
//       recViewHolder.tempMin.setText(tempMi);
        recViewHolder.weather_icon.setTypeface(typeWeather);
        recViewHolder.weather_icon.setText(R.string.weather_cloudy);
    }

    @Override
    public int getItemCount() {
        return example.getList().size();
    }


    class RecViewHolder extends RecyclerView.ViewHolder {
        private TextView temp;
        private TextView pressure;
        private TextView humidity;
        private TextView tempMax;
        private TextView tempMin;
        private TextView weather_icon;

        public RecViewHolder(@NonNull View itemView) {
            super(itemView);
            temp = itemView.findViewById(R.id.temp);
            pressure = itemView.findViewById(R.id.pressure);
            humidity = itemView.findViewById(R.id.humidity);
            tempMax = itemView.findViewById(R.id.tempMax);
            tempMin = itemView.findViewById(R.id.tempMin);
            weather_icon = itemView.findViewById(R.id.weather_icon);

        }
    }
}
