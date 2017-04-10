package com.example.yaovi.yaovidemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yaovi.yaovidemo.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Yaovi on 4/6/17.
 */

public class MyAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Integer> listId;
    private ArrayList<String> nameList;

    public MyAdapter(Context context, ArrayList<Integer> listId, ArrayList<String> nameList) {
        this.context = context;
        this.listId = listId;
        this.nameList = nameList;
    }

    @Override
    public int getCount() {
        return nameList.size();
    }

    @Override
    public Object getItem(int i) {
        return nameList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null){
            view = View.inflate(context, R.layout.items_cards_list,null);

        }

        ImageView images = (ImageView) view.findViewById(R.id.imageView4);
        TextView text = (TextView) view.findViewById(R.id.textView);

        images.setImageResource(listId.get(i));
        text.setText(nameList.get(i));


        return view;
    }
}
