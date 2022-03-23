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

import com.squareup.picasso.Picasso;

public class custom_view_familiar extends BaseAdapter {
    String[]name;
    String[]email;
    String[]phone;
    String[]relation;
    String[]image;
    private Context context;
    public custom_view_familiar(Context appcontext, String[]image, String[]name, String[]email, String[]phone, String[]relation)
    {
        this.context=appcontext;
        this.name=name;
        this.email=email;
        this.phone=phone;
        this.relation=relation;
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
            gridView=inflator.inflate(R.layout.custom_fo_view_fam_person,null);

        }
        else
        {
            gridView=(View)view;

        }
        ImageView tvimage=(ImageView)gridView.findViewById(R.id.imageView3);
        TextView tvname=(TextView)gridView.findViewById(R.id.textView33);
        TextView tvemail=(TextView)gridView.findViewById(R.id.textView40);
        TextView tvphn=(TextView)gridView.findViewById(R.id.textView41);
        TextView tvrltn=(TextView)gridView.findViewById(R.id.textView42);
        //ImageView im=(ImageView) gridView.findViewById(R.id.imageView10);

        tvname.setTextColor(Color.BLACK);


        tvname.setText(name[i]);
        tvemail.setText(email[i]);
        tvphn.setText(phone[i]);
        tvrltn.setText(relation[i]);


        SharedPreferences sh= PreferenceManager.getDefaultSharedPreferences(context);
        String ip=sh.getString("ip","");

        String url="http://" + ip + ":5000/"+image[i];


        Picasso.with(context).load(url). into(tvimage);

        return gridView;


        // return null;
    }
}
