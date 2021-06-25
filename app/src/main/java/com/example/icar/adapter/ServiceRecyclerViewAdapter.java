package com.example.icar.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.icar.R;
import com.example.icar.model.Service;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ServiceRecyclerViewAdapter extends RecyclerView.Adapter<ServiceRecyclerViewAdapter.ViewHolder>{

    private ArrayList<Service> services = new ArrayList<>();

    public ServiceRecyclerViewAdapter() {
    }

    public void setServices(ArrayList<Service> services) {
        this.services = services;
        notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ServiceRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.txtServiceKey.setText(services.get(position).getServiceKey());
        holder.txtCarName.setText(services.get(position).getCarName());
        holder.txtPricePerKm.setText(services.get(position).getPricePerKm());
    }

    @Override
    public int getItemCount() {
        return services.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtServiceKey, txtCarName, txtPricePerKm;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            txtServiceKey = itemView.findViewById(R.id.textView_serviceKey);
            txtCarName = itemView.findViewById(R.id.textView_carName);
            txtPricePerKm = itemView.findViewById(R.id.textView_pricePerKm);
        }
    }

}
