package com.dagger2.example.inject.component;


import com.dagger2.example.PreviewActivity;
import com.dagger2.example.inject.module.AppModule;
import com.dagger2.example.inject.module.PreferenceModule;
import com.dagger2.example.inject.module.UtilsModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, PreferenceModule.class, UtilsModule.class})
public interface AppComponent extends IAppComponent {
    void inject(PreviewActivity previewActivity);
}

