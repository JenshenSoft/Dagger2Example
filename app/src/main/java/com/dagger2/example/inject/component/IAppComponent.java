package com.dagger2.example.inject.component;

import android.content.Context;

import com.dagger2.example.inject.qualifiers.ComputationScheduler;
import com.dagger2.example.inject.qualifiers.IOScheduler;
import com.dagger2.example.inject.qualifiers.UIScheduler;
import com.dagger2.example.manager.IPreferenceManager;
import com.dagger2.example.utils.RxJavaUtils;

import rx.Scheduler;

public interface IAppComponent {

    Context provideContext();

    IPreferenceManager providePreferenceManager();

    @IOScheduler
    Scheduler provideIoScheduler();

    @UIScheduler
    Scheduler provideUiScheduler();

    @ComputationScheduler
    Scheduler provideComputationScheduler();

    RxJavaUtils provideRxJavaUtils();
}
