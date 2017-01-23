package com.cuongmv162.customizedsnackbar.auth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cuongmv162.customizedsnackbar.MainActivity;
import com.cuongmv162.customizedsnackbar.R;
import com.cuongmv162.customizedsnackbar.view.component.LoginComponentView;
import com.cuongmv162.customizedsnackbar.view.customized.SnackbarView;

/**
 * Created by cuongmv162 on 1/22/2017.
 */

public class AuthActivity extends Activity implements AuthView {

    private SnackbarView mSnackbarView;
    private LoginComponentView mLoginComponentView;
    private AuthPresenter mAuthPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        mSnackbarView = (SnackbarView) findViewById(R.id.my_snackbar);
        mSnackbarView.hide();

        mLoginComponentView = (LoginComponentView) findViewById(R.id.auth_login_component_view);
        mLoginComponentView.getSubmit().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuthPresenter.onLogin(mLoginComponentView.getUsername().getText().toString()
                        , mLoginComponentView.getPassword().getText().toString());
            }
        });

        mAuthPresenter = new AuthPresenterImpl(this);
    }

    @Override
    public void showProgress() {
        mSnackbarView.setTitle("We are processing!");
        mSnackbarView.show();
    }

    @Override
    public void hideProgress() {
        mSnackbarView.hide();
    }

    @Override
    public void setUsernameError() {
        mLoginComponentView.getUsername().setError("Username is empty");
    }

    @Override
    public void setPasswordError() {
        mLoginComponentView.getPassword().setError("Password is empty");
    }

    @Override
    public void goHome() {
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void loginSuccess() {
        mSnackbarView.setTitle("Login successfully");
        mSnackbarView.show();
        mSnackbarView.dismiss();
    }

    @Override
    public void loginFailed() {
        mSnackbarView.setTitle("Login failed");
        mSnackbarView.show();
        mSnackbarView.dismiss();
    }
}
