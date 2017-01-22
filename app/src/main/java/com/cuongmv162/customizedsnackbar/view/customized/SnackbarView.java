package com.cuongmv162.customizedsnackbar.view.customized;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cuongmv162.customizedsnackbar.R;

/**
 * Created by cuongmv162 on 1/20/2017.
 */

public class SnackbarView extends RelativeLayout {
    private static final int DISPLAY_TIME = 3000;
    private static final int NEGATIVE_COLOR = -1;
    private static final int POSITIVE_COLOR = -1;

    private int mDisplayTime = 0;
    private Context mContext;
    private View mContainer;

    private ImageView mIcon;
    private TextView mTitle;

    public SnackbarView(Context context) {
        super(context);
        init(context);
    }

    public SnackbarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SnackbarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SnackbarView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;

        mContainer = inflate(mContext, R.layout.view_snackbar, this);

        mIcon = (ImageView) mContainer.findViewById(R.id.snackbar_icon);
        mTitle = (TextView) mContainer.findViewById(R.id.snackbar_title);
    }

    public void setTitle(String title) {
        this.mTitle.setText(title);
    }

    public void setTitle(int title) {
        this.mTitle.setText(title);
    }

    public void setImageIcon(int imageId) {
        this.mIcon.setImageResource(imageId);
    }

    public void show() {
        if (mContainer != null) {
            mContainer.setVisibility(View.VISIBLE);
        }
    }

    public void fixedDiplsay() {

    }

    public void hide() {
        if (mContainer != null) {
            mContainer.setVisibility(View.GONE);
        }
    }

    public void dismiss() {

    }

    public void setDisplayTime(int displayTime) {
        this.mDisplayTime = displayTime;
    }
}
