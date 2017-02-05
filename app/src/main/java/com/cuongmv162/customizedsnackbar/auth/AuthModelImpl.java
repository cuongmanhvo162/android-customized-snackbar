package com.cuongmv162.customizedsnackbar.auth;


import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by cuongmv162 on 1/22/2017.
 */

public class AuthModelImpl implements AuthModel {

    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener onLoginFinishedListener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean error = false;

                if (TextUtils.isEmpty(username)) {
                    onLoginFinishedListener.onUsernameError();
                    error = true;
                }
                if (TextUtils.isEmpty(password)) {
                    onLoginFinishedListener.onPasswordError();
                    error = true;
                }
                if (!error) {
                    if (username.equals("admin") && password.equals("123456789")) {
                        AuthData authData = new AuthData();
                        authData.setUsername(username);
                        authData.setPassword(password);
                        authData.setEmail("admin@gmail.com");

                        onLoginFinishedListener.onLoginSuccess(authData);
                    } else {
                        onLoginFinishedListener.onLoginFailed();
                    }
                }
            }
        }, 3000);
    }

    @Override
    public void signup(final String username, final String email, String password, String confirmPassword, final OnSignUpFinishedListener onSignUpFinishedListener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean error = false;

                if (!error) {
                    AuthData authData = new AuthData();
                    authData.setUsername(username);
                    authData.setEmail(email);

                    onSignUpFinishedListener.onSignupSuccess(authData);

                } else {
                    onSignUpFinishedListener.onSignupFailed();
                }
            }
        }, 3000);
    }
}
