package com.example.mask_violations;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class custom_view_nots extends BaseAdapter {

    String[]nots;
    String[]date;
    String[]time;
    private Context context;
    public custom_view_nots(Context appcontext, String[]nots, String[]date, String[]time)
    {
        this.context=appcontext;
        this.nots=nots;
        this.date=date;
        this.time=time;




    }


    @Override
    public int getCount() {
        return nots.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflator=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;
        if(view==null)
        {
            gridView=new View(context);
            //gridView=inflator.inflate(R.layout.customview, null);
            gridView=inflator.inflate(R.layout.custom_view_nots,null);

        }
        else
        {
            gridView=(View)view;

        }
        TextView tnots=(TextView)gridView.findViewById(R.id.textView31);
        TextView tdate=(TextView)gridView.findViewById(R.id.textView36);
        TextView ttime=(TextView)gridView.findViewById(R.id.textView37);

        tnots.setTextColor(Color.BLACK);
        tdate.setTextColor(Color.BLACK);
        ttime.setTextColor(Color.BLACK);

        tnots.setText("Notification :"+nots[i]);
        tdate.setText("Date :"+date[i]);
        ttime.setText("Time :"+time[i]);





        //Picasso.with(context).load(url).transform(new CircleTransform()). into(im);

        return gridView;


        // return null;
    }
}


