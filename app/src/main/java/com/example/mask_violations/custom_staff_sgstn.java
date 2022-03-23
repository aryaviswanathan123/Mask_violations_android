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

public class custom_staff_sgstn extends BaseAdapter {

    String[]name;
    String[]description;
    String[]date;
    private Context context;
    public custom_staff_sgstn(Context appcontext, String[]name, String[]description, String[]date)
    {
        this.context=appcontext;
        this.name=name;
        this.description=description;
        this.date=date;




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
            gridView=inflator.inflate(R.layout.custom_staff_suggestions,null);

        }
        else
        {
            gridView=(View)view;

        }
        TextView tname=(TextView)gridView.findViewById(R.id.textView9);
        TextView tdesc=(TextView)gridView.findViewById(R.id.textView12);
        TextView tdate=(TextView)gridView.findViewById(R.id.textView29);

        //ImageView im=(ImageView) gridView.findViewById(R.id.imageView10);

        tname.setTextColor(Color.BLACK);


        tname.setText(name[i]);
        tdesc.setText(description[i]);
        tdate.setText(date[i]);



//        SharedPreferences sh= PreferenceManager.getDefaultSharedPreferences(context);
//        String ip=sh.getString("ip","");

        // String url="http://" + ip + ":5000/static/game/"+gamecode[i]+".jpg";


        //Picasso.with(context).load(url).transform(new CircleTransform()). into(im);

        return gridView;


        // return null;
    }
}

