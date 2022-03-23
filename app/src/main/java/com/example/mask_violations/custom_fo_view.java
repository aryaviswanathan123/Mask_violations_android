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

public class custom_fo_view extends BaseAdapter {
    String[]name;
    String[]house;
    String[]place;
    String[]contact;
    String[]email;
    String[]pin;
    private Context context;
    public custom_fo_view(Context appcontext, String[]name, String[]house, String[]place, String[]contact, String[]email, String[]pin)
    {
        this.context=appcontext;
        this.name=name;
        this.house=house;
        this.place=place;
        this.contact=contact;
        this.email=email;
        this.pin=pin;




    }


    @Override
    public int getCount() {
        return 0;
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
        TextView tname=(TextView)gridView.findViewById(R.id.textView13);
        TextView thouse=(TextView)gridView.findViewById(R.id.textView15);
        TextView tplace=(TextView)gridView.findViewById(R.id.textView18);
        TextView tcontact=(TextView)gridView.findViewById(R.id.textView21);
        TextView temail=(TextView)gridView.findViewById(R.id.textView25);
        TextView tpin=(TextView)gridView.findViewById(R.id.textView30);

        //ImageView im=(ImageView) gridView.findViewById(R.id.imageView10);

        tname.setTextColor(Color.BLACK);


        tname.setText(name[i]);
        thouse.setText(house[i]);
        tplace.setText(place[i]);
        tcontact.setText(contact[i]);
        temail.setText(email[i]);
        tpin.setText(pin[i]);



        SharedPreferences sh= PreferenceManager.getDefaultSharedPreferences(context);
        String ip=sh.getString("ip","");

        // String url="http://" + ip + ":5000/static/game/"+gamecode[i]+".jpg";


        //Picasso.with(context).load(url).transform(new CircleTransform()). into(im);

        return gridView;


        // return null;
    }
}


