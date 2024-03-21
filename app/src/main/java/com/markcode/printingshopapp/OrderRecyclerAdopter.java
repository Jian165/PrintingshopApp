package com.markcode.printingshopapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class OrderRecyclerAdopter extends RecyclerView.Adapter<OrderRecyclerAdopter.ViewHolder>{
    List<OrderModelRecycler> ItemList = new ArrayList<>();

    Context context;
    public OrderRecyclerAdopter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_product_order,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.OrderType.setText(ItemList.get(position).getOrderType());
        holder.TotalPrice.setText(ItemList.get(position).getOrderPricePerPiece().toString());
        holder.OrderId.setText(ItemList.get(position).getOrderID().toString());
        holder.OrderIcon.setImageResource(ItemList.get(position).getImgOrderImage());

    }



    @Override
    public int getItemCount() {
        return ItemList.size();
    }

    public void setItem (ArrayList<OrderModelRecycler> ItemList)
    {
        this.ItemList = ItemList;
        notifyDataSetChanged();

    }

    public void setfilteredItem (List<OrderModelRecycler> ItemList)
    {
        this.ItemList = ItemList;
        notifyDataSetChanged();

    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView OrderType;
        TextView TotalPrice;
        TextView OrderId;

        Button AddOrder;
        Button CancelOrder;

        ImageView OrderIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            OrderType = itemView.findViewById(R.id.txt_OrderType);
            TotalPrice = itemView.findViewById(R.id.txt_TotalPrice);
            OrderId = itemView.findViewById(R.id.txt_OrderID);
            AddOrder = itemView.findViewById(R.id.btn_AddOrder);
            CancelOrder = itemView.findViewById(R.id.btn_CancelOrder);
            OrderIcon = itemView.findViewById(R.id.OrderIcon);



        }
    }
}
