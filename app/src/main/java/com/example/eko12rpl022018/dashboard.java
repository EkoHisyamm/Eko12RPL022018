package com.example.eko12rpl022018;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class dashboard extends AppCompatActivity {

    SharedPreferences sp;
    ImageView btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btnLogout = (ImageView) findViewById(R.id.btnLogout);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //if (item.getItemId() == R.id.miCompose) {
            new AlertDialog.Builder(this)
                    .setTitle("Really Logout?")
                    .setMessage("Are you sure you want to logout?")
                    .setNegativeButton(android.R.string.no, null)
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface arg0, int arg1) {
                            sp = getSharedPreferences("login",MODE_PRIVATE);
                            sp.edit().putBoolean("logged",false).apply();
                            Intent intent = new Intent(dashboard.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }).create().show();
            return true;
        //}
      //  return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Really Exit?")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        dashboard.super.onBackPressed();
                    }
                }).create().show();
    }

}