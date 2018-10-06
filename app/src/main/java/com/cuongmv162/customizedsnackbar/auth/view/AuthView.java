package com.cuongmv162.customizedsnackbar.auth.view;

import com.cuongmv162.customizedsnackbar.auth.model.data.AuthData;

/**
 * Created by cuongmv162 on 1/22/2017.
 */

public interface AuthView {
    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void loginSuccess(AuthData authData);

    void loginFailed();

    void signupSuccess(AuthData authData);

    void signupFailed();
}
