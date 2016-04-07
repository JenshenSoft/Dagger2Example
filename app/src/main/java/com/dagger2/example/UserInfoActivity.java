package com.dagger2.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.annimon.stream.Optional;
import com.dagger2.example.app.App;
import com.dagger2.example.app.UserLifeCycle;
import com.dagger2.example.entity.UserInfo;
import com.dagger2.example.inject.component.UserSubComponent;
import com.dagger2.example.utils.StringUtils;
import com.dagger2.example.utils.ViewUtils;

import javax.inject.Inject;
import javax.inject.Provider;

import dagger.Lazy;

public class UserInfoActivity extends AppCompatActivity {

    @Inject
    protected UserInfo userInfo;

    @Inject
    protected Lazy<StringUtils> stringUtils;

    @Inject
    protected Provider<ViewUtils> viewUtils;


    private UserLifeCycle userLifeCycle;

    public UserInfoActivity() {
        userLifeCycle = App.getApplication();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinfo);

        final Optional<UserSubComponent> userComponent = userLifeCycle.getUserComponent();
        if (userComponent.isPresent()) {
            userComponent.get().inject(this);

            final ViewUtils viewUtils1 = this.viewUtils.get();
            final ViewUtils viewUtils2 = this.viewUtils.get();

            final StringUtils stringUtils1 = this.stringUtils.get();
            final StringUtils stringUtils2 = this.stringUtils.get();

            TextView textView = (TextView) findViewById(R.id.textView);
            assert textView != null;
            textView.setText(userInfo.name);
            Button button = (Button) findViewById(R.id.button);
            assert button != null;
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    userLifeCycle.onLogOut();
                    startMainScreen();
                }
            });
        } else {
            startMainScreen();
        }
    }

    private void startMainScreen() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
