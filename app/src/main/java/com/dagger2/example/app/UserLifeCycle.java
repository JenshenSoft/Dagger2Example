package com.dagger2.example.app;

import com.annimon.stream.Optional;
import com.dagger2.example.entity.UserInfo;
import com.dagger2.example.inject.component.UserSubComponent;

public interface UserLifeCycle {
    void onSignIn(UserInfo userInfo);

    void onLogOut();

    Optional<UserSubComponent> getUserComponent();
}