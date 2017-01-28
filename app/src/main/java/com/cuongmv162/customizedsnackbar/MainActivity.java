package com.cuongmv162.customizedsnackbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.cuongmv162.customizedsnackbar.auth.AuthConstant;
import com.cuongmv162.customizedsnackbar.auth.AuthData;
import com.cuongmv162.customizedsnackbar.view.component.LoginSucceedComponentView;
import com.cuongmv162.customizedsnackbar.view.component.SignUpComponentView;

public class MainActivity extends AppCompatActivity {
    private LoginSucceedComponentView mLoginSucceedComponentView;
    private SignUpComponentView mSignUpComponentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoginSucceedComponentView = (LoginSucceedComponentView) findViewById(R.id.login_succeed_component_view);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String action = intent.getAction();

        if (action.equals(AuthConstant.AUTH_LOGIN)) {
            AuthData authData = bundle.getParcelable(AuthConstant.AUTH_DATA);
            mLoginSucceedComponentView.setAuthData(authData);
            mLoginSucceedComponentView.setVisibility(View.VISIBLE);

        } else if (action.equals(AuthConstant.AUTH_SIGNUP)) {
            AuthData authData = bundle.getParcelable(AuthConstant.AUTH_DATA);

            mSignUpComponentView.setVisibility(View.VISIBLE);
        }

    }
}
