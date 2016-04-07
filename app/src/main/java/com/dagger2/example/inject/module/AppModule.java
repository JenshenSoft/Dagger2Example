package com.dagger2.example.inject.module;

import android.content.Context;

import com.dagger2.example.inject.qualifiers.ComputationScheduler;
import com.dagger2.example.inject.qualifiers.IOScheduler;
import com.dagger2.example.inject.qualifiers.UIScheduler;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@Module
public class AppModule implements IAppModule {

    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Override
    @Singleton
    @Provides
    public Context provideContext() {
        return context;
    }

    @Override
    @Provides
    @Singleton
    @IOScheduler
    public Scheduler provideIoScheduler() {
        return Schedulers.io();
    }

    @Override
    @Provides
    @Singleton
    @UIScheduler
    public Scheduler provideUiScheduler() {
        return AndroidSchedulers.mainThread();
    }

    @Override
    @Provides
    @Singleton
    @ComputationScheduler
    public Scheduler provideComputationScheduler() {
        return Schedulers.computation();
    }
}
