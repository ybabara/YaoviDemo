package com.example.yaovi.yaovidemo;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.yaovi.yaovidemo.dialog.CustomDialog;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Yaovi on 2/13/17.
 */

public class DialogActivity extends BaseActivity {

    private int checkedID;

    @BindView(R.id.rdg) RadioGroup radioGroup;
    @OnClick(R.id.dialog_ok)
    public void okClick(){
        switch (checkedID){
            case R.id.rb1:
                normalDialog();
                break;
            case R.id.rb2:
                listDialog();
                break;
            case R.id.rb3:
                singleChoiceDialog();
                break;
            case R.id.rb4:
                multiChoiceDialog();
                break;
            case R.id.rb5:
                waitingDialog();
                break;
            case R.id.rb6:
                progressDialog();
                break;
            case R.id.rb7:
                inputDialog();
                break;
            case R.id.rb8:
                customDialog();
                break;
            default:

        }
    }

    private void customDialog() {
        final CustomDialog dialog = new CustomDialog(this, new CustomDialog.ICustomDialogEventListener() {
            @Override
            public void onClickListener() {
                Intent intent = new Intent();
                intent.putExtra("message","Result");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        dialog.show();
    }

    private void inputDialog(){
        final EditText editText = new EditText(this);
        AlertDialog.Builder inputDialog =
                new AlertDialog.Builder(this);
        inputDialog.setTitle("I'm an input Dialog").setView(editText);
        inputDialog.setPositiveButton("Yes",
                new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        toastShort(editText.getText().toString());
                    }
                });
        inputDialog.setNegativeButton("Cancel", null).show();
    }

    ArrayList<Integer> choices = new ArrayList<>();
    private void multiChoiceDialog() {
        final String[] items = {"item1", "item2", "item3", "item4"};
        final boolean initChoiceSets[] = {false,false,false,false};
        choices.clear();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("I'm  multi-choice Dialog");
        builder.setMultiChoiceItems(items, initChoiceSets, new DialogInterface.OnMultiChoiceClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked){
                    choices.add(which);
                } else {
                    choices.remove(which);
                }

            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int size = choices.size();
                String str = "";
                for (int i = 0; i < size; i++ ){
                    str += items[choices.get(i)] + " ";
                }
                toastShort("You chose: " + str);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                toastLong("Cancel was clicked");
            }
        });
        builder.show();
    }

    ProgressDialog waitingDialog;
    private void waitingDialog(){
        waitingDialog = new ProgressDialog(this);
        waitingDialog.setTitle("I'm a waiting Dialog");
        waitingDialog.setMessage("Waiting...");
        waitingDialog.setCancelable(true);
        waitingDialog.show();
        waitingDialog.setOnDismissListener(new DialogInterface.OnDismissListener(){

            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                toastShort("Dialog was canceled!");
                //stop the downlaod thread
            }
        });

    }

    private void progressDialog(){
        final int MAX_PROGRESS = 100;
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setProgress(0);
        progressDialog.setTitle("Downloading");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMax(MAX_PROGRESS);
        progressDialog.show();

        new Thread(new Runnable() {
            @Override
            public void run(){
                int progress = 0;
                        while (progress < MAX_PROGRESS){
                            try{
                                Thread.sleep(100);
                                progress++;
                                progressDialog.setProgress(progress);
                            } catch (InterruptedException e){
                                e.printStackTrace();
                            }
                        }
                progressDialog.cancel();
                //toastShort("Download success");
            }

        }).start();
    }

    int choice = 0;
    private void singleChoiceDialog(){
        final String[] items = {"item1","item2","item3","item4"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("I'm a Single Choice Dialog");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setSingleChoiceItems(items, choice, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                choice = which;
                toastShort("You chose: "+items[which]);
            }
        });
        builder.show();
    }

    private void listDialog(){
        final String[] items = {"item1","item2","item3","item4"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("I'm a List Dialog");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                toastShort("You clicked: "+items[which]);
            }
        });
        builder.show();
    }


    private void normalDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("AlertTitle");
        builder.setMessage("This is a normal Dialog");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                toastLong("You clicked Yes");
            }
        });
        builder.setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                toastShort("You clicked Neutral");
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                toastShort("You clicked Cancel");
            }
        });

        builder.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        ButterKnife.bind(this);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                toastShort("You checked the RadioButtion"+checkedId);
                checkedID = checkedId;
            }
        });
    }
}
