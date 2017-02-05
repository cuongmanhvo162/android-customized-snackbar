package com.cuongmv162.customizedsnackbar.view.customized;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cuongmv162.customizedsnackbar.R;
import com.cuongmv162.customizedsnackbar.util.FontUtil;
import com.cuongmv162.customizedsnackbar.view.util.SnackbarViewUtil;

/**
 * Created by cuongmv162 on 1/20/2017.
 */

public class SnackbarView extends RelativeLayout {

    private static final int DISPLAY_TIME = 3000;
    private static final int NEGATIVE_COLOR = R.color.colorRed;
    private static final int POSITIVE_COLOR = R.color.colorAccent;
    private static final int NEUTRAL_COLOR =R.color.colorPrimary;

    private int mDisplayTime = 0;
    private int mNegativeColor = -1;
    private int mPositiveColor = -1;

    private Context mContext;
    private View mContainer;

    private ImageView mIcon;
    private TextView mTitle;

    private SnackbarViewUtil.DismissListener mDismissListener;

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
        mTitle.setTypeface(FontUtil.getTypeface(mContext, FontUtil.NOTO_SANS_BOLD));
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

    public void fixedDisplay() {
        if (mContainer != null) {
            mContainer.setVisibility(View.VISIBLE);
        }
    }

    public void hide() {
        if (mContainer != null) {
            mContainer.setVisibility(View.GONE);
        }
    }

    public void dismiss() {
        int displayTime;

        if (mDisplayTime > 0) {
            displayTime = mDisplayTime;
        } else {
            displayTime = DISPLAY_TIME;
        }

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mContainer.animate()
                        .translationY(0)
                        .setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                mContainer.setVisibility(View.GONE);
                                mDismissListener.onDismiss(true);
                            }
                        });
            }
        }, displayTime);
    }

    public void setDisplayTime(int displayTime) {
        this.mDisplayTime = displayTime;
    }

    public void setNegativeColor(int color) {
        mNegativeColor = color;
    }

    public void setPositiveColor(int color) {
        mPositiveColor = color;
    }

    public void setNegativeColor() {
        mContainer.setBackgroundColor(getResources().getColor(NEGATIVE_COLOR));
    }

    public void setPositive() {
        mContainer.setBackgroundColor(getResources().getColor(POSITIVE_COLOR));
    }

    public void setNeutralColor(){
        mContainer.setBackgroundColor(getResources().getColor(NEUTRAL_COLOR));
    }

    public void setDismissListener(SnackbarViewUtil.DismissListener dismissListener){
        this.mDismissListener = dismissListener;
    }
}
