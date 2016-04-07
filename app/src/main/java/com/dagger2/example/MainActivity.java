package com.dagger2.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.dagger2.example.app.App;
import com.dagger2.example.app.UserLifeCycle;
import com.dagger2.example.entity.UserInfo;
import com.dagger2.example.inject.component.ActivityComponent;
import com.dagger2.example.inject.component.DaggerActivityComponent;
import com.dagger2.example.inject.qualifiers.FakeApi;
import com.dagger2.example.manager.IApiManager;
import com.dagger2.example.manager.IPreferenceManager;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    protected IPreferenceManager preferenceManager;

    @FakeApi
    @Inject
    protected IApiManager apiManager;

    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityComponent = DaggerActivityComponent.builder().apiComponent(App.getApplication().getApiComponent()).build();
        activityComponent.inject(this);
        Button button = (Button) findViewById(R.id.button);
        assert button != null;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //implemented soon
                //apiManager.getUserInfo();
                UserLifeCycle userLifeCycle = App.getApplication();
                userLifeCycle.onSignIn(new UserInfo("Petya"));
                Intent intent = new Intent(MainActivity.this, UserInfoActivity.class);
                startActivity(intent);
            }
        });
    }
}
