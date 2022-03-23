package com.example.mask_violations;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mask_violations.databinding.ActivityHomeBinding;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarHome.toolbar);
        binding.appBarHome.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        navigationView.setNavigationItemSelectedListener(this);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        navigationView.bringToFront();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home);
//        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
//                || super.onSupportNavigateUp();
//    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.nav_profile){
            startActivity(new Intent(getApplicationContext(),fo_view.class));
        }
        else if(id==R.id.nav_visitor){
            startActivity(new Intent(getApplicationContext(),vis_log.class));
        }
        else if(id==R.id.nav_mask_violation_alert){
            startActivity(new Intent(getApplicationContext(),mv_alert.class));
        }
        else if(id==R.id.nav_staff_suggestions){
            startActivity(new Intent(getApplicationContext(),staff_sugestions.class));
        }
        else if(id==R.id.nav_add_familiar_persons){
            startActivity(new Intent(getApplicationContext(),addfamiliar_person.class));
        }
        else if(id==R.id.nav_view_familiar){
            startActivity(new Intent(getApplicationContext(),view_familiar_person.class));
        }
        else if(id==R.id.nav_notifications){
            startActivity(new Intent(getApplicationContext(),view_nots.class));
        }
        else if(id==R.id.nav_logout){
            startActivity(new Intent(getApplicationContext(),Login.class));
        }
        return true;
    }
}