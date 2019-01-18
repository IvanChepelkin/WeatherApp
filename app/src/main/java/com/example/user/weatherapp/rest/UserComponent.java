package com.example.user.weatherapp.rest;

@dagger.Component(modules = {UserApiModul.class})
public interface UserComponent {
    UserApi getUserApiService();
}
