package com.markcode.printingshopapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.tabs.TabLayout;

public class MainPage extends AppCompatActivity {

    TabLayout tabLayout;
    FrameLayout frameLayout;
    Fragment fragment = null;

    FragmentManager fragmentManager;

    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_page);

        tabLayout = findViewById(R.id.tabLayout_mp);
        frameLayout = findViewById(R.id.frameLayout);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragment = new DashboardFragment();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
        fragmentTransaction.commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                switch(tab.getPosition())
                {
                    case 0:
                        tab.setIcon(R.drawable.ic_dashboard);
                        fragment = new DashboardFragment();
                        break;
                    case 1:
                        tab.setIcon(R.drawable.ic_productorders);
                        fragment = new ProductOrdersFragment();
                        break;
                    case 2:
                        tab.setIcon(R.drawable.ic_account);
                        fragment = new AccnountFragment();
                        break;

                }

                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frameLayout,fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainPage.this);
        builder.setTitle("Exit")
                .setMessage("Are you sure you want to sign out")
                .setIcon(R.drawable.ic_sign_out)
                .setPositiveButton("Sign-out", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent= new Intent(MainPage.this,MainActivity.class);
                        startActivity(intent);

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }
}