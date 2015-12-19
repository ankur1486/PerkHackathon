package advertisement.perk.com.perkapp.screens;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import advertisement.perk.com.perkapp.R;


/**
 * Created by Agoel on 30-11-2015.
 */
public abstract class BaseV4Fragment extends Fragment {

    private String alertMessage = null;
    private int alertCode = -1;
    private Handler handler = new Handler();
    private AlertDialog alertDialog = null;
    private String[] strBtnArray = null;

    public void showAlert(final String heading, String message, final int alertCode, final String[] button) {
        alertMessage = message;
        this.alertCode = alertCode;
        strBtnArray = button;
        handler.post(new Runnable() {

            public void run() {

                final Dialog dialog = new Dialog(getActivity());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.custom_two_button_dialog);
                dialog.setCancelable(false);
                // set the custom dialog components - text, image and button
                TextView text = (TextView) dialog.findViewById(R.id.title);
                if (TextUtils.isEmpty(heading)) {
                    text.setText("PayPal Line of credit");
                } else {
                    text.setText(heading);
                }
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

            }
        });
    }

    public void showAlert(String message, final String errorCode, final int alertCode) {

        alertMessage = message;
        this.alertCode = alertCode;

        handler.post(new Runnable() {

            public void run() {
                final Dialog dialog = new Dialog(getActivity());
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

                if (!(getActivity()).isFinishing()) {
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

    public abstract void onDialogButtonClick(DialogInterface dialog, int which, int alertCode);

}
