package com.cuongmv162.customizedsnackbar.view.customized;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by cuongmv162 on 2/4/2017.
 */

public class SnackbarConstant {
    public static final int HIDDEN = 0;
    public static final int SHOWING = 1;
    public static final int ON_CLOSE = 2;

    @SnackbarStatus
    private int snackbarStatus = HIDDEN;

    @IntDef({HIDDEN, SHOWING, ON_CLOSE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface SnackbarStatus {
    }
}
