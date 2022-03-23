package com.example.mask_violations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Set_ip extends AppCompatActivity implements View.OnClickListener {
EditText edip;
Button btip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_ip);
        edip=(EditText) findViewById(R.id.editTextTextPersonName3);
        btip=(Button)  findViewById(R.id.button2);


        btip.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String edit=edip.getText().toString();
        if(edit.length()==0){
            edip.setError("Missing");
        }
        else{
            SharedPreferences sh= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            SharedPreferences.Editor ed=sh.edit();
            ed.putString("ip",edit);
            ed.commit();

            startActivity(new Intent(getApplicationContext(),Login.class));

        }

    }
}