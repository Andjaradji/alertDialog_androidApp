package com.rds.alertdialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private AlertDialog.Builder mAlertDialog;
    private Button mShowButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowButton = (Button)findViewById(R.id.showDialogBtnID);

        mShowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //show the actual dialog box
                mAlertDialog = new AlertDialog.Builder(MainActivity.this);

                // set the title
                // mAlertDialog.setTitle(R.string.alert_title);
                mAlertDialog.setTitle(getResources().getString(R.string.alert_title));

                //Set the message
                mAlertDialog.setMessage(getResources().getString(R.string.alert_message));

                // Set Cancelable
                mAlertDialog.setCancelable(false);

                // Set Positive Button
                mAlertDialog.setPositiveButton(getResources().getString(R.string.alert_positive_button), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Exit Our Window Activity
                        MainActivity.this.finish();
                    }
                });

                // set negative button
                mAlertDialog.setNegativeButton(getResources().getString(R.string.alert_negative_button), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                // constructing the actual dialog
                AlertDialog mDialog = mAlertDialog.create();

                // show the dialog
                mDialog.show();

            }
        });
    }
}
