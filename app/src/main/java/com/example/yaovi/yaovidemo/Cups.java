package com.example.yaovi.yaovidemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

import com.example.yaovi.yaovidemo.bean.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Cups extends BaseActivity {
    ImageView left, middle, right;
    Button new_game;



    List<Integer> cards;

    CustomPager mCustomPagerAdapter;
    ViewPager mViewPager;

    int show = 1;

    @OnClick(R.id.button3)
    public void cardList(){
        toActivity(CardList.class);
    }


    @OnClick(R.id.deck_button)
    public void deckViewer(){
        if(show == 1){
            mViewPager.setVisibility(View.VISIBLE);
            show = 0;
        }
        if(show == 0){
            mViewPager.setVisibility(View.INVISIBLE);
            show = 1;
        }

    }

//    @OnClick(R.id.deck_button2)
//    public void deckViewer2(){
//        mViewPager.setVisibility(View.VISIBLE);
//    }

//    CheckBox box1 = (CheckBox) findViewById(R.id.box1);



    @OnClick(R.id.deck_button2)
    public void Quiz4(){
        final Quiz4 dialog2 = new Quiz4(this, new Quiz4.ICustomDialogEventListener() {
            @Override
            public void onClickListener() {
                Intent intent = new Intent(Cups.this, DialogActivity.class);
                startActivity(intent);
            }
            @Override
            public void onClickListener2() {
                Intent intent = new Intent(Cups.this, ListViewActivity.class);
                startActivity(intent);
            }

            @Override
            public void onCancel() {
                //Intent intent = new Intent(Cups.this,ViewPagerActivity.class);
                //intent.putExtra("key","value");
                Bundle bundle = new Bundle();
                bundle.putInt("Integer", 12345);
                Book book = new Book();
                book.setName("Android");
                book.setAuthor("Laura");
                bundle.putSerializable("book", book);
                //intent.putExtras(bundle);
                //startActivityForResult(intent, 1);
            }
        });
        dialog2.show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cups);
        ButterKnife.bind(this);

        mCustomPagerAdapter = new CustomPager(this);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mViewPager.setAdapter(mCustomPagerAdapter);


        left = (ImageView) findViewById(R.id.left);
        middle = (ImageView) findViewById(R.id.middle);
        right = (ImageView) findViewById(R.id.right);

        new_game = (Button) findViewById(R.id.new_game);

        cards = new ArrayList<>();
        cards.add(107); //spades
        cards.add(207); //hearts
        cards.add(407); //diamonds

        //intial scrambles the list of cards
        Collections.shuffle(cards);

        new_game.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                ImageView imageView = (ImageView) findViewById(R.id.imageView);
                int img = imageView.getImageAlpha();

                Log.d("Alpha", ""+img);

                Bitmap bmp = getBitmapFromView(imageView);

                left.setImageBitmap(bmp);
                middle.setImageBitmap(bmp);
                right.setImageBitmap(bmp);

//                left.setImageResource(R.drawable.ic_cardback);
//                middle.setImageResource(R.drawable.ic_cardback);
//                right.setImageResource(R.drawable.ic_cardback);



                //scrambles the list of cards
                Collections.shuffle(cards);



                Animation anim_left = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left);
                Animation anim_middle = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.middle);
                Animation anim_right = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right);

                left.startAnimation(anim_left);
                middle.startAnimation(anim_middle);
                right.startAnimation(anim_right);


            }
        });

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //assign images
                if (cards.get(0) == 107) {
                    left.setImageResource(R.drawable.ic_spades);
                    toastShort("Correct!");
                } else if (cards.get(0) == 207) {
                    left.setImageResource(R.drawable.ic_hearts);
                } else if (cards.get(0) == 407) {
                    left.setImageResource(R.drawable.ic_diamonds);
                }

                if (cards.get(1) == 107) {
                    middle.setImageResource(R.drawable.ic_spades);
                } else if (cards.get(1) == 207) {
                    middle.setImageResource(R.drawable.ic_hearts);
                } else if (cards.get(1) == 407) {
                    middle.setImageResource(R.drawable.ic_diamonds);
                }

                if (cards.get(2) == 107) {
                    right.setImageResource(R.drawable.ic_spades);
                } else if (cards.get(2) == 207) {
                    right.setImageResource(R.drawable.ic_hearts);
                } else if (cards.get(2) == 407) {
                    right.setImageResource(R.drawable.ic_diamonds);
                }

            }
        });

        middle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //assign images
                if (cards.get(1) == 107) {
                    middle.setImageResource(R.drawable.ic_spades);
                    toastShort("Correct!");
                } else if (cards.get(1) == 207) {
                    middle.setImageResource(R.drawable.ic_hearts);
                } else if (cards.get(1) == 407) {
                    middle.setImageResource(R.drawable.ic_diamonds);
                }

                if (cards.get(0) == 107) {
                    left.setImageResource(R.drawable.ic_spades);
                } else if (cards.get(0) == 207) {
                    left.setImageResource(R.drawable.ic_hearts);
                } else if (cards.get(0) == 407) {
                    left.setImageResource(R.drawable.ic_diamonds);
                }

                if (cards.get(2) == 107) {
                    right.setImageResource(R.drawable.ic_spades);
                } else if (cards.get(2) == 207) {
                    right.setImageResource(R.drawable.ic_hearts);
                } else if (cards.get(2) == 407) {
                    right.setImageResource(R.drawable.ic_diamonds);
                }

            }
        });

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //assign cards
                if (cards.get(2) == 107) {
                    right.setImageResource(R.drawable.ic_spades);
                    toastShort("Correct!");
                } else if (cards.get(2) == 207) {
                    right.setImageResource(R.drawable.ic_hearts);
                } else if (cards.get(2) == 407) {
                    right.setImageResource(R.drawable.ic_diamonds);
                }

                if (cards.get(1) == 107) {
                    middle.setImageResource(R.drawable.ic_spades);
                } else if (cards.get(1) == 207) {
                    middle.setImageResource(R.drawable.ic_hearts);
                } else if (cards.get(1) == 407) {
                    middle.setImageResource(R.drawable.ic_diamonds);
                }

                if (cards.get(0) == 107) {
                    left.setImageResource(R.drawable.ic_spades);
                } else if (cards.get(0) == 207) {
                    left.setImageResource(R.drawable.ic_hearts);
                } else if (cards.get(0) == 407) {
                    left.setImageResource(R.drawable.ic_diamonds);
                }

            }
        });
    }

    public static Bitmap getBitmapFromView(View view) {
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view
                .getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        Drawable bgDrawable = view.getBackground();
        if (bgDrawable != null)
            bgDrawable.draw(canvas);
        else
            // if we unable to get background drawable then we will set white color as wallpaper
            canvas.drawColor(Color.WHITE);
        view.draw(canvas);
        return returnedBitmap;
    }


}
