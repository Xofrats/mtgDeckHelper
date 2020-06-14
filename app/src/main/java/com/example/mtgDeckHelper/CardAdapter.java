package com.example.mtgDeckHelper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mtgDeckHelper.apiRelated.Card;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    private ArrayList<Card> mResultList;
    final private OnListItemClickListener mOnListItemClickListener;

    public CardAdapter(ArrayList<Card> mCards, OnListItemClickListener listener) {
        this.mResultList = mCards;
        mOnListItemClickListener = listener;
    }

    public void setmResultList(ArrayList<Card> mResultList) {
        this.mResultList = mResultList;
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recyclelist_result, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.name.setText(mResultList.get(position).getName());
        viewHolder.manacost.setText(mResultList.get(position).getMana_cost());
        viewHolder.cmc.setText(mResultList.get(position).getCmc());
        viewHolder.type.setText(mResultList.get(position).getType_line());
        viewHolder.oracleText.setText(mResultList.get(position).getOracle_text());

    }


    public int getItemCount() {
        return mResultList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name;
        TextView manacost;
        TextView cmc;
        TextView type;
        TextView oracleText;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.rv_name);
            manacost = itemView.findViewById(R.id.rv_manacost);
            cmc = itemView.findViewById(R.id.rv_cmc);
            type = itemView.findViewById(R.id.rv_type);
            oracleText = itemView.findViewById(R.id.rv_oracleText);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mOnListItemClickListener.onListItemClick(getAdapterPosition());
        }

    }

    public interface OnListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }
}

