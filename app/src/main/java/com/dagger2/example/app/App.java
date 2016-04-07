package com.dagger2.example.app;

import android.app.Application;

import com.annimon.stream.Optional;
import com.dagger2.example.entity.UserInfo;
import com.dagger2.example.inject.component.ApiComponent;
import com.dagger2.example.inject.component.AppComponent;
import com.dagger2.example.inject.component.DaggerApiComponent;
import com.dagger2.example.inject.component.DaggerAppComponent;
import com.dagger2.example.inject.component.UserSubComponent;
import com.dagger2.example.inject.module.ApiModule;
import com.dagger2.example.inject.module.AppModule;
import com.dagger2.example.inject.module.UserModule;

public class App extends Application implements UserLifeCycle {

    private static App application;

    private AppComponent appComponent;
    private ApiComponent apiComponent;
    private UserSubComponent userComponent;

    public static App getApplication() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;

    }

    public AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(this))
                    .build();
        }
        return appComponent;
    }

    public ApiComponent getApiComponent() {
        if (apiComponent == null) {
            apiComponent = DaggerApiComponent.builder()
                    .apiModule(new ApiModule("http//....."))
                    .appComponent(getAppComponent())
                    .build();
        }
        return apiComponent;
    }

    @Override
    public void onSignIn(UserInfo userInfo) {
        userComponent = apiComponent.plus(new UserModule(userInfo));
    }

    @Override
    public void onLogOut() {
       userComponent = null;
    }

    @Override
    public Optional<UserSubComponent> getUserComponent() {
        return Optional.ofNullable(userComponent);
    }
}
