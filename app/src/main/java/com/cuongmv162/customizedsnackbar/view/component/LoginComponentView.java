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
 * Created by cuongmv162 on 1/21/2017.
 */

public class LoginComponentView extends RelativeLayout {

    private Context mContext;
    private View mContainer;
    private EditText mUsername;
    private EditText mPassword;
    private Button mSubmit;

    public LoginComponentView(Context context) {
        super(context);
        init(context);
    }

    public LoginComponentView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public LoginComponentView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public LoginComponentView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        mContainer = inflate(mContext, R.layout.view_component_login, this);

        mUsername = (EditText) mContainer.findViewById(R.id.login_email);
        mUsername.setTypeface(FontUtil.getTypeface(mContext, FontUtil.NOTO_SANS_REGULAR));

        mPassword = (EditText) mContainer.findViewById(R.id.login_password);
        mPassword.setTypeface(FontUtil.getTypeface(mContext, FontUtil.NOTO_SANS_REGULAR));

        mSubmit = (Button) mContainer.findViewById(R.id.login_submit);
        mSubmit.setTypeface(FontUtil.getTypeface(mContext, FontUtil.NOTO_SANS_REGULAR));
    }

    public EditText getUsername() {
        return this.mUsername;
    }

    public EditText getPassword() {
        return this.mPassword;
    }

    public Button getSubmit() {
        return this.mSubmit;
    }
}
