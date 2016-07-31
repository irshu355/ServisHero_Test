package com.github.irshulx.servishero.utilities;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import com.github.irshulx.servishero.R;

import java.util.List;

/**
 * Created by mkallingal on 7/21/2016.
 */
public class ServiceRecyclerAdapter extends RecyclerView.Adapter<ServiceRecyclerAdapter.PinViewHolder> implements View.OnClickListener, View.OnLongClickListener {
    private List<String> serviceNames;
    private Context _Context;
    private Utilities utilities;
    private int lastPosition = -1;

    public ServiceRecyclerAdapter(Context _context, List<String> serviceNames, Utilities utilities) {
        this._Context= _context;
        this.serviceNames = serviceNames;
        this.utilities=new Utilities(_context);
    }

    @Override
    public PinViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /*this event is fired every time android wants to create a new column to our RecyclerView. We have to tell Android what layout we
         * need to inflate for that column
        */
        View _Item = LayoutInflater.from(parent.getContext()).inflate(R.layout.servis_item_layout, parent, false);
        return new PinViewHolder(_Item);
    }
    @Override
    public void onBindViewHolder(final PinViewHolder holder, int position) {
        String serviceName = this.serviceNames.get(position);
        holder.serviceName.setText(serviceName);
        holder.itemView.setTag(serviceName);
    }
    @Override
    public int getItemCount() {
        return this.serviceNames.size();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onLongClick(View v) {
        Toast.makeText(_Context, "Long press triggered", Toast.LENGTH_LONG).show();
        return true;
    }


    public class PinViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {
        public TextView serviceName;
        public PinViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
            serviceName = (TextView)itemView.findViewById(R.id.lblServisName);
        }
        @Override
        public void onClick(View view) {
            // Toast.makeText(view.getContext(), "Clicked Position = " + getPosition(), Toast.LENGTH_SHORT).show();
            //   Intent intent = new Intent(_Context, DetialsActivity.class);
            // intent.putExtra("AlbumId", ((TextView)view.findViewById(R.id.lblAlbumId)).getText().toString());
            // view.getContext().startActivity(intent);
        }

        @Override
        public boolean onLongClick(View v) {
            Toast.makeText(v.getContext(), "Long clicked Position = " + getPosition(), Toast.LENGTH_SHORT).show();
            return  false;
        }
    }
}
