package com.github.irshulx.servishero.libs;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.github.irshulx.servishero.R;

/**
 * Created by mkallingal on 7/20/2016.
 */
public class RecyclerWithEmptyView extends RecyclerView {
    private View emptyView;
    Animation animFadeOut;
    Animation animFadeIn;

    private AdapterDataObserver emptyObserver = new AdapterDataObserver() {


        @Override
        public void onChanged() {
            Adapter<?> adapter =  getAdapter();
            if(adapter != null && emptyView != null) {
                if(adapter.getItemCount() == 0) {
                    emptyView.setAnimation(animFadeIn);
                    emptyView.setVisibility(View.VISIBLE);
                    RecyclerWithEmptyView.this.setAnimation(animFadeOut);
                    RecyclerWithEmptyView.this.setVisibility(View.GONE);
                }
                else {
                    emptyView.setAnimation(animFadeOut);
                    emptyView.setVisibility(View.GONE);
                    RecyclerWithEmptyView.this.setAnimation(animFadeIn);
                    RecyclerWithEmptyView.this.setVisibility(View.VISIBLE);
                }
            }

        }
    };

    public RecyclerWithEmptyView(Context context) {
        super(context);
       animFadeOut= AnimationUtils.loadAnimation(context, R.anim.fade_in);
       animFadeIn = AnimationUtils.loadAnimation(context, R.anim.fade_out);
    }

    public RecyclerWithEmptyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RecyclerWithEmptyView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void setAdapter(Adapter adapter) {
        super.setAdapter(adapter);

        if(adapter != null) {
            adapter.registerAdapterDataObserver(emptyObserver);
        }

        emptyObserver.onChanged();
    }

    public void setEmptyView(View emptyView) {
        this.emptyView = emptyView;
    }
}