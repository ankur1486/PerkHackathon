/**
 * Copyright (c) 2014 Altimetrik India Pvt. Ltd.
 * #7P & 93P, Electronic City West, Bangalore -  560100, INDIA.
 * http://www.altimetrik.com
 * All Rights Reserved.
 * <p/>
 * This software is the confidential and proprietary information of Altimetrik India Pvt. Ltd.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Altimetrik India Pvt. Ltd.
 * <p/>
 * Created by Agoel on 06-10-2015.
 * <p/>
 * Created by Agoel on 06-10-2015.
 * <p/>
 * Created by Agoel on 06-10-2015.
 * <p/>
 * Created by Agoel on 06-10-2015.
 * <p/>
 * Created by Agoel on 06-10-2015.
 * <p/>
 * Created by Agoel on 06-10-2015.
 * <p/>
 * Created by Agoel on 06-10-2015.
 * <p/>
 * Created by Agoel on 06-10-2015.
 * <p/>
 * Created by Agoel on 06-10-2015.
 * <p/>
 * Created by Agoel on 06-10-2015.
 * <p/>
 * Created by Agoel on 06-10-2015.
 * <p/>
 * Created by Agoel on 06-10-2015.
 */


/**
 * Created by Agoel on 06-10-2015.
 */
package advertisement.perk.com.perkapp.screens;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

import advertisement.perk.com.perkapp.R;

public abstract class BaseActivity extends AppCompatActivity {

    private String alertMessage = null;
    private int alertCode = -1;
    private Handler handler;
    private AlertDialog alertDialog = null;
    private String[] strBtnArray = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handler = new Handler();
    }

    protected void setActionBar(int titleResourceId, boolean displayShowHomeEnabled, boolean isBackEnabled) {
        System.out.println("setActionBar  .           .1.1. 1.1.  1.1  88***************");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (toolbar != null) {

            setSupportActionBar(toolbar);
            System.out.println("setActionBar  .                     1 1 1 1 1");

            getSupportActionBar().setDisplayShowCustomEnabled(displayShowHomeEnabled);
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayUseLogoEnabled(false);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);

            getSupportActionBar().setTitle(titleResourceId);

            if (isBackEnabled) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
        }
    }

    public void showAlert(String message, final String errorCode, final int alertCode) {

        alertMessage = message;
        this.alertCode = alertCode;

        handler.post(new Runnable() {

            public void run() {
                final Dialog dialog = new Dialog(BaseActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.custom_alert);

                dialog.setCancelable(false);
                // set the custom dialog components - text, image and button
                TextView text = (TextView) dialog.findViewById(R.id.title);
                text.setText("");

                TextView msgTxt = (TextView) dialog.findViewById(R.id.msg);
                msgTxt.setText(alertMessage);


                Button dialogButton = (Button) dialog.findViewById(R.id.ok_btn);
                dialogButton.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub

                        onDialogButtonClick(dialog, AlertDialog.BUTTON_POSITIVE, alertCode);
                        dialog.dismiss();
                    }
                });
                // if button is clicked, close the custom dialog

                if (!(BaseActivity.this).isFinishing()) {
                    dialog.show();
                }
                /*
                 * alertDialog = new AlertDialog.Builder(BaseFragmentActivity.this).create(); alertDialog.setContentView(R.layout.custom_alert_dailog);
				 * alertDialog.setTitle("Alert"); alertDialog.setMessage(alertMessage); alertDialog.setCancelable(false); alertDialog.setButton("OK",
				 * BaseFragmentActivity.this); alertDialog.show();
				 */

            }
        });

    }

    public void showAlert(String message, final int alertCode, final String[] button) {
        alertMessage = message;
        this.alertCode = alertCode;
        strBtnArray = button;
        handler.post(new Runnable() {

            public void run() {

                final Dialog dialog = new Dialog(BaseActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.custom_two_button_dialog);
                dialog.setCancelable(false);
                // set the custom dialog components - text, image and button
                TextView text = (TextView) dialog.findViewById(R.id.title);
                text.setText("PayPal Loc");
//                PaysaApplication.getInstance().setTextTypeface(text, PaysaConstants.LIGHT_FONT);

                TextView msgTxt = (TextView) dialog.findViewById(R.id.msg);
                msgTxt.setText(alertMessage);

                Button okdialogButton = (Button) dialog.findViewById(R.id.ok_btn);
                okdialogButton.setText(strBtnArray[0]);
                okdialogButton.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        onDialogButtonClick(dialog, AlertDialog.BUTTON_POSITIVE, alertCode);
                        dialog.dismiss();
                    }
                });
                Button canceldialogButton = (Button) dialog.findViewById(R.id.cancel_btn);
                canceldialogButton.setText(strBtnArray[1]);
                canceldialogButton.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        onDialogButtonClick(dialog, AlertDialog.BUTTON_NEGATIVE, alertCode);
                        dialog.dismiss();
                    }
                });
                // if button is clicked, close the custom dialog

                dialog.show();
                /*
                 * alertDialog = new AlertDialog.Builder(BaseFragmentActivity.this) .create(); alertDialog.setTitle("Alert");
				 * alertDialog.setMessage(alertMessage); alertDialog.setCancelable(false); alertDialog.setButton(button[0], BaseFragmentActivity.this);
				 * alertDialog.setButton2(button[1], BaseFragmentActivity.this); alertDialog.show();
				 */
            }
        });
    }

    private void cancelAlert() {
        if (alertDialog != null && alertDialog.isShowing()) {
            alertDialog.cancel();
            alertDialog = null;
            System.out.println("BaseActivity.cancelAlert() " + alertDialog);
        }

    }

    public final void onClick(final DialogInterface dialog, final int which) {

        System.out.println("BaseActivity.onClick(final DialogInterface dialog, final int which)");
        // eventTime = System.currentTimeMillis();
        onDialogButtonClick(dialog, which, alertCode);
        // alertDialog.dismiss();
        // alertDialog = null;
        alertCode = -1;

    }

    public abstract void onDialogButtonClick(DialogInterface dialog, int which, int alertCode);

    public void closeKeyborad() {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

}
