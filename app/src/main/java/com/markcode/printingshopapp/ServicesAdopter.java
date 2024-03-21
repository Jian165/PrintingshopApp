package com.markcode.printingshopapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ServicesAdopter extends RecyclerView.Adapter<ServicesAdopter.Viewholder> {
    List<ServicesModel> ServicesModel = new ArrayList<>();
    Context context;


    public ServicesAdopter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_product_selection,parent,false);
        Viewholder holder = new Viewholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

        holder.ServiceName.setText( ServicesModel.get(position).getServiceTitle());
        holder.ServiceIcon.setImageResource(ServicesModel.get(position).getImageID());
        holder.CardViewparent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ServicesModel.get(position).getServiceTitle().equalsIgnoreCase("Print"))
                {
                    Intent intent = new Intent(v.getContext(), CreateOrderPrint.class);
                    v.getContext().startActivity(intent);
                }

            }
        });


    }

    @Override
    public int getItemCount() {
        return ServicesModel.size();
    }

    public void setItemFilteredList (List<ServicesModel>  filtedServiceModel)
    {
        this.ServicesModel = filtedServiceModel;
        notifyDataSetChanged();
    }



    public void setItemList (ArrayList<ServicesModel> ServicesModels)
    {
        this.ServicesModel = ServicesModels;
        notifyDataSetChanged();
    }



    public class Viewholder extends RecyclerView.ViewHolder {
        TextView ServiceName;
        ImageView ServiceIcon;
        CardView CardViewparent;
        public Viewholder(@NonNull View itemView) {
            super(itemView);

            ServiceName = itemView.findViewById(R.id.serviceName);
            ServiceIcon = itemView.findViewById(R.id.serviceIcon);
            CardViewparent = itemView.findViewById(R.id.servicesCardView);

        }


    }
}

