package com.dagger2.example.inject.component;


import com.dagger2.example.UserInfoActivity;
import com.dagger2.example.inject.module.UserModule;
import com.dagger2.example.inject.scope.ApiScope;

import dagger.Subcomponent;


@ApiScope
@Subcomponent(modules = {UserModule.class})
public interface UserSubComponent {
    void inject(UserInfoActivity userInfoActivity);
}
