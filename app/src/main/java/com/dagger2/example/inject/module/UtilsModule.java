package com.dagger2.example.inject.module;

import android.content.Context;

import com.dagger2.example.utils.RxJavaUtils;

import dagger.Module;
import dagger.Provides;

@Module
public class UtilsModule  {

    @Provides
    public RxJavaUtils provideRxJavaUtils(Context context) {
        return new RxJavaUtils(context);
    }
}
