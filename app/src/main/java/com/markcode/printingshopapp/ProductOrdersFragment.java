package com.markcode.printingshopapp;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class ProductOrdersFragment extends Fragment {

    SearchView searchProductOrder;
    RecyclerView recyclerProductOrder;
    OrderRecyclerAdopter orderRecyclerAdopter;
    ArrayList<OrderModelRecycler> orderModelRecyclers;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView =  inflater.inflate(R.layout.fragment_productsorders, container, false);

        recyclerProductOrder = rootView.findViewById(R.id.RecyclerOrder);
        searchProductOrder = rootView.findViewById(R.id.searchOrder);

        orderModelRecyclers = new ArrayList<>();

        orderModelRecyclers.add(new OrderModelRecycler(1,"Print",16.0,2,R.drawable.ic_print));
        orderModelRecyclers.add(new OrderModelRecycler(2,"Print",19.0,3,R.drawable.ic_print));
        orderModelRecyclers.add(new OrderModelRecycler(3,"Print",3.0,9,R.drawable.ic_scan));
        orderModelRecyclers.add(new OrderModelRecycler(4,"Print",4.0,4,R.drawable.ic_print));
        orderModelRecyclers.add(new OrderModelRecycler(5,"Print",89.0,4,R.drawable.ic_laminate));
        orderModelRecyclers.add(new OrderModelRecycler(6,"Print",56.0,6,R.drawable.ic_print));

        orderRecyclerAdopter = new OrderRecyclerAdopter(getContext());
        orderRecyclerAdopter.setItem(orderModelRecyclers);
        recyclerProductOrder.setAdapter(orderRecyclerAdopter);
        recyclerProductOrder.setLayoutManager(new LinearLayoutManager(getContext()));

        searchProductOrder.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                orderRecyclerAdopter.setfilteredItem(filterList(newText));
                return false;
            }
        });



        return  rootView;
    }


    public List<OrderModelRecycler> filterList (String text)
    {
        List<OrderModelRecycler> returnFilteredList = new ArrayList<>();

        for(OrderModelRecycler ItemsInOrderModelList: orderModelRecyclers)
        {
            if(ItemsInOrderModelList.getOrderID().toString().contains(text))
            {
                returnFilteredList.add(ItemsInOrderModelList);
            }
            else
            {

            }

        }

        return returnFilteredList;


    }

}