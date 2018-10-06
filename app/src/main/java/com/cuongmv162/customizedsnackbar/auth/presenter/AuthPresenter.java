package com.cuongmv162.customizedsnackbar.auth.presenter;

/**
 * Created by cuongmv162 on 1/22/2017.
 */

public interface AuthPresenter {
    void doLogin(String username, String password);

    void doSignup(String username, String email, String password, String confirmPassword);

    void onDestroy();
}
