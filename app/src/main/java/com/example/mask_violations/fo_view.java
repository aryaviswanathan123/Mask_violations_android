package com.example.mask_violations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class fo_view extends AppCompatActivity {
    ImageView imfo;
TextView nmfo;
TextView hnfo;
TextView plfo;
TextView cnfo;
TextView emfo;
TextView pifo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fo_view);
        imfo=(ImageView) findViewById(R.id.imageView8);
        nmfo=(TextView) findViewById(R.id.textView49);
        hnfo=(TextView) findViewById(R.id.textView50);
        plfo=(TextView) findViewById(R.id.textView51);
        cnfo=(TextView) findViewById(R.id.textView52);
        emfo=(TextView) findViewById(R.id.textView53);
        pifo=(TextView) findViewById(R.id.textView54);

        SharedPreferences sh= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        final String maclis=sh.getString("mac_list","");
        String uid=sh.getString("lid","");
        String hu = sh.getString("ip", "");
        String url = "http://" + hu + ":5000/and_viewstf_post";



        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //  Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();

                        // response
                        try {
                            JSONObject jsonObj = new JSONObject(response);
                            if (jsonObj.getString("status").equalsIgnoreCase("ok")) {

                                String name= jsonObj.getString("name");
                                String housename=jsonObj.getString("housename");
                                String place=jsonObj.getString("place");
                                String contact=jsonObj.getString("contact");
                                String email=jsonObj.getString("email");
                                String pin=jsonObj.getString("pin");
                                String img=jsonObj.getString("image");
                                nmfo.setText(name);
                                hnfo.setText(housename);
                                plfo.setText(place);
                                cnfo.setText(contact);
                                emfo.setText(email);
                                pifo.setText(pin);
                                SharedPreferences sh= PreferenceManager.getDefaultSharedPreferences(getApplicationContext().getApplicationContext());
                                String ip=sh.getString("ip","");

                                String url="http://" + ip + ":5000/"+img;


                                Picasso.with(getApplicationContext()).load(url). into(imfo);


                            }


                            // }
                            else {
                                Toast.makeText(getApplicationContext(), "Not found", Toast.LENGTH_LONG).show();
                            }

                        }    catch (Exception e) {
                            Toast.makeText(getApplicationContext(), "Error" + e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Toast.makeText(getApplicationContext(), "eeeee" + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                SharedPreferences sh = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                Map<String, String> params = new HashMap<String, String>();

                String id=sh.getString("lid","");
                params.put("lid",id);
//                params.put("mac",maclis);

                return params;
            }
        };

        int MY_SOCKET_TIMEOUT_MS=100000;

        postRequest.setRetryPolicy(new DefaultRetryPolicy(
                MY_SOCKET_TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(postRequest);


    }
}

