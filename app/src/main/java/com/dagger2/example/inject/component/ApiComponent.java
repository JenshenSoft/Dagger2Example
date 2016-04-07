package com.dagger2.example.inject.component;


import com.dagger2.example.inject.module.ApiModule;
import com.dagger2.example.inject.module.UserModule;
import com.dagger2.example.inject.qualifiers.FakeApi;
import com.dagger2.example.inject.qualifiers.RealApi;
import com.dagger2.example.inject.scope.ApiScope;
import com.dagger2.example.manager.IApiManager;

import dagger.Component;

@ApiScope
@Component(dependencies = {AppComponent.class}, modules = {ApiModule.class})
public interface ApiComponent extends IAppComponent {

    @RealApi
    IApiManager provideApiManager();

    @FakeApi
    IApiManager provideFakeApiManager();

    UserSubComponent plus(UserModule module);
}

