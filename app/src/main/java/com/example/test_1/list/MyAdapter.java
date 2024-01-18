package com.example.test_1.list;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test_1.R;
import com.example.test_1.Userinfo;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;

    ArrayList<Userinfo> list;


    public MyAdapter(Context context, ArrayList<Userinfo> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.activity_userlist,parent,false);
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Userinfo userinfo = list.get(position);
        holder.FullName.setText(userinfo.getFullname());
        holder.Phone.setText(userinfo.getPhonenumber());
        holder.Email.setText(userinfo.getEmail());
        holder.City.setText(userinfo.getCitylocation());
        holder.DeviceName.setText(userinfo.getDeviceName());
        holder.DeviceModel.setText(userinfo.getDeviceModel());
        holder.Description.setText(userinfo.getDescription());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView FullName, Phone, Email , City , DeviceModel , DeviceName , Description;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            FullName = itemView.findViewById(R.id.tvFullName);
            Phone  = itemView.findViewById(R.id.tvPhone);
            Email = itemView.findViewById(R.id.tvEmail);
            City = itemView.findViewById(R.id.tvCity);
            DeviceName = itemView.findViewById(R.id.tvDeviceN);
            DeviceModel = itemView.findViewById(R.id.tvDeviceM);
            Description = itemView.findViewById(R.id.tvDescript);

        }
    }

}


