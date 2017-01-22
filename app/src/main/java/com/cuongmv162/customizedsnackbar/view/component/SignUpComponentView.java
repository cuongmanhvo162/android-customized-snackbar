package com.cuongmv162.customizedsnackbar.view.component;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by cuongmv162 on 1/22/2017.
 */

public class SignUpComponentView extends RelativeLayout {
    private Context mContext;

    public SignUpComponentView(Context context) {
        super(context);
    }

    public SignUpComponentView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SignUpComponentView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SignUpComponentView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
