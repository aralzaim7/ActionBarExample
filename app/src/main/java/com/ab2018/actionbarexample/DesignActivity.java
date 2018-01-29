package com.ab2018.actionbarexample;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DesignActivity extends AppCompatActivity {

    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design);

        Intent collapseIntent = getIntent();

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);
        //coordinatorLayout = (CoordinatorLayout) getLayoutInflater().inflate(R.layout.activity_design,null,false);



        //android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(coordinatorLayout, "Snackbaaaar", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });
    }
}
