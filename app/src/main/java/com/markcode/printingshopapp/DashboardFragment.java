package com.markcode.printingshopapp;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class DashboardFragment extends Fragment {

    RecyclerView recyclerView;
    SearchView searchView;
    ServicesAdopter ServicesAdopter ;
    ArrayList <ServicesModel> servicesList;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView =  inflater.inflate(R.layout.fragment_dashboard, container, false);


        searchView =  rootView.findViewById(R.id.searchView);
        searchView.clearFocus();

        recyclerView =  rootView.findViewById(R.id.dashboard_recyclerView);

        servicesList = new ArrayList<>();

        servicesList.add( new ServicesModel(R.drawable.ic_print,"Print"));
        servicesList.add( new ServicesModel(R.drawable.ic_photocopy,"Photo copy"));
        servicesList.add( new ServicesModel(R.drawable.ic_laminate,"Laminate"));
        servicesList.add( new ServicesModel(R.drawable.ic_photo,"Photo print"));
        servicesList.add( new ServicesModel(R.drawable.ic_formal_photo,"Formal Photo"));
        servicesList.add( new ServicesModel(R.drawable.ic_scan,"Scan"));

        ServicesAdopter = new ServicesAdopter(getContext());
        ServicesAdopter.setItemList(servicesList);


        recyclerView.setAdapter( ServicesAdopter  );

        recyclerView.setLayoutManager( new GridLayoutManager(getContext(),2));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterServiceList(newText);
                return false;
            }
        });



        return  rootView ;
    }

    public void filterServiceList (String text)
    {
        List<ServicesModel> filtered = new ArrayList<>();
        for(ServicesModel services : servicesList  )
        {
            if(services.getServiceTitle().toLowerCase().contains(text.toLowerCase()))
            {
                filtered.add(services);
            }

            if (filtered.isEmpty())
            {
            }
            else
            {
                ServicesAdopter.setItemFilteredList(filtered);
            }

        }
    }


}