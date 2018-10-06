package com.cuongmv162.customizedsnackbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.cuongmv162.customizedsnackbar.auth.AuthConstant;
import com.cuongmv162.customizedsnackbar.auth.model.data.AuthData;
import com.cuongmv162.customizedsnackbar.view.component.LoginSucceedComponentView;
import com.cuongmv162.customizedsnackbar.view.component.SignupSucceedComponentView;

public class MainActivity extends AppCompatActivity {
    private LoginSucceedComponentView mLoginSucceedComponentView;
    private SignupSucceedComponentView mSignupSucceedComponentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoginSucceedComponentView = (LoginSucceedComponentView) findViewById(R.id.login_succeed_component_view);
        mSignupSucceedComponentView = (SignupSucceedComponentView) findViewById(R.id.signup_succeed_component_view);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String action = intent.getAction();

        if (action.equals(AuthConstant.AUTH_LOGIN)) {
            AuthData authData = bundle.getParcelable(AuthConstant.AUTH_DATA);

            showLoginSucceedView(authData);

        } else if (action.equals(AuthConstant.AUTH_SIGNUP)) {
            AuthData authData = bundle.getParcelable(AuthConstant.AUTH_DATA);

            showSignupSucceed(authData);
        }

    }

    private void showSignupSucceed(AuthData authData) {
        mSignupSucceedComponentView.setAuthData(authData);
        mSignupSucceedComponentView.setVisibility(View.VISIBLE);
        mLoginSucceedComponentView.setVisibility(View.GONE);
    }

    private void showLoginSucceedView(AuthData authData) {
        mLoginSucceedComponentView.setAuthData(authData);
        mLoginSucceedComponentView.setVisibility(View.VISIBLE);
        mSignupSucceedComponentView.setVisibility(View.GONE);
    }
}
