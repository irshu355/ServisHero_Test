package com.github.irshulx.servishero.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.irshulx.servishero.R;
import com.github.irshulx.servishero.models.Service;
import com.github.irshulx.servishero.utilities.ServiceRecyclerAdapter;
import com.github.irshulx.servishero.utilities.Utilities;

import java.util.List;

public class CategoriesActivity extends AppCompatActivity {
    private Utilities utilities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        utilities =new Utilities(CategoriesActivity.this);
        initializeServices();

    }

    private void initializeServices() {

        List<Service> services = utilities.deserializeToServices(CategoriesActivity.this.getResources().getString(R.string.services));
        BindRecycler(services);
    }

    private void BindRecycler(List<Service> services) {
        List<String>serviceNames= utilities.getServisNames(services);
        if(services !=null&& services.size()>0){
            RecyclerView rvGrid= (RecyclerView) findViewById(R.id.rvPins);
            rvGrid.setHasFixedSize(true);
            StaggeredGridLayoutManager _staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
            rvGrid.setLayoutManager(_staggeredGridLayoutManager);
            ServiceRecyclerAdapter rcAdapter = new ServiceRecyclerAdapter(getApplicationContext(), serviceNames,utilities);
            rvGrid.setAdapter(rcAdapter);
        }
    }

}
