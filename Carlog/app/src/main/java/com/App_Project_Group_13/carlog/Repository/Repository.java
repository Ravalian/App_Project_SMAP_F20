package com.App_Project_Group_13.carlog.Repository;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.App_Project_Group_13.carlog.Activities.RegisteredVehicles;
import com.App_Project_Group_13.carlog.Adapters.RegisteredVehiclesAdapter;
import com.App_Project_Group_13.carlog.Models.VehicleDataFirebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Repository {

    private LiveData<ArrayList<VehicleDataFirebase>> vehicles;

    public Repository(){

        setupFirebaseListener();

    }




    private void setupFirebaseListener() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        String userID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference reference = database.getReference(""); //in demo: "users/"+userID+"/places" and tell firebase to look at everything under places in specific user with userID

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //This is called when initialised and when data is changed.

                //vehicles = new LiveData<ArrayList<VehicleDataFirebase>>();
                Iterable<DataSnapshot> snapshots = snapshot.getChildren();
                while(snapshots.iterator().hasNext()){
                    vehicles.add(snapshots.iterator().next().getValue(VehicleDataFirebase.class));
                }
                /*if(vehicles.size()>0){
                    if(adapter==null){
                        adapter = new RegisteredVehiclesAdapter(vehicles, RegisteredVehicles.this);
                        rcvList.setAdapter(adapter);
                    }else{
                        adapter.setList(vehicles);
                        adapter.notifyDataSetChanged();
                    }
                }*/
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("Error", "failed to read value"); //Jeg er ikke sikker på hvad dette er, det er i demo 2.
            }
        });
    }

    public LiveData<ArrayList<VehicleDataFirebase>> getVehicles(){
        return vehicles;
    }
}
