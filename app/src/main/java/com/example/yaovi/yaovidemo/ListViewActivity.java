package com.example.yaovi.yaovidemo;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yaovi.yaovidemo.adapter.ListViewAdapter;
import com.example.yaovi.yaovidemo.adapter.ViewPagerAdapter;
import com.example.yaovi.yaovidemo.fragment.Image3;
import com.example.yaovi.yaovidemo.fragment.Image4;
import com.example.yaovi.yaovidemo.fragment.Image5;
import com.example.yaovi.yaovidemo.fragment.Image6;
import com.example.yaovi.yaovidemo.fragment.Image7;
import com.example.yaovi.yaovidemo.fragment.Image8;
import com.example.yaovi.yaovidemo.fragment.ImageFragment;
import com.example.yaovi.yaovidemo.fragment.ImageFragment2;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView listView;
    private ArrayList<String> listResult;
    private ViewPager viewPager;
    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listResult = new ArrayList<String>();
        createFakeResult();
        initialView();
    }

    private void createFakeResult() {
        listResult.add("A");
        listResult.add("BBB");
        listResult.add("CCCC");
        listResult.add("D");
        listResult.add("E");
        listResult.add("F");
        listResult.add("G");
        listResult.add("H");
        listResult.add("I");
        listResult.add("J");
        listResult.add("K");
        listResult.add("L");
        listResult.add("M");
        listResult.add("N");
        listResult.add("O");
        listResult.add("P");
        listResult.add("Q");
    }

    private void initialView() {
        listView = (ListView) findViewById(R.id.list_view);
        ListViewAdapter listViewAdapter = new ListViewAdapter(this,listResult);

        View view = getLayoutInflater().inflate(R.layout.list_view_header,null);
        LinearLayout listViewHeader = (LinearLayout) view.findViewById(R.id.list_view_header);

        //test
        viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        fragmentList.add(new ImageFragment());
        fragmentList.add(new ImageFragment2());
        fragmentList.add(new Image3());
        fragmentList.add(new Image4());
        fragmentList.add(new Image5());
        fragmentList.add(new Image6());
        fragmentList.add(new Image7());
        fragmentList.add(new Image8());



       // ListViewAdapter listViewAdapter = new ListViewAdapter(this,listResult);
        listView.addHeaderView(view);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this.getSupportFragmentManager());
        viewPagerAdapter.setContent(fragmentList);
        viewPager.setAdapter(viewPagerAdapter);
        listView.addHeaderView(listViewHeader);


        TextView tv = new TextView(this);
        tv.setText("We have no more content.");
        tv.setTextSize(28);
        tv.setGravity(Gravity.CENTER);
        listView.addFooterView(tv);
        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Toast.makeText(this, "listView was clicked at position:"+position,Toast.LENGTH_LONG).show();

        Log.d("testListViewActivity",String.valueOf(position));
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("message","ViewPager");
        setResult(RESULT_OK, intent);
        super.onBackPressed();
    }
}
