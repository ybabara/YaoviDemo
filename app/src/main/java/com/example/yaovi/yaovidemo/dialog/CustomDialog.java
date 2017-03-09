package com.example.yaovi.yaovidemo.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import com.example.yaovi.yaovidemo.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Yaovi on 2/15/17.
 */

public class CustomDialog extends Dialog {
    private ICustomDialogEventListener listener;

    @OnClick(R.id.dialog_ok)
    public void okClick(){
        dismiss();

        listener.onClickListener();
    }

    public interface  ICustomDialogEventListener{
        public void onClickListener();
    }

    public interface ICustomDialogEventListener2{
        public void onCLickListener();
    }

    public CustomDialog(Context context, ICustomDialogEventListener listener) {
        super(context, R.style.dialog);
        this.listener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_dialog);
        ButterKnife.bind(this);
    }
}
