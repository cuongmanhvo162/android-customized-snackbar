package com.cuongmv162.customizedsnackbar.auth;

/**
 * Created by cuongmv162 on 1/22/2017.
 */

public interface AuthModel {
    interface OnLoginFinishedListener {
        void onUsernameError();
        void onPasswordError();
        void onSuccess();
        void onFailed();
    }

    void login(String username, String password, OnLoginFinishedListener onLoginFinishedListener);
}
