package com.example.hello;

import android.app.Activity;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Item_KT2 extends BaseAdapter {
    private Activity activity;

    private String[] lts;
    private String[] timeStarts;
    private String[] timeEnds;
    private Integer[] vehicle_id;

    public Item_KT2(Activity ac, String[] lt, String[] t1, String[] t2, Integer[] vehicle) {
        this.activity = ac;
        this.lts = lt;
        this.timeStarts = t1;
        this.timeEnds = t2;
        this.vehicle_id = vehicle;
    }

    private String getDayAndNightTime(int i) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        long diff = sdf.parse(timeEnds[i]).getTime() - sdf.parse(timeStarts[i]).getTime();
        long diff_In_Days
                = diff
                / (1000 * 60 * 60 * 24);
        long dayCount = diff_In_Days;
        long nightCount = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sdf.parse(timeStarts[i]));
        for (int j = 0; j < diff_In_Days; j++) {
            int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
            if (currentHour >= 6 && currentHour < 18) {
                dayCount++;
            } else {
                nightCount++;
            }
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        return dayCount+" ngày " + nightCount + " đêm";
    }

    private void showToast(String msg) {
        Toast.makeText(activity.getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getCount() {
        return lts.length;
    }

    @Override
    public Object getItem(int i) {
        return lts[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        view = layoutInflater.inflate(R.layout.item_kiemtra2, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.vehicle_img);
        TextView textView = (TextView) view.findViewById(R.id.nd_time);

        imageView.setImageResource(vehicle_id[i]);
//        textView.setText(lts[i] + "    " + "3 ngay 2 dem");
        try {
            textView.setText(lts[i] + "    " + getDayAndNightTime(i));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return view;
    }
}
