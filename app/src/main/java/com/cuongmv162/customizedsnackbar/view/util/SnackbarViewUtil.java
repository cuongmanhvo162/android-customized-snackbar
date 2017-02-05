package com.cuongmv162.customizedsnackbar.view.util;

import com.cuongmv162.customizedsnackbar.view.customized.SnackbarView;

/**
 * Created by cuongmv162 on 1/25/2017.
 */
public class SnackbarViewUtil {
    public interface DismissListener {
        void onDismiss(boolean animationEnd);
    }

    public static void displayNegativeMessage(SnackbarView snackbarView, int message, DismissListener dismissListener) {
        snackbarView.setDismissListener(dismissListener);
        snackbarView.setTitle(message);
        snackbarView.setNegativeColor();
        snackbarView.show();
        snackbarView.dismiss();
    }

    public static void displayPositiveMessage(SnackbarView snackbarView, int message, DismissListener dismissListener) {
        snackbarView.setDismissListener(dismissListener);
        snackbarView.setTitle(message);
        snackbarView.setPositive();
        snackbarView.show();
        snackbarView.dismiss();

    }

    public static void displayNeuturalveMessage(SnackbarView snackbarView, int message, DismissListener dismissListener) {
        snackbarView.setDismissListener(dismissListener);
        snackbarView.setTitle(message);
        snackbarView.setNeutralColor();
        snackbarView.show();
        snackbarView.dismiss();

    }
}
