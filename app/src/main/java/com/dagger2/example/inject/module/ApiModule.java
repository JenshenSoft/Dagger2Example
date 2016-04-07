package com.dagger2.example.inject.module;

import com.dagger2.example.api.IApi;
import com.dagger2.example.api.error.CustomErrorHandler;
import com.dagger2.example.inject.qualifiers.FakeApi;
import com.dagger2.example.inject.qualifiers.RealApi;
import com.dagger2.example.manager.IApiManager;
import com.dagger2.example.manager.impl.ApiManager;
import com.dagger2.example.manager.impl.fake.FakeApiManager;
import com.squareup.okhttp.OkHttpClient;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

@Module
public class ApiModule {

    private final String baseUrl;

    public ApiModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Provides
    public OkHttpClient provideOkHttpClient() {
        return new OkHttpClient();
    }

    @Provides
    public RestAdapter provideRestAdapter(OkHttpClient okHttpClient) {
        return new RestAdapter.Builder()
                .setClient(new OkClient(okHttpClient))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setErrorHandler(new CustomErrorHandler())
                .setEndpoint(baseUrl)
                .build();
    }

    @Provides
    public IApi provideApi(RestAdapter restAdapter) {
        return restAdapter.create(IApi.class);
    }

    @RealApi
    @Provides
    public IApiManager provideApiManager(IApi api) {
        return new ApiManager(api);
    }

    @FakeApi
    @Provides
    public IApiManager provideFakeApiManager() {
        return new FakeApiManager();
    }
}
