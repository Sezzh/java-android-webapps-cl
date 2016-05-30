package com.sezzh.smood.ui.adapters;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sezzh.smood.R;
import com.sezzh.smood.io.models.ColorModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sezzh on 29/05/16.
 */
public class ColorRecyclerViewAdapter extends
        RecyclerView.Adapter<ColorRecyclerViewAdapter.ColorViewHolder> {
    public List<ColorModel> colorList;

    public ColorRecyclerViewAdapter() {
        this.colorList = new ArrayList<>();
    }

    @Override
    public ColorViewHolder onCreateViewHolder(ViewGroup parent,
                                              int viewType) {
        View viewHolder = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_color, parent, false);
        ColorViewHolder colorViewHolder = new ColorViewHolder(viewHolder);

        return colorViewHolder;
    }

    @Override
    public void onBindViewHolder(ColorViewHolder holder, int position) {
        holder.cardView.setCardBackgroundColor(
                Color.parseColor("#" + this.colorList.get(position).getHexa())
        );
        holder.textView.setText(this.colorList.get(position).getName());
        holder.url = colorList.get(position).getUrl();
    }

    @Override
    public int getItemCount() {
        return this.colorList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void setData(List<ColorModel> data) {
        this.colorList.clear();
        this.colorList.addAll(data);
        this.notifyDataSetChanged();
    }

    class ColorViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public TextView textView;
        public String url;

        public ColorViewHolder(View itemView) {
            super(itemView);
            this.cardView =
                    (CardView) itemView.findViewById(R.id.card_color);
            this.textView =
                    (TextView) itemView.findViewById(R.id.text_view_color);

        }
    }
}
