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
        activity = a;

    }

    public static void showLoadingDialog(String msg) {
        hideMessageDialog();
        loadingDialog = new Dialog(activity);
        loadingDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        loadingDialog.setCancelable(false);
        loadingDialog.setContentView(R.layout.dialog_loading);

        TextView text = loadingDialog.findViewById(R.id.text_dialog);
        text.setText(msg);

        loadingDialog.show();
    }

    public static void hideLoadingDialog() {
        if (loadingDialog != null) {
            loadingDialog.dismiss();
        }
    }

    public static void showMessageDialog(String msg) {
        hideLoadingDialog();
        messageDialog = new Dialog(activity);
        messageDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        messageDialog.setCancelable(false);
        messageDialog.setContentView(R.layout.dialog_message);

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
            messageDialog.dismiss();
        }
    }

    public static void clear() {
        System.out.println("TODO: REMOVE UNUSED FUNCTION");
    }
}
