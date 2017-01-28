package com.cuongmv162.customizedsnackbar.auth;

/**
 * Created by cuongmv162 on 1/22/2017.
 */

public interface AuthModel {
    interface OnLoginFinishedListener {
        void onUsernameError();

        void onPasswordError();

        void onSuccess(AuthData authdata);

        void onFailed();
    }

    interface OnSignUpFinishedListener {
        void onUsernameError();

        void onPasswordError();

        void onSuccess(AuthData authData);

        void onFailed();
    }

    void login(String username, String password, OnLoginFinishedListener onLoginFinishedListener);

    void signup(String username, String email, String password, String confirmPassword, OnSignUpFinishedListener onSignUpFinishedListener);
}
