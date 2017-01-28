package com.cuongmv162.customizedsnackbar.view.component;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cuongmv162.customizedsnackbar.R;
import com.cuongmv162.customizedsnackbar.auth.AuthData;

/**
 * Created by cuongmv162 on 1/28/2017.
 */

public class LoginSucceedComponentView extends LinearLayout {
    private Context mContext;
    private TextView mUsername;
    private TextView mEmail;

    public LoginSucceedComponentView(Context context) {
        super(context);
        init(context);
    }

    public LoginSucceedComponentView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public LoginSucceedComponentView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public LoginSucceedComponentView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View view = inflate(mContext, R.layout.view_component_login_succeed, this);
        mUsername = (TextView) view.findViewById(R.id.username);
        mEmail = (TextView) view.findViewById(R.id.email);
    }

    public void setAuthData(AuthData authData) {
        if (authData == null) {
            return;
        }

        mEmail.setText(authData.getEmail());
        mUsername.setText(authData.getUsername());
    }
}
