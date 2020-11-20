package com.App_Project_Group_13.carlog.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.app_project_group_13.carlog.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.App_Project_Group_13.carlog.Models.VehicleDataFirebase;
import com.App_Project_Group_13.carlog.Adapters.RegisteredVehiclesAdapter;
import com.App_Project_Group_13.carlog.Constants.Constants;

import java.util.ArrayList;

public class RegisteredVehicles extends AppCompatActivity implements RegisteredVehiclesAdapter.IRegisteredVehiclesItemClickedListener {

    //widgets
    private TextView txtVehicleName;
    private RecyclerView rcvList;
    //private Adapter = adaptor;
    private Button btnBack;
    private ArrayList<VehicleDataFirebase> vehicles;
    private RegisteredVehiclesAdapter adapter;
    private Constants constants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //init ui
        setupUI();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user != null){
            setupFirebaseListener();
        }

    }

    private void setupFirebaseListener() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        String userID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference reference = database.getReference(""); //in demo: "users/"+userID+"/places" and tell firebase to look at everything under places in specific user with userID

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //This is called when initialised and when data is changed.

                vehicles = new ArrayList<VehicleDataFirebase>();
                Iterable<DataSnapshot> snapshots = snapshot.getChildren();
                while(snapshots.iterator().hasNext()){
                    vehicles.add(snapshots.iterator().next().getValue(VehicleDataFirebase.class));
                }
                if(vehicles.size()>0){
                    if(adapter==null){
                        adapter = new RegisteredVehiclesAdapter(vehicles, RegisteredVehicles.this);
                        rcvList.setAdapter(adapter);
                    }else{
                        adapter.setList(vehicles);
                        adapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("Error", "failed to read value"); //Jeg er ikke sikker på hvad dette er, det er i demo 2.
            }
        });
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

    @Override
    public void onRegisteredVehicleClicked(int RVID) {
        Intent intent = new Intent(this, com.app_project_group_13.carlog.Activities.VehicleDetails.class);
        intent.putExtra(constants.ID, RVID);
    }
}