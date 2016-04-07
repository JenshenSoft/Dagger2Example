package com.dagger2.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.Toast;

import com.dagger2.example.app.App;
import com.dagger2.example.inject.qualifiers.IOScheduler;
import com.dagger2.example.inject.qualifiers.UIScheduler;
import com.dagger2.example.manager.IPreferenceManager;
import com.dagger2.example.utils.RxJavaUtils;

import javax.inject.Inject;

import rx.Scheduler;

public class PreviewActivity extends AppCompatActivity {

    //fields injection
    @Inject
    protected IPreferenceManager preferenceManager;

    @Inject
    protected Interactor interactor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        App.getApplication().getAppComponent().inject(this);

        Toast.makeText(PreviewActivity.this, "Click me", Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        return super.onTouchEvent(event);
    }

    public static class Interactor {

        private final IPreferenceManager preferenceManager;
        private final Scheduler ioScheduler;
        private final Scheduler uiScheduler;
        private RxJavaUtils rxJavaUtils;

        //constructor injection
        @Inject
        public Interactor(@IOScheduler Scheduler ioScheduler, @UIScheduler Scheduler uiScheduler) {
            this.ioScheduler = ioScheduler;
            this.uiScheduler = uiScheduler;
            this.preferenceManager = App.getApplication().getAppComponent().providePreferenceManager();
        }

        //setter injection
        @Inject
        public void appRxJavaUtils(RxJavaUtils rxJavaUtils) {
            this.rxJavaUtils = rxJavaUtils;
        }
    }
}
