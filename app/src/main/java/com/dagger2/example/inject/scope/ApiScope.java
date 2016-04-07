package com.dagger2.example.inject.scope;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@javax.inject.Scope
@Retention(RUNTIME)
public @interface ApiScope {
}