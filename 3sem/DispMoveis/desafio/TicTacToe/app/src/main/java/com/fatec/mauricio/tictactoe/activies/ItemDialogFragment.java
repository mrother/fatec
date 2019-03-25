package com.fatec.mauricio.tictactoe.activies;


import android.app.AlertDialog;
import android.content.Context;

public class ItemDialogFragment extends AlertDialog {


    protected ItemDialogFragment(Context context) {
        super(context);
    }

    protected ItemDialogFragment(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    protected ItemDialogFragment(Context context, int themeResId) {
        super(context, themeResId);
    }
}
