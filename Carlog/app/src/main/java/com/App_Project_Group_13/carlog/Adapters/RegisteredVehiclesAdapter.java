package com.App_Project_Group_13.carlog.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.App_Project_Group_13.carlog.R;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class RegisteredVehiclesAdapter extends RecyclerView.Adapter<RegisteredVehiclesAdapter.RegisteredVehiclesViewHolder> {

    public interface IRegisteredVehiclesItemClickedListener {
        void onRegisteredVehicleClicked(int RVID);
    }

    private IRegisteredVehiclesItemClickedListener listener;

    /*
    private List<DBRegisteredVehiclesModel> RVList = new List<DBRegisteredVehiclesModel>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(@Nullable Object o) {
            return false;
        }

        @NonNull
        @Override
        public Iterator<DBRegisteredVehiclesModel> iterator() {
            return null;
        }

        @NonNull
        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @NonNull
        @Override
        public <T> T[] toArray(@NonNull T[] ts) {
            return null;
        }

        @Override
        public boolean add(DBRegisteredVehiclesModel dbRegisteredVehiclesModel) {
            return false;
        }

        @Override
        public boolean remove(@Nullable Object o) {
            return false;
        }

        @Override
        public boolean containsAll(@NonNull Collection<?> collection) {
            return false;
        }

        @Override
        public boolean addAll(@NonNull Collection<? extends DBRegisteredVehiclesModel> collection) {
            return false;
        }

        @Override
        public boolean addAll(int i, @NonNull Collection<? extends DBRegisteredVehiclesModel> collection) {
            return false;
        }

        @Override
        public boolean removeAll(@NonNull Collection<?> collection) {
            return false;
        }

        @Override
        public boolean retainAll(@NonNull Collection<?> collection) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public DBRegisteredVehiclesModel get(int i) {
            return null;
        }

        @Override
        public DBRegisteredVehiclesModel set(int i, DBRegisteredVehiclesModel dbRegisteredVehiclesModel) {
            return null;
        }

        @Override
        public void add(int i, DBRegisteredVehiclesModel dbRegisteredVehiclesModel) {

        }

        @Override
        public DBRegisteredVehiclesModel remove(int i) {
            return null;
        }

        @Override
        public int indexOf(@Nullable Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(@Nullable Object o) {
            return 0;
        }

        @NonNull
        @Override
        public ListIterator<DBRegisteredVehiclesModel> listIterator() {
            return null;
        }

        @NonNull
        @Override
        public ListIterator<DBRegisteredVehiclesModel> listIterator(int i) {
            return null;
        }

        @NonNull
        @Override
        public List<DBRegisteredVehiclesModel> subList(int i, int i1) {
            return null;
        }
    }
    */

    public RegisteredVehiclesAdapter(IRegisteredVehiclesItemClickedListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public RegisteredVehiclesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_registered_vehicles_list_item, parent, false);
        RegisteredVehiclesViewHolder vh = new RegisteredVehiclesViewHolder(v, listener);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RegisteredVehiclesAdapter.RegisteredVehiclesViewHolder holder, int position) {

    }

    public class RegisteredVehiclesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //ViewHolder ui widget references
        ImageView img;
        TextView txtVehicleName;

        IRegisteredVehiclesItemClickedListener listener;

        //constructor
        public RegisteredVehiclesViewHolder(@NonNull View itemView, IRegisteredVehiclesItemClickedListener RegisteredVehiclesItemClickedListener) {
            super(itemView);

            //get references from the layout file
            img = itemView.findViewById(R.id.imgRVVehicle);
            txtVehicleName = itemView.findViewById(R.id.txtRVLIVehicleName);
            listener = RegisteredVehiclesItemClickedListener;

            //set click listener for whole list item
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            //listener.onRegisteredVehicleClicked(RVList.get(getAdapterPosition()).getRVID());
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
