package com.example.icar.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.icar.R;
import com.example.icar.model.ExtraService;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ExtraServiceRecyclerViewAdapter extends RecyclerView.Adapter<ExtraServiceRecyclerViewAdapter.ViewHolder> {

    private ArrayList<ExtraService> extraServices = new ArrayList<>();
    public ExtraServiceRecyclerViewAdapter() {
    }

    public void setExtraServices(ArrayList<ExtraService> extraServices) {
        this.extraServices = extraServices;
        notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ExtraServiceRecyclerViewAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return extraServices.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtExtraName, txtPrice;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            txtExtraName = itemView.findViewById(R.id.textView_extraName);
            txtPrice = itemView.findViewById(R.id.textView_price);
        }
    }
}
