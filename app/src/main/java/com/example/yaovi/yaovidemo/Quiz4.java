package com.example.yaovi.yaovidemo;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Quiz4 extends Dialog {

    private int checkedID;

    @BindView(R.id.rdg2)
    RadioGroup radioGroup;

    @OnClick(R.id.dialog_ok2)
    public void okClick(){
        if(checkedID == R.id.button1){
            listener.onClickListener();
        }
        if(checkedID == R.id.button2){
            listener.onClickListener2();
        }
        dismiss();
    }

    private ICustomDialogEventListener listener;

    public interface ICustomDialogEventListener{
        public void onClickListener();
        public void onClickListener2();
        public void onCancel();
    }

    @OnClick(R.id.dialog_cancel)
    public void cancelClick(){
        listener.onCancel();
        dismiss();
    }




    public Quiz4(@NonNull Context context, ICustomDialogEventListener listener) {
        super(context, R.style.dialog);
        this.listener = listener;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz4);
        ButterKnife.bind(this);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                checkedID = checkedId;

            }
        });
    }
}
