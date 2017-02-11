package com.cuongmv162.customizedsnackbar.view.customized;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
    private static final int NEUTRAL_COLOR = R.color.colorPrimaryDark;

    private Context mContext;
    private View mContainer;

    private ImageView mIcon;
    private TextView mMessage;

    private Animation mShowAnimation;
    private Animation mHideAnimation;

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

        mMessage = (TextView) mContainer.findViewById(R.id.snackbar_title);
        mMessage.setTypeface(FontUtil.getTypeface(mContext, FontUtil.NOTO_SANS_BOLD));

        mShowAnimation = AnimationUtils.loadAnimation(mContext, R.anim.anim_slide_in);
        mHideAnimation = AnimationUtils.loadAnimation(mContext, R.anim.anim_slide_out);
    }

    private void closeAnimation() {
        mContainer.startAnimation(mHideAnimation);
        mHideAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mContainer.setVisibility(View.GONE);
                mDismissListener.onDismiss(true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void showAnimation() {
        mContainer.startAnimation(mShowAnimation);
        mShowAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                mContainer.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void setMessage(String title) {
        this.mMessage.setText(title);
    }

    public void setMessage(int title) {
        this.mMessage.setText(title);
    }

    public void setImageIcon(int imageId) {
        this.mIcon.setImageResource(imageId);
    }

    public void show() {
        if (mContainer != null) {
            showAnimation();
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

    public void dismiss(SnackbarViewUtil.DismissListener dismissListener) {
        this.mDismissListener = dismissListener;
        closeAnimation();
    }

    public void setNegativeColor() {
        mContainer.setBackgroundColor(getResources().getColor(NEGATIVE_COLOR));
    }

    public void setPositive() {
        mContainer.setBackgroundColor(getResources().getColor(POSITIVE_COLOR));
    }

    public void setNeutralColor() {
        mContainer.setBackgroundColor(getResources().getColor(NEUTRAL_COLOR));
    }

    public void setDismissListener(SnackbarViewUtil.DismissListener dismissListener) {
        this.mDismissListener = dismissListener;
    }

    public void autoClose(SnackbarViewUtil.DismissListener dismissListener) {
        mDismissListener = dismissListener;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                closeAnimation();
            }
        }, DISPLAY_TIME);
    }
}
