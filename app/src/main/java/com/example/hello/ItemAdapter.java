package com.example.hello;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ItemAdapter extends BaseAdapter {
    private Activity activity;
    private String[] items;
    private String[] subnames;
    private Integer[] img;

    public ItemAdapter(Activity activity, String[] items, String[] subnames, Integer[] img) {
        this.items = items;
        this.activity = activity;
        this.img = img;
        this.subnames = subnames;
    }


    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int i) {
        return items[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    private void showToast(String msg) {
        Toast.makeText(activity.getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public View getView(int i, View v, ViewGroup vG) {
        LayoutInflater inflater = activity.getLayoutInflater();

        v = inflater.inflate(R.layout.item_view, null);

        TextView tv = (TextView) v.findViewById(R.id.item_name);
        TextView subname = (TextView) v.findViewById(R.id.item_subname);
        ImageView imgV = (ImageView) v.findViewById(R.id.item_image);

        tv.setText(items[i]);
        subname.setText(subnames[i]);
        imgV.setImageResource(img[i]);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("Click to " + items[i]);
            }
        });

        return v;
    }

}


