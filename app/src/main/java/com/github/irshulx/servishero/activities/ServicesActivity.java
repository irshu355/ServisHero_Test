package com.github.irshulx.servishero.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.LinearGradient;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import com.github.irshulx.servishero.R;
import com.github.irshulx.servishero.libs.RecyclerWithEmptyView;
import com.github.irshulx.servishero.models.Category;
import com.github.irshulx.servishero.models.Service;
import com.github.irshulx.servishero.utilities.ServiceRecyclerAdapter;
import com.github.irshulx.servishero.utilities.Utilities;

import java.util.ArrayList;
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
        initializeServices(utilities.getServices(null));
    }

    private void rebindServices(String terms){
        initializeServices(utilities.getServices(terms));
    }

    private void initializeServices(List<Service>services) {
        InitializeFeaturedViews(services);
        InitializeServisNames(services);
        if(swipeContainer.isRefreshing())
            swipeContainer.setRefreshing(false);
      //  InitializeRecycler(getServices(null));
    }

    private void InitializeServisNames(List<Service> services) {
        final TableLayout layout = (TableLayout)findViewById(R.id.tblServices);
        layout.removeAllViews();
        LayoutInflater inflater = LayoutInflater.from(ServicesActivity.this);
        List<String>serviceNames=utilities.getServisNames(services);
        for(int i=0;i<serviceNames.size();i++) {
            final View child_layout = inflater.inflate(R.layout.servis_item_layout, layout, false);
            ((TextView)child_layout.findViewById(R.id.lblServisName)).setText(serviceNames.get(i));
            child_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    proceedToServices();
                }
            });
            layout.addView(child_layout);
        }
    }

    private void InitializeFeaturedViews(List<Service>services) {
        final TableLayout layout = (TableLayout)findViewById(R.id.tblFeatured);
        layout.removeAllViews();
        LayoutInflater inflater = LayoutInflater.from(ServicesActivity.this);
        List<Category> categories= utilities.getCategories(services);
        for(int i=0;i<categories.size();i++){
            if((categories.size()-i)<=1){
                TableRow twoColumns=(TableRow) inflater.inflate(R.layout.featured_two_columns, layout, false);
               LinearLayout view= (LinearLayout) twoColumns.getChildAt(categories.size()-i);
                ((TextView)view.findViewById(R.id.lblCategory)).setText(categories.get(i).getCategoryName());
                if(i%2==0){
                    ((ImageView) view.findViewById(R.id.imgServis)).setImageDrawable(getResources().getDrawable(R.drawable.aircon));
                }
                else if(i%2==1){
                    ((ImageView) view.findViewById(R.id.imgServis)).setImageDrawable(getResources().getDrawable(R.drawable.event_management));
                }
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        proceedToServices();
                    }
                });
                layout.addView(twoColumns);
            }else{
                final View child_layout = inflater.inflate(R.layout.featured_services, layout, false);
                ((TextView)child_layout.findViewById(R.id.lblCategory)).setText(categories.get(i).getCategoryName());
                if(i%2==0){
                    ((ImageView) child_layout.findViewById(R.id.imgServis)).setImageDrawable(getResources().getDrawable(R.drawable.aircon));
                }
                else if(i%2==1){
                    ((ImageView) child_layout.findViewById(R.id.imgServis)).setImageDrawable(getResources().getDrawable(R.drawable.event_management));
                }
                child_layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        proceedToServices();
                    }
                });
                layout.addView(child_layout);
            }
            //  ((TextView)child_layout.findViewById(R.id.lblAverageTicketSize)).setText(objEngine.FormatCurrencyToLocale(_CardsList.get(i).AverageTicketSize));


        }
       // parent.addView(layout);
    }


    private void proceedToServices(){
        Intent intent= new Intent(ServicesActivity.this,CategoriesActivity.class);
        startActivity(intent);
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
                rebindServices(query);
                if( ! searchView.isIconified()) {
                    searchView.setIconified(false);
                }
             //   myActionMenuItem.collapseActionView();
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                // UserFeedback.show( "SearchOnQueryTextChanged: " + s);
                rebindServices(s);
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
                initializeServices(utilities.getServices(null));
            }
        });
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
    }
}
