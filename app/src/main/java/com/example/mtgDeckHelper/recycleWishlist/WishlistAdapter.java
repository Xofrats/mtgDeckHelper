package com.example.mtgDeckHelper.recycleWishlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mtgDeckHelper.R;
import com.example.mtgDeckHelper.apiRelated.Card;

import java.util.ArrayList;

public class WishlistAdapter extends RecyclerView.Adapter<WishlistAdapter.ViewHolder> {
    private ArrayList<String> mResultList;
    final private OnListItemClickListener mOnListItemClickListener;

    public WishlistAdapter(ArrayList<String> mResultList, OnListItemClickListener listener) {
        this.mResultList = mResultList;
        mOnListItemClickListener = listener;
    }

    public void setmResultList(ArrayList<String> mResultList) {
        this.mResultList = mResultList;
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recyclelist_wishlist, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.name.setText(mResultList.get(position));


    }


    public int getItemCount() {
        return mResultList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.rv_wishlist);

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

