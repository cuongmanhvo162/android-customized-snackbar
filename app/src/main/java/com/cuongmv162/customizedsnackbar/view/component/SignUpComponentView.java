package com.cuongmv162.customizedsnackbar.view.component;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.cuongmv162.customizedsnackbar.R;
import com.cuongmv162.customizedsnackbar.util.FontUtil;

/**
 * Created by cuongmv162 on 1/22/2017.
 */

public class SignUpComponentView extends RelativeLayout {
    private Context mContext;
    private View mContainer;

    private EditText mUsername;
    private EditText mEmail;
    private EditText mPassword;
    private EditText mConfirmPassword;
    private Button mSubmit;

    public SignUpComponentView(Context context) {
        super(context);
        init(context);
    }

    public SignUpComponentView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SignUpComponentView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SignUpComponentView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        mContainer = inflate(mContext, R.layout.view_component_signup, this);

        mUsername = (EditText) mContainer.findViewById(R.id.signup_username);
        mUsername.setTypeface(FontUtil.getTypeface(mContext, FontUtil.NOTO_SANS_REGULAR));

        mEmail = (EditText) mContainer.findViewById(R.id.signup_email);
        mEmail.setTypeface(FontUtil.getTypeface(mContext, FontUtil.NOTO_SANS_REGULAR));

        mPassword = (EditText) mContainer.findViewById(R.id.signup_password);
        mPassword.setTypeface(FontUtil.getTypeface(mContext, FontUtil.NOTO_SANS_REGULAR));

        mConfirmPassword = (EditText) mContainer.findViewById(R.id.signup_confirm_password);
        mConfirmPassword.setTypeface(FontUtil.getTypeface(mContext, FontUtil.NOTO_SANS_REGULAR));

        mSubmit = (Button) mContainer.findViewById(R.id.signup_submit);
        mSubmit.setTypeface(FontUtil.getTypeface(mContext, FontUtil.NOTO_SANS_REGULAR));
    }

    public Button getSubmit() {
        return this.mSubmit;
    }

    public EditText getUsername() {
        return this.mUsername;
    }

    public EditText getmEmail() {
        return this.mEmail;
    }

    public EditText getPassword() {
        return this.mPassword;
    }

    public EditText getConfirmPassword() {
        return this.mConfirmPassword;
    }
}
