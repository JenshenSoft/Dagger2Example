package com.dagger2.example.inject.module;

import android.content.Context;

import com.dagger2.example.manager.IPreferenceManager;
import com.dagger2.example.manager.impl.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PreferenceModule {

    @Singleton
    @Provides
    protected IPreferenceManager providePreferenceManager(Context context) {
        return new PreferenceManager(context);
    }
}
