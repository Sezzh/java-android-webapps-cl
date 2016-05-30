package com.sezzh.smood.ui.adapters;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sezzh.smood.R;
import com.sezzh.smood.io.models.ColorExample;

import java.util.List;

/**
 * Created by sezzh on 29/05/16.
 */
public class ColorRecyclerViewAdapter extends
        RecyclerView.Adapter<ColorRecyclerViewAdapter.ColorViewHolder> {
    public List<ColorExample> colorList;

    public ColorRecyclerViewAdapter(List<ColorExample> colorList) {
        this.colorList = colorList;
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
                Color.parseColor(this.colorList.get(position).hexa)
        );
        holder.textView.setText(this.colorList.get(position).name);
    }

    @Override
    public int getItemCount() {
        return this.colorList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    class ColorViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public TextView textView;

        public ColorViewHolder(View itemView) {
            super(itemView);
            this.cardView =
                    (CardView) itemView.findViewById(R.id.card_color);
            this.textView =
                    (TextView) itemView.findViewById(R.id.text_view_color);

        }
    }
}
