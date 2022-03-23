package com.example.mask_violations;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class custom_mv_alert extends BaseAdapter {
    String[]image;
    String[]name;
    String[]date;
    private Context context;
    public custom_mv_alert(Context appcontext,String[]image,  String[]name, String[]date)
    {
        this.context=appcontext;
        this.name=name;
        this.date=date;
        this.image=image;




    }


    @Override
    public int getCount() {
        return name.length;
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
            gridView=inflator.inflate(R.layout.activity_mv_alert,null);

        }
        else
        {
            gridView=(View)view;

        }
        ImageView timage=(ImageView)gridView.findViewById(R.id.imageView6);
        TextView tname=(TextView)gridView.findViewById(R.id.textView32);
        TextView tdate=(TextView)gridView.findViewById(R.id.textView43);

        //ImageView im=(ImageView) gridView.findViewById(R.id.imageView10);

        tname.setTextColor(Color.BLACK);


        tname.setText(name[i]);
        tdate.setText(date[i]);



        SharedPreferences sh= PreferenceManager.getDefaultSharedPreferences(context);
        String ip=sh.getString("ip","");

        // String url="http://" + ip + ":5000/static/game/"+gamecode[i]+".jpg";


        //Picasso.with(context).load(url).transform(new CircleTransform()). into(im);

        return gridView;


        // return null;
    }
}
