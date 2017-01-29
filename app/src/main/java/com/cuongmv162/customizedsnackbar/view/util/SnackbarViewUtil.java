package com.cuongmv162.customizedsnackbar.view.util;

import com.cuongmv162.customizedsnackbar.view.customized.SnackbarView;

/**
 * Created by cuongmv162 on 1/25/2017.
 */

public class SnackbarViewUtil {
    public static void displayNegativeMessage(SnackbarView snackbarView, String message) {
        snackbarView.setTitle(message);
        snackbarView.setNegativeColor();
        snackbarView.show();
        snackbarView.dismiss();
    }

    public static void displayPositiveMessage(SnackbarView snackbarView, String message) {
        snackbarView.setTitle(message);
        snackbarView.setPositive();
        snackbarView.show();
        snackbarView.dismiss();
    }
}
