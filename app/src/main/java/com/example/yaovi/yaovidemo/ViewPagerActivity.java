package com.example.yaovi.yaovidemo;
//import android.support.design.widget.TabLayout;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yaovi.yaovidemo.adapter.ViewPagerAdapter;
import com.example.yaovi.yaovidemo.bean.Book;
import com.example.yaovi.yaovidemo.fragment.ContentFragment;
import com.example.yaovi.yaovidemo.fragment.HistoryFragment;
import com.example.yaovi.yaovidemo.fragment.LoginFragment;
import com.example.yaovi.yaovidemo.util.UtilLog;

import java.util.ArrayList;

import static android.support.design.R.styleable.TabLayout;

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
    //private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String message = intent.getStringExtra("key");
        int number = bundle.getInt("Integer",0);
        int fakeNumber = bundle.getInt("fake",0);
        Book book = (Book) bundle.getSerializable("book");

        UtilLog.logD("ViewPagerActivity, value is: ", message);
        UtilLog.logD("ViewPagerActivity, number is: ", ""+number);
        UtilLog.logD("ViewPagerActivity, fake number is: ", String.valueOf(fakeNumber));
        UtilLog.logD("ViewPagerActivity, book author is: ", book.getAuthor());

        initial();
    }

    private void initial() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        fragmentList.add(new LoginFragment());
        fragmentList.add(new HistoryFragment());
        fragmentList.add(new ContentFragment());
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this.getSupportFragmentManager());
        viewPagerAdapter.setContent(fragmentList);
        viewPager.setAdapter(viewPagerAdapter);
        
//        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
//        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("message","ViewPager");
        setResult(RESULT_OK, intent);
        super.onBackPressed();
    }
}
