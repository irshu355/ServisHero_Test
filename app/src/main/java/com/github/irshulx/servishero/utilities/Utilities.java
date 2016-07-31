package com.github.irshulx.servishero.utilities;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.github.irshulx.servishero.R;
import com.github.irshulx.servishero.models.Category;
import com.github.irshulx.servishero.models.Service;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * Created by mkallingal on 7/21/2016.
 */
public class Utilities {
    private Context context;
    private Gson gson;
    public Utilities(Context context) {
        this.context= context;
        this.gson=new Gson();
    }
    public List<Service> deserializeToServices(String serialized){
        Type type = new TypeToken<List<Service>>() {
        }.getType();
        return  gson.fromJson(serialized, type);
    }


    public boolean containsCategory(List<Category> categories, String term){
        boolean contains=false;

        for (Category category:categories){
            if(!TextUtils.isEmpty(category.getCategoryName())) {
                if (category.getCategoryName().toLowerCase().equals(term.toLowerCase())) {
                    contains = true;
                    break;
                }
            }
        }
        return contains;
    }

    public List<String>getServisNames(List<Service>services){
        List<String>serviceNames=new ArrayList<>();
        for (Service service:services){
            serviceNames.add(service.getServiceName());
        }
        return serviceNames;
    }

    public List<Category> getCategories(List<Service> services){
        List<Category> categories=new ArrayList<>();
//        for (Service service:services){
//            for (Category category:service.getCategories()){
//                if(!containsCategory(categories,category.getCategoryName())){
//                    categories.add(category);
//                }
//            }
//        }

        categories.add(new Category("Home",1));        categories.add(new Category("Moving",2));
        categories.add(new Category("Cleaning",3));        categories.add(new Category("Events",4));
        categories.add(new Category("Learning",5));        categories.add(new Category("Air COnditioning",6));
        categories.add(new Category("Fitness",7));        categories.add(new Category("Pest Control",8));
        categories.add(new Category("Commercial",9));

        return categories;
    }

   public List<Service> getServices(String filterTerm){
        List<Service>filteredServices=new ArrayList<>();
        List<Service> services=deserializeToServices(context.getResources().getString(R.string.services));
        if(!TextUtils.isEmpty(filterTerm)){
            for (Service service:services){
                if(service.getSearchTerms().contains(filterTerm)){
                    filteredServices.add(service);
                }
            }
            return filteredServices;
        }
        return deserializeToServices(context.getResources().getString(R.string.services));
    }
}