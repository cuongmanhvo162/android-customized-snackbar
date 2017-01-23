package com.cuongmv162.customizedsnackbar.util;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by cuongmv162 on 1/23/2017.
 */

public class FontUtil {
    public static final String NOTO_SANS_REGULAR = "NotoSans-Regular.ttf";
    public static final String NOTO_SANS_BOLD = "NotoSans-Bold.ttf";
    public static final String NOTO_SANS_ITALIC = "NotoSans-Italic.ttf";

    public static Typeface getTypeface(Context context, String fontName) {
        Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/".concat(fontName));
        return font;
    }
}
