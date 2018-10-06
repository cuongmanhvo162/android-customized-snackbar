package com.cuongmv162.customizedsnackbar.auth.model;

import com.cuongmv162.customizedsnackbar.auth.model.data.AuthData;

/**
 * Created by cuongmv162 on 1/22/2017.
 */

public interface AuthModel {
    interface OnLoginFinishedListener {
        void onUsernameError();

        void onPasswordError();

        void onLoginSuccess(AuthData authdata);

        void onLoginFailed();
    }

    interface OnSignUpFinishedListener {
        void onUsernameError();

        void onPasswordError();

        void onSignupSuccess(AuthData authData);

        void onSignupFailed();
    }

    void login(String username, String password, OnLoginFinishedListener onLoginFinishedListener);

    void signup(String username, String email, String password, String confirmPassword, OnSignUpFinishedListener onSignUpFinishedListener);
}
