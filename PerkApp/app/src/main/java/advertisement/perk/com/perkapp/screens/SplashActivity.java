package advertisement.perk.com.perkapp.screens;

import android.content.DialogInterface;
import android.os.Bundle;

import advertisement.perk.com.perkapp.R;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    public void onDialogButtonClick(DialogInterface dialog, int which, int alertCode) {

    }
}
