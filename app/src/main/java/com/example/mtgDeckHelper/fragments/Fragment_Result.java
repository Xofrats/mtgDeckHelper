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

import com.example.mtgDeckHelper.recycleResult.CardAdapter;
import com.example.mtgDeckHelper.recycleResult.CardRepository;
import com.example.mtgDeckHelper.R;
import com.example.mtgDeckHelper.apiRelated.Card;
import com.example.mtgDeckHelper.database.CardDatabaseViewModel;
import com.example.mtgDeckHelper.database.CardList;


import java.util.ArrayList;

public class Fragment_Result extends Fragment implements CardAdapter.OnListItemClickListener {

    CardRepository cardRepository = CardRepository.getInstance();
   ArrayList<Card> cards = new ArrayList<>();
   // CardDatabaseViewModel database;

    CardList savedCard;
    TextView selectedCard;

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
        cardAdapter = new CardAdapter(CardRepository.getInstance().getCards(), this);
        mResultList.setAdapter(cardAdapter);

        selectedCard = root.findViewById(R.id.tv_selected_card);

        Button btn = (Button) root.findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateResult();
            }
        });

        Button saveButton = (Button) root.findViewById(R.id.fSaveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveCard(new CardList(savedCard.getList(), savedCard.getCardname()));
            }
        });


updateResult();

        return root;
    }

    public void saveCard(CardList card) {
        CardDatabaseViewModel database = new CardDatabaseViewModel(getActivity().getApplication());
        database.insert(card);
        selectedCard.setText("Saved!");
        savedCard = null;
    }

    public void updateResult(){
        cards = cardRepository.getCards();
        cardAdapter = new CardAdapter(CardRepository.getInstance().getCards(), this);
        mResultList.setAdapter(cardAdapter);

    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        int cardindex = clickedItemIndex;
        selectedCard.setText(cards.get(cardindex).getName());
        CardList newCard = new CardList("wistlist", cards.get(cardindex).getName());
        savedCard = newCard;
    }



}