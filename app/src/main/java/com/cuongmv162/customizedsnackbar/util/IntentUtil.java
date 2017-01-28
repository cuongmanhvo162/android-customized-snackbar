package com.cuongmv162.customizedsnackbar.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by cuongmv162 on 1/28/2017.
 */

public class IntentUtil {

    public static Intent createIntentWithBundle(Activity activity, Class<?> clazz, String action, Bundle bundle) {
        Intent intent = new Intent();
        intent.setAction(action);
        intent.setClass(activity, clazz);
        intent.putExtras(bundle);
        return intent;
    }
}
