package com.dagger2.example.api;


import android.database.Observable;

import retrofit.http.PUT;

public interface IApi {

    @PUT("/users")
    Observable<String> getSomething();

}
