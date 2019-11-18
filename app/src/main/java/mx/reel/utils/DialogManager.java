package mx.reel.utils;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.byrn.R;

public class DialogManager {
    private static Activity activity = null;
    private static Dialog loadingDialog = null;
    private static Dialog messageDialog = null;

    public static void init(Activity a) {

        if (activity != null) {
            messageDialog.dismiss();
            loadingDialog.dismiss();
        }

        activity = a;

        loadingDialog = new Dialog(activity);
        loadingDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        loadingDialog.setCancelable(false);
        loadingDialog.setContentView(R.layout.dialog_loading);

        messageDialog = new Dialog(activity);
        messageDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        messageDialog.setCancelable(false);
        messageDialog.setContentView(R.layout.dialog_message);
    }

    public static void showLoadingDialog(String msg) {
        messageDialog.hide();

        TextView text = loadingDialog.findViewById(R.id.text_dialog);
        text.setText(msg);

        /*
        Button dialogButton = dialog.findViewById(R.id.btn_dialog);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        */

        loadingDialog.show();
    }

    public static void hideLoadingDialog() {
        if (loadingDialog != null) {
            loadingDialog.hide();
        }
    }

    public static void showMessageDialog(String msg) {
        loadingDialog.hide();

        TextView text = messageDialog.findViewById(R.id.messageDialogLabel);
        text.setText(msg);

        Button dialogButton = messageDialog.findViewById(R.id.messageDialogButton);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messageDialog.dismiss();
            }
        });

        messageDialog.show();
    }

    public static void hideMessageDialog() {
        if (messageDialog != null) {
            messageDialog.hide();
        }
    }

    public static void clear() {
        if (activity == null) {
            return;
        }

        messageDialog.dismiss();
        loadingDialog.dismiss();
        messageDialog = null;
        messageDialog = null;
        activity = null;
    }
}
