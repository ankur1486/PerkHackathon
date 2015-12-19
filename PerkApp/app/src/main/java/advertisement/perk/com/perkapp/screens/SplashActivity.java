package advertisement.perk.com.perkapp.screens;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;

import advertisement.perk.com.perkapp.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initUiComponents();

    }

    /**
     * init Ui components
     */
    private void initUiComponents() {
        findViewById(R.id.welcome_textView).clearAnimation();
        TranslateAnimation translation = new TranslateAnimation(0f, 0F, 0f, getDisplayHeight());
        translation.setStartOffset(500);
        translation.setDuration(2000);
        translation.setFillAfter(true);
        translation.setInterpolator(new BounceInterpolator());
        findViewById(R.id.welcome_textView).startAnimation(translation);

        startLandingActivity();
    }

    /**
     * redirecting to landing screen
     */
    private void startLandingActivity() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }

    private int getDisplayHeight() {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics.widthPixels;
    }

}
