package com.cuongmv162.customizedsnackbar.auth;

/**
 * Created by cuongmv162 on 1/22/2017.
 */

public class AuthPresenterImpl implements AuthPresenter, AuthModel.OnLoginFinishedListener, AuthModel.OnSignUpFinishedListener {

    private AuthView mAuthView;
    private AuthModel mAuthModel;

    public AuthPresenterImpl(AuthView authView) {
        this.mAuthView = authView;
        this.mAuthModel = new AuthModelImpl();
    }

    @Override
    public void doLogin(String username, String password) {
        if (mAuthView != null) {
            mAuthView.showProgress();
        }

        mAuthModel.login(username, password, this);
    }

    @Override
    public void doSignup(String username, String email, String password, String confirmPassword) {
        if(mAuthView != null){
            mAuthView.showProgress();
        }

        mAuthModel.signup(username, email, password, confirmPassword, this);
    }

    @Override
    public void onDestroy() {
        mAuthView = null;
    }

    @Override
    public void onUsernameError() {
        if (mAuthView != null) {
            mAuthView.setUsernameError();
            mAuthView.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if (mAuthView != null) {
            mAuthView.setPasswordError();
            mAuthView.hideProgress();
        }
    }

    @Override
    public void onSuccess(AuthData authData) {
        if (mAuthView != null) {
            mAuthView.loginSuccess(authData);
        }
    }

    @Override
    public void onFailed() {
        if (mAuthView != null) {
            mAuthView.loginFailed();
        }
    }
}
