package advertisement.perk.com.perkapp.screens;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseUser;

import advertisement.perk.com.perkapp.R;
import advertisement.perk.com.perkapp.parse.PerkUserApi;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, PerkUserApi.Callback {

    private EditText mUsername;
    private EditText mPassword;
    private Button mSignUp_button;

    final PerkUserApi perkUserApi = new PerkUserApi(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initUiComponents();
    }

    /**
     *
     */
    private void initUiComponents() {
        mUsername = (EditText) findViewById(R.id.input_username_editTExt);
        mPassword = (EditText) findViewById(R.id.input_password_editTExt);

        mSignUp_button = (Button) findViewById(R.id.signUp_button);
        mSignUp_button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signUp_button:

                perkUserApi.loginParse(mUsername.getText().toString(), mPassword.getText().toString());

                break;
        }
    }

    @Override
    public void loginSuccess(ParseUser user) {
        if (user != null) {
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void loginFailed(String phone) {
    }

    @Override
    public void getUserSuccess(ParseUser user) {
    }

    @Override
    public void getUserFailed(String str) {

    }
}
