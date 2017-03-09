package com.example.yaovi.yaovidemo;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.yaovi.yaovidemo.bean.Book;
import com.example.yaovi.yaovidemo.util.UtilLog;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements View.OnTouchListener {

    private ImageButton bt1;
    private ImageButton bt3;
    private ImageButton bt2;
    private ImageButton bt4;

    @OnClick(R.id.Quiz4)
    public void Quiz4(){
        final Quiz4 dialog = new Quiz4(this, new Quiz4.ICustomDialogEventListener() {
            @Override
            public void onClickListener() {
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
            }

            @Override
            public void onClick2Listener() {
                Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                startActivity(intent);
            }

            @Override
            public void onClickCancel() {
                Intent intent = new Intent(MainActivity.this,ViewPagerActivity.class);
                intent.putExtra("key","value");
                Bundle bundle = new Bundle();
                bundle.putInt("Integer", 12345);
                Book book = new Book();
                book.setName("Android");
                book.setAuthor("Laura");
                bundle.putSerializable("book", book);
                intent.putExtras(bundle);
                startActivityForResult(intent, 1);
            }
        });
        dialog.show();
    }


    @BindView(R.id.main_fl)
    FrameLayout fl;
    private GestureDetector mGestureDetector;



    @OnClick(R.id.main_animator_bt)
        public void toAnimator(){
            toActivity(AnimatorActivity.class);
    }


    @OnClick(R.id.bt4)
    public void toActivityA() {
        toActivity(ActivityA.class);
    }

    @OnClick(R.id.main_anim_bt)
    public void toAnimation(){
        toActivity(AnimationActivity.class);
    }

    @OnClick(R.id.main_timer_bt)
    public void toTimer(){
        toActivity(TimerActivity.class);
    }
    @OnClick(R.id.bt2)
    public void button2Click(){
        Intent intent = new Intent(this,DialogActivity.class);
        startActivityForResult(intent, 2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();
        initialListener();
        ButterKnife.bind(this);
        mGestureDetector = new GestureDetector(this, new simpleGestureListener());
        fl.setOnTouchListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        toastShort("onShort");
    }

    private void initialView() {
//        bt2 = (ImageButton) findViewById(R.id.bt2);
        bt1 = (ImageButton) findViewById(R.id.bt1);
        bt3 = (ImageButton) findViewById(R.id.bt3);
        bt4 = (ImageButton) findViewById(R.id.bt4);
    }


    private void initialListener(){
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Button1 was clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(v.getContext(),ViewPagerActivity.class);
                intent.putExtra("key","value");
                Bundle bundle = new Bundle();
                bundle.putInt("Integer",12345);
                intent.putExtras(bundle);
                Book book = new Book();
                book.setName("Android");
                book.setAuthor("Yaovi");
                bundle.putSerializable("book",book);
                intent.putExtras(bundle);
                startActivityForResult(intent,1);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ListViewActivity.class);
                startActivityForResult(intent,3);

                toActivity(ListViewActivity.class);
//                Intent intent = new Intent(v.getContext(),ListViewActivity.class);
//                startActivity(intent);
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ActivityA.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:
                String message = data.getStringExtra("message");
                toastShort("message");
                break;
            case 2:
                toastShort("Dialog");
                break;
            case 3:
                toastLong("ListView");
                break;
        }
    }

    public void onClick(View v){
        //Toast.makeText(this, "Button2 was clicked",Toast.LENGTH_LONG).show();
        toastLong("Button2 was clicked");
        UtilLog.logD("testD","toast");
    }
    
    @Override
    public boolean onTouch(View v, MotionEvent event){
        return mGestureDetector.onTouchEvent(event);
    }

    private class simpleGestureListener extends GestureDetector.SimpleOnGestureListener{
        public boolean onDown(MotionEvent e) {
            UtilLog.logD("My Gesture", "onDown");
            toastShort("onDown");
            return false;
        }

        public void onShowPress(MotionEvent e) {
            UtilLog.logD("My Gesture", "onShowPress");
            toastShort("onShowPress");
        }

        public void onLongPress(MotionEvent e) {
            UtilLog.logD("My Gesture", "onLongPress");
            toastShort("onLongPress");
        }

        public boolean onSingleTapUp(MotionEvent e) {
            UtilLog.logD("My Gesture", "onSingleTapUp");
            toastShort("onSingleTapUp");
            return true;
        }

        public boolean onSingleTapConfirmed(MotionEvent e) {
            UtilLog.logD("My Gesture", "onSingleTapConfirmed");
            toastShort("onSingleTapConfirmed");
            return true;
        }

        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY){
            UtilLog.logD("MyGesture", "onScroll:" + (e2.getX() - e1.getX()) + "  " + distanceX);
            toastShort("onScroll");
            return true;
        }

        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            //UtilLog.logD("MyGesture", "onFling");
            toastShort("onFling");
            return true;
        }

        public boolean onDoubleTap(MotionEvent e) {
            //UtilLog.logD("My Gesture", "onDoubleTap");
            toastShort("onDoubleTap");
            return true;
        }

        public boolean onDoubleTapEvent(MotionEvent e) {
            //UtilLog.logD("My Gesture", "onDoubleTapEvent");
            toastShort("onDoubleTapEvent");
            return true;
        }
    }
}
