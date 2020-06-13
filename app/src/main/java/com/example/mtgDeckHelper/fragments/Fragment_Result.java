package com.example.mtgDeckHelper.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mtgDeckHelper.CardAdapter;
import com.example.mtgDeckHelper.CardRepository;
import com.example.mtgDeckHelper.R;
import com.example.mtgDeckHelper.apiRelated.Card;


import java.util.ArrayList;
import java.util.List;

public class Fragment_Result extends Fragment {

    CardRepository cardRepository = CardRepository.getInstance();
   ArrayList<Card> cards = new ArrayList<>();

    RecyclerView mResultList;
    CardAdapter cardAdapter;

    public static Fragment_Result newInstance() {
        Fragment_Result fragment = new Fragment_Result();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_search_result, container, false);
        mResultList = root.findViewById(R.id.rvResult);
        mResultList.hasFixedSize();
        mResultList.setLayoutManager(new LinearLayoutManager(getContext()));
        cardAdapter = new CardAdapter(CardRepository.getInstance().getCards());
        mResultList.setAdapter(cardAdapter);

        Button btn = (Button) root.findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateResult();
            }
        });

updateResult();

        return root;
    }

    public void updateResult(){
        cards = cardRepository.getCards();
        cardAdapter = new CardAdapter(CardRepository.getInstance().getCards());
        mResultList.setAdapter(cardAdapter);

    }


}