package com.dagger2.example.inject.module;

import android.content.Context;

import rx.Scheduler;

public interface IAppModule {

    Context provideContext();

    Scheduler provideIoScheduler();

    Scheduler provideUiScheduler();

    Scheduler provideComputationScheduler();
}