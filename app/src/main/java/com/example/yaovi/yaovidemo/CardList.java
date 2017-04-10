package com.example.yaovi.yaovidemo;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.yaovi.yaovidemo.adapter.MyAdapter;

import java.util.ArrayList;

public class CardList extends AppCompatActivity {

    ListView listView;

    ArrayList<Integer> idImages;

    ArrayList<String> nameList;

    MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_list);

        listView = (ListView) findViewById(R.id.listview);

        idImages = new ArrayList<>();
        nameList = new ArrayList<>();
        idImages = getList();
        nameList = getNameList();

        myAdapter = new MyAdapter(CardList.this,idImages,nameList);

        listView.setAdapter(myAdapter);
    }

    public ArrayList<Integer> getList() {
        idImages = new ArrayList<>();

        idImages.add(R.drawable.profilepic);
        idImages.add(R.drawable.profilepic);
        idImages.add(R.drawable.profilepic);
        idImages.add(R.drawable.profilepic);

        return idImages;

    }

    public ArrayList<String> getNameList(){
        nameList = new ArrayList<>();

        nameList.add("Player A");
        nameList.add("Player B");
        nameList.add("Player C");
        nameList.add("Player D");

        return nameList;
    }
}
