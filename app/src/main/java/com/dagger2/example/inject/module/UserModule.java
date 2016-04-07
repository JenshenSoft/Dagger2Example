package com.dagger2.example.inject.module;

import android.content.Context;

import com.dagger2.example.entity.UserInfo;
import com.dagger2.example.utils.StringUtils;
import com.dagger2.example.utils.ViewUtils;

import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {

    private final UserInfo userInfo;

    public UserModule(UserInfo userInfo) {

        this.userInfo = userInfo;
    }

    @Provides
    public ViewUtils provideViewUtils(Context context) {
        return new ViewUtils(context);
    }


    @Provides
    public StringUtils provideStringUtils(Context context) {
        return new StringUtils(context);
    }

    @Provides
    public UserInfo provideUserInfo() {
        return userInfo;
    }
}
