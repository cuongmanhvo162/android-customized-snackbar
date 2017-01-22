package com.cuongmv162.customizedsnackbar.auth;

/**
 * Created by cuongmv162 on 1/22/2017.
 */

public interface AuthPresenter {
    void onLogin(String username, String password);

    void onDestroy();
}
