package com.hgs.movapp.utils;

import android.app.ProgressDialog;
import android.content.Context;

import com.hgs.movapp.R;
import com.hgs.movapp.component.MessageDialog;


public class DialogsUtils {

    private static String Message;
    private static String Title;
    private static int ProgressStyle;
    private static ProgressDialog m_Dialog;

    public static ProgressDialog showProgressDialog(
            Context context, MessageDialog msgDialog){

        BuildParameterProgressDialog(context, msgDialog);
        m_Dialog = new ProgressDialog(context);

        m_Dialog.setTitle(Title);
        m_Dialog.setMessage(Message);
        m_Dialog.setProgressStyle(ProgressStyle);
        m_Dialog.setCancelable(false);
        m_Dialog.show();
        return m_Dialog;
    }

    public static ProgressDialog getDialog(){
        return m_Dialog;
    }

    private static void BuildParameterProgressDialog(Context context, MessageDialog msgDialog) {

        if (msgDialog != null) {
            Message = msgDialog.getMessage();
            Title = msgDialog.getSetTitle();
            ProgressStyle = msgDialog.getProgressStyle();
            return;
        }

        ProgressStyle = ProgressDialog.STYLE_SPINNER;
    }
}
