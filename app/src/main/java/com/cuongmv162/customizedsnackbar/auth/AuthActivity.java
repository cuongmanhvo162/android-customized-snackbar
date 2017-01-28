package com.cuongmv162.customizedsnackbar.auth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cuongmv162.customizedsnackbar.MainActivity;
import com.cuongmv162.customizedsnackbar.R;
import com.cuongmv162.customizedsnackbar.util.IntentUtil;
import com.cuongmv162.customizedsnackbar.view.component.LoginComponentView;
import com.cuongmv162.customizedsnackbar.view.component.SignUpComponentView;
import com.cuongmv162.customizedsnackbar.view.customized.SnackbarView;
import com.cuongmv162.customizedsnackbar.view.util.SnackbarViewUtil;

/**
 * Created by cuongmv162 on 1/22/2017.
 */

public class AuthActivity extends AppCompatActivity implements AuthView {

    private SnackbarView mSnackbarView;
    private LoginComponentView mLoginComponentView;
    private SignUpComponentView mSignUpComponentView;
    private AuthPresenter mAuthPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        mSnackbarView = (SnackbarView) findViewById(R.id.my_snackbar);
        mSnackbarView.hide();

        mLoginComponentView = (LoginComponentView) findViewById(R.id.auth_component_view_login);
        mLoginComponentView.getSubmit().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuthPresenter.doLogin(mLoginComponentView.getUsername().getText().toString()
                        , mLoginComponentView.getPassword().getText().toString());
            }
        });

        mSignUpComponentView = (SignUpComponentView) findViewById(R.id.auth_component_view_signup);
        mSignUpComponentView.getSubmit().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuthPresenter.doSignup(mSignUpComponentView.getUsername().getText().toString()
                        , mSignUpComponentView.getmEmail().getText().toString()
                        , mSignUpComponentView.getPassword().getText().toString()
                        , mSignUpComponentView.getConfirmPassword().getText().toString());
            }
        });

        mAuthPresenter = new AuthPresenterImpl(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAuthPresenter.onDestroy();
    }

    @Override
    public void showProgress() {
        mSnackbarView.setTitle("We are processing!");
        mSnackbarView.setPositive();
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
    public void loginSuccess(AuthData authData) {
        SnackbarViewUtil.displayPositiveMessage(mSnackbarView, "Login successfully");

        Bundle bundle = new Bundle();
        bundle.putParcelable(AuthConstant.AUTH_DATA, authData);

        Intent intent = IntentUtil.createIntentWithBundle(this
                , MainActivity.class
                , AuthConstant.AUTH_LOGIN
                , bundle);
        startActivity(intent);
        finish();
    }

    @Override
    public void loginFailed() {
        SnackbarViewUtil.displayPositiveMessage(mSnackbarView, "Login failed");
    }

    @Override
    public void signupSuccess(AuthData authData) {
        SnackbarViewUtil.displayPositiveMessage(mSnackbarView, "Signup successfully");

        Bundle bundle = new Bundle();
        bundle.putParcelable(AuthConstant.AUTH_DATA, authData);

        Intent intent = IntentUtil.createIntentWithBundle(this
                , MainActivity.class
                , AuthConstant.AUTH_SIGNUP
                , bundle);
        startActivity(intent);
        finish();
    }

    @Override
    public void signupFailed() {
        SnackbarViewUtil.displayPositiveMessage(mSnackbarView, "Signup failed");
    }
}
