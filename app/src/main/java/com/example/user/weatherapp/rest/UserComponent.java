package com.example.user.weatherapp.rest;

import javax.inject.Singleton;

@Singleton
@dagger.Component(modules = {UserApiModul.class})
public interface UserComponent {
    UserApi getUserApiService();
}
