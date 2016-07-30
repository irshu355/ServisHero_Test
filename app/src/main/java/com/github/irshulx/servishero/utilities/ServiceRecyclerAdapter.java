package com.github.irshulx.servishero.utilities;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.github.irshulx.servishero.R;
import com.github.irshulx.servishero.models.Category;

import java.util.List;

/**
 * Created by mkallingal on 7/21/2016.
 */
public class ServiceRecyclerAdapter extends RecyclerView.Adapter<ServiceRecyclerAdapter.PinViewHolder> implements View.OnClickListener, View.OnLongClickListener {
    private List<Category> categories;
    private Context _Context;
    private Utilities utilities;
    private int lastPosition = -1;
    public ServiceRecyclerAdapter(Context _context, List<Category> categories,Utilities utilities){
        this._Context= _context;
        this.categories = categories;
        this.utilities=new Utilities(_context);
        /*
        *I'm gonna create an array of Album arts i have in my drawables directory.
        * Please remove this code, after you bring in the AlbumArt in our model as part of the exercise
        *
        */


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
        Category category1 = this.categories.get(position);
        int totalPics=0;
        holder.categoryName.setText(category1.getCategoryName());
        setAnimation(holder.itemView.getRootView(), position);
        holder.itemView.setTag(category1);
        if(position%2==0){
            holder.imgServis.setImageDrawable(holder.itemView.getResources().getDrawable(R.drawable.aircon));
        }
        else if(position%2==1){
            holder.imgServis.setImageDrawable(holder.itemView.getResources().getDrawable(R.drawable.event_management));
        }
    }
    @Override
    public int getItemCount() {
        return this.categories.size();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onLongClick(View v) {
        Toast.makeText(_Context, "Long press triggered", Toast.LENGTH_LONG).show();
        return true;
    }

    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(_Context, R.anim.slide_up);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    public class PinViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {
        public TextView categoryName;
        public RelativeLayout relativeLayout;
        public ImageView imgServis;
        public PinViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
            categoryName = (TextView)itemView.findViewById(R.id.lblCategory);
            relativeLayout= (RelativeLayout)itemView.findViewById(R.id.relativeBackground);
            imgServis= (ImageView) itemView.findViewById(R.id.imgServis);
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
