package com.github.irshulx.servishero.utilities;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.github.irshulx.servishero.models.Service;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
}