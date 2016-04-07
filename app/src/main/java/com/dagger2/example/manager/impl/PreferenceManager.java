package com.dagger2.example.manager.impl;

import android.content.Context;


import com.dagger2.example.manager.IPreferenceManager;
import com.google.gson.Gson;

public class PreferenceManager implements IPreferenceManager {

    private final Gson gson;

    public PreferenceManager(Context context) {
        this.gson = new Gson();
    }
}
