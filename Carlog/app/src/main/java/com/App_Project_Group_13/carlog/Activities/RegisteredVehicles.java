package com.app_project_group_13.carlog.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.app_project_group_13.carlog.R;

public class RegisteredVehicles extends AppCompatActivity {

    //widgets
    private TextView txtVehicleName;
    private RecyclerView rcvList;
    //private Adapter = adaptor;
    private Button btnBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //init ui
        setupUI();

    }

    private void setupUI() {
        setContentView(R.layout.activity_registered_vehicles);

        //set up recyclerview with adapter and layout manager
        //adapter = new (this); //skal oprates
        rcvList = findViewById(R.id.rcvRegisteredVehicles);
        rcvList.setLayoutManager(new LinearLayoutManager(this));
        //rcvList.setAdapter(adapter); //skal oprates

        txtVehicleName = findViewById(R.id.txtRVVehicleName);

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Back();
            }
        });
    }

    private void Back() {
        finish();
    }
}