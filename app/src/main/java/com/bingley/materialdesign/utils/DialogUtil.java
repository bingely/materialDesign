package com.bingley.materialdesign.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.widget.TextView;

import com.bingley.materialdesign.R;


public class DialogUtil {
    public static Dialog dialog = null;

    private Context context;

    private DialogUtil(Context context) {
        this.context = context;
    }


    public static void showDialog(Context context) {

        try {
            if(context==null){
                return;
            }
            dialog = new Dialog(context, R.style.base_dialog_theme);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.fragment_progress_dialog);
            TextView tv = (TextView) dialog.findViewById(R.id.tv_error_layout);
            tv.setText("加载中...");
            dialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void showDialog(Context context,String tip) {
        if(context==null){
            return;
        }
        dialog = new Dialog(context, R.style.base_dialog_theme);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.fragment_progress_dialog);
        TextView tv = (TextView) dialog.findViewById(R.id.tv_error_layout);
        tv.setText(tip);
        dialog.show();
    }

    public static void dimissDialog() {
        try {
            if (dialog != null && dialog.isShowing()) {
                dialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
