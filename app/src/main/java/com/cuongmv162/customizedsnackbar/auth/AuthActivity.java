package com.cuongmv162.customizedsnackbar.auth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cuongmv162.customizedsnackbar.MainActivity;
import com.cuongmv162.customizedsnackbar.R;
import com.cuongmv162.customizedsnackbar.util.IntentUtil;
import com.cuongmv162.customizedsnackbar.view.component.LoginComponentView;
import com.cuongmv162.customizedsnackbar.view.component.SignUpComponentView;
import com.cuongmv162.customizedsnackbar.view.component.TabAuthComponentView;
import com.cuongmv162.customizedsnackbar.view.customized.SnackbarView;
import com.cuongmv162.customizedsnackbar.view.util.SnackbarViewUtil;

/**
 * Created by cuongmv162 on 1/22/2017.
 */

public class AuthActivity extends AppCompatActivity implements AuthView {

    private SnackbarView mSnackbarView;
    private LoginComponentView mLoginComponentView;
    private SignUpComponentView mSignUpComponentView;
    private TabAuthComponentView mTabAuthComponentView;
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

        mTabAuthComponentView = (TabAuthComponentView) findViewById(R.id.tabs);
        mTabAuthComponentView.getLoginTab().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLogin();
            }
        });
        mTabAuthComponentView.getSignupTab().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSignup();
            }
        });

        mAuthPresenter = new AuthPresenterImpl(this);
    }

    private void showLogin() {
        mLoginComponentView.setVisibility(View.VISIBLE);
        mSignUpComponentView.setVisibility(View.GONE);
    }

    private void showSignup() {
        mLoginComponentView.setVisibility(View.GONE);
        mSignUpComponentView.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAuthPresenter.onDestroy();
    }

    @Override
    public void showProgress() {
        mSnackbarView.setMessage(R.string.processing);
        mSnackbarView.setNeutralColor();
        mSnackbarView.show();
    }

    @Override
    public void hideProgress() {
        mSnackbarView.hide();
    }

    @Override
    public void setUsernameError() {
        mLoginComponentView.getUsername().setError(getString(R.string.username_is_empty));
    }

    @Override
    public void setPasswordError() {
        mLoginComponentView.getPassword().setError(getString(R.string.password_is_empty));
    }

    @Override
    public void loginSuccess(final AuthData authData) {
        mSnackbarView.dismiss(new SnackbarViewUtil.DismissListener() {
            @Override
            public void onDismiss(boolean animationEnd) {
                mSnackbarView.setMessage(R.string.login_successfully);
                mSnackbarView.setPositive();
                mSnackbarView.show();
                mSnackbarView.autoClose(new SnackbarViewUtil.DismissListener() {
                    @Override
                    public void onDismiss(boolean animationEnd) {
                        if (animationEnd) {
                            goHome(authData, AuthConstant.AUTH_LOGIN);
                        }
                    }
                });
            }
        });
    }

    @Override
    public void loginFailed() {
        mSnackbarView.dismiss(new SnackbarViewUtil.DismissListener() {
            @Override
            public void onDismiss(boolean animationEnd) {
                if (animationEnd) {
                    mSnackbarView.setMessage(R.string.login_failed);
                    mSnackbarView.setNegativeColor();
                    mSnackbarView.show();
                    mSnackbarView.autoClose(new SnackbarViewUtil.DismissListener() {
                        @Override
                        public void onDismiss(boolean animationEnd) {
                            return;
                        }
                    });
                }
            }
        });
    }

    @Override
    public void signupSuccess(final AuthData authData) {
        mSnackbarView.dismiss(new SnackbarViewUtil.DismissListener() {
            @Override
            public void onDismiss(boolean animationEnd) {
                if (animationEnd) {
                    mSnackbarView.setMessage(R.string.signup_successfully);
                    mSnackbarView.setPositive();
                    mSnackbarView.show();
                    mSnackbarView.autoClose(new SnackbarViewUtil.DismissListener() {
                        @Override
                        public void onDismiss(boolean animationEnd) {
                            if (animationEnd) {
                                goHome(authData, AuthConstant.AUTH_SIGNUP);
                            }
                        }
                    });
                }
            }
        });
    }

    @Override
    public void signupFailed() {
        mSnackbarView.dismiss(new SnackbarViewUtil.DismissListener() {
            @Override
            public void onDismiss(boolean animationEnd) {
                mSnackbarView.setMessage(R.string.signup_failed);
                mSnackbarView.setNegativeColor();
                mSnackbarView.show();
                mSnackbarView.autoClose(new SnackbarViewUtil.DismissListener() {
                    @Override
                    public void onDismiss(boolean animationEnd) {
                        return;
                    }
                });
            }
        });
    }

    private void goHome(AuthData authData, String action) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(AuthConstant.AUTH_DATA, authData);

        Intent intent = IntentUtil.createIntentWithBundle(this
                , MainActivity.class
                , action
                , bundle);
        startActivity(intent);
        finish();
    }
}
