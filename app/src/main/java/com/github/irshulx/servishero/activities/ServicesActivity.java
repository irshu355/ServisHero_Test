package com.github.irshulx.servishero.activities;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.github.irshulx.servishero.R;
import com.github.irshulx.servishero.libs.RecyclerWithEmptyView;
import com.github.irshulx.servishero.models.Service;
import com.github.irshulx.servishero.utilities.ServiceRecyclerAdapter;
import com.github.irshulx.servishero.utilities.Utilities;

import java.util.List;


public class ServicesActivity extends SuperActivity {

    private SwipeRefreshLayout swipeContainer;
    private Utilities utilities;
    private SearchView searchView;

    public ServicesActivity(){
        super(R.layout.activity_services);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        utilities =new Utilities(ServicesActivity.this);
        initializeComponents();
        initializeServices();
    }

    private void initializeServices() {

        List<Service> services = utilities.deserializeToServices(ServicesActivity.this.getResources().getString(R.string.services));
        BindRecycler(services);
    }

    private void BindRecycler(List<Service> services) {
        if(services !=null&& services.size()>0){
            RecyclerView rvGrid= (RecyclerView) findViewById(R.id.rvPins);
            rvGrid.setHasFixedSize(true);
            StaggeredGridLayoutManager _staggeredGridLayoutManager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
            rvGrid.setLayoutManager(_staggeredGridLayoutManager);
            ServiceRecyclerAdapter rcAdapter = new ServiceRecyclerAdapter(getApplicationContext(), services.get(0).getCategories(),utilities);
            rvGrid.setAdapter(rcAdapter);
            if(swipeContainer.isRefreshing())
                swipeContainer.setRefreshing(false);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_serices, menu);


        MenuItem myActionMenuItem = menu.findItem( R.id.action_search);
        searchView = (SearchView) myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(ServicesActivity.this,query,Toast.LENGTH_LONG).show();

                if( ! searchView.isIconified()) {
                    searchView.setIconified(true);
                }
             //   myActionMenuItem.collapseActionView();
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                // UserFeedback.show( "SearchOnQueryTextChanged: " + s);
                return false;
            }
        });
        return true;
    }



    private void initializeComponents() {
        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initializeServices();
            }
        });
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
    }
}
