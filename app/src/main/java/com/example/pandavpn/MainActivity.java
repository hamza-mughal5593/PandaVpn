package com.example.pandavpn;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.pandavpn.SplitTunneling.SplitTunnelingActivity;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawer;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.country_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ServerActivity.class));
            }
        });

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        findViewById(R.id.menu_ic).setOnClickListener(view -> {

            if (drawer.isDrawerOpen(navigationView)) {
                drawer.closeDrawer(navigationView);
            } else {
                drawer.openDrawer(navigationView);
            }
        });

        navigationView.setNavigationItemSelectedListener(item -> {

            int id = item.getItemId();
            if (id == R.id.nav_rate) {
                drawer.closeDrawer(navigationView);
                final Uri uri = Uri.parse("market://details?id=" + getApplicationContext().getPackageName());
                final Intent rateAppIntent = new Intent(Intent.ACTION_VIEW, uri);

                if (getPackageManager().queryIntentActivities(rateAppIntent, 0).size() > 0) {
                    startActivity(rateAppIntent);
                }

            } else if (id == R.id.nav_split) {
                drawer.closeDrawer(navigationView);
                startActivity(new Intent(MainActivity.this, SplitTunnelingActivity.class));

            } else if (id == R.id.nav_setting) {
                drawer.closeDrawer(navigationView);
               startActivity(new Intent(MainActivity.this,SettingMainActivity.class));
            }

            return true;
        });
    }
}