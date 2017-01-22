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
                        onLoginFinishedListener.onSuccess();
                    } else {
                        onLoginFinishedListener.onFailed();
                    }
                }
            }
        }, 5000);
    }
}
