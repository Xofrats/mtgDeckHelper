package com.example.mtgDeckHelper.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.mtgDeckHelper.R;
import com.example.mtgDeckHelper.database.CardDatabaseViewModel;
import com.example.mtgDeckHelper.database.CardList;

import java.util.ArrayList;
import java.util.List;

public class Fragment_wishlist extends Fragment {


    private CardDatabaseViewModel cardDatabaseViewModel;
    List<CardList> result;

    TextView wishlist;

    public static Fragment_wishlist newInstance() {
        Fragment_wishlist fragment = new Fragment_wishlist();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_wishlist, container, false);

        wishlist = (TextView) root.findViewById(R.id.tv_wishlist);
        cardDatabaseViewModel = new CardDatabaseViewModel(getActivity().getApplication());

        result = new ArrayList<>();

        Button getList = (Button) root.findViewById(R.id.fWishList);
        getList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = cardDatabaseViewModel.getCardList();
            }
        });

        Button seeList = (Button) root.findViewById(R.id.fWishlistSee);
        seeList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result == null){
                    wishlist.setText("Is null \n");
                    return;
                }
                if(!result.isEmpty()){
                    wishlist.setText("");
                    for (CardList card: result
                         ) {
                        wishlist.setText(wishlist.getText() + card.getCardname() + "\n");
                    }
                } else
                    wishlist.setText("Is empty \n");
            }
        });

        return root;
    }

}