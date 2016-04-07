package com.dagger2.example.inject.component;


import com.dagger2.example.MainActivity;
import com.dagger2.example.inject.module.MainActivityModule;
import com.dagger2.example.inject.scope.ActivityScope;

import dagger.Component;


@ActivityScope
@Component(dependencies = {ApiComponent.class}, modules = {MainActivityModule.class})
public interface ActivityComponent extends AppComponent {
    void inject(MainActivity activity);
}
