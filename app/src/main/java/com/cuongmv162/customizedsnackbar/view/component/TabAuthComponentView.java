package com.cuongmv162.customizedsnackbar.view.component;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cuongmv162.customizedsnackbar.R;
import com.cuongmv162.customizedsnackbar.util.FontUtil;

/**
 * Created by cuongmv162 on 1/29/2017.
 */

public class TabAuthComponentView extends LinearLayout {
    private Context mContext;
    private TextView mSignup;
    private TextView mLogin;

    public TabAuthComponentView(Context context) {
        super(context);
        init(context);
    }

    public TabAuthComponentView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TabAuthComponentView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TabAuthComponentView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View view = inflate(mContext, R.layout.view_component_auth_tab, this);

        mLogin = (TextView) view.findViewById(R.id.tab_login);
        mLogin.setTypeface(FontUtil.getTypeface(mContext, FontUtil.NOTO_SANS_REGULAR));

        mSignup = (TextView) view.findViewById(R.id.tab_signup);
        mSignup.setTypeface(FontUtil.getTypeface(mContext, FontUtil.NOTO_SANS_REGULAR));
    }

    public TextView getLoginTab() {
        return this.mLogin;
    }

    public TextView getSignupTab() {
        return this.mSignup;
    }
}
