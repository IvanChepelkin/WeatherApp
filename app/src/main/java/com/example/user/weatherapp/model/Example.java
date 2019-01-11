package com.example.user.weatherapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Example {
    @SerializedName("cod")
    @Expose
    private String cod;
    @SerializedName("message")
    @Expose
    private float message;
    @SerializedName("cnt")
    @Expose
    private int cnt;
    @SerializedName("list")
    @Expose
    private List<ListWeekWeather> list;
    @SerializedName("city")
    @Expose
    private City city;

    public String getCod() {
        return cod;
    }

    public float getMessage() {
        return message;
    }

    public int getCnt() {
        return cnt;
    }

    public List<ListWeekWeather> getList() {
        return list;
    }

    public City getCity() {
        return city;
    }

}

//  {
//        "cod":"200",
//        "message":0.004,
//        "cnt":7,
//        "list":[
//           {
//               "dt":1546765200,
//               "main":{
//                   "temp":-7.09,
//                   "temp_min":-8.24,
//                   "temp_max":-7.09,
//                   "pressure":1012.55,
//                   "sea_level":1033.85,
//                   "grnd_level":1012.55,
//                   "humidity":89,
//                   "temp_kf":1.14
//           },
//          "weather":[
//             {
//                   "id":600,
//                   "main":"Snow",
//                   "description":"light snow",
//                   "icon":"13d"
//             }
//           ],
//            "dt_txt": "2019-01-12 03:00:00"
//         }
//       ],"city": {
//        "id": 524901,
//        "name": "Moscow",
//        "coord": {
//            "lat": 55.7507,
//            "lon": 37.6177
//        }
//     }
//  }
