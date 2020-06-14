package com.example.mtgDeckHelper.fragments;

import android.content.Intent;
import android.net.Uri;
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

import com.example.mtgDeckHelper.apiRelated.Card;
import com.example.mtgDeckHelper.recycleResult.CardAdapter;
import com.example.mtgDeckHelper.recycleResult.CardRepository;
import com.example.mtgDeckHelper.R;
import com.example.mtgDeckHelper.database.CardDatabaseViewModel;
import com.example.mtgDeckHelper.database.CardList;
import com.example.mtgDeckHelper.recycleWishlist.WishRepository;
import com.example.mtgDeckHelper.recycleWishlist.WishlistAdapter;

import java.util.ArrayList;
import java.util.List;

public class Fragment_wishlist extends Fragment implements WishlistAdapter.OnListItemClickListener  {

    WishRepository wishRepository = WishRepository.getInstance();
    private CardDatabaseViewModel cardDatabaseViewModel;
    List<CardList> result;

    RecyclerView mResultList;
    WishlistAdapter wishlistAdapter;

    ArrayList<String> names = new ArrayList<>();

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

        cardDatabaseViewModel = new CardDatabaseViewModel(getActivity().getApplication());

        result = new ArrayList<>();

        mResultList = root.findViewById(R.id.rvResult);
        mResultList.hasFixedSize();
        mResultList.setLayoutManager(new LinearLayoutManager(getContext()));
        wishlistAdapter = new WishlistAdapter(WishRepository.getInstance().getNames(), this);
        mResultList.setAdapter(wishlistAdapter);

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
                setTextForTextfield();
            }
        });

        Button deleteList = (Button) root.findViewById(R.id.fWishdeleteList);
        deleteList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardDatabaseViewModel.deleteList();
            }
        });

        Button searchOnline = (Button) root.findViewById(R.id.fWishWeb);
        searchOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (CardList card: result
                     ) {
                    String action = Intent.ACTION_VIEW;
                    String place = getKelzorUrl(card);
                    Uri uri = Uri.parse(place);

                    Intent intent = new Intent(action, uri);
                    startActivity(intent);
                }


            }
        });

        return root;
    }

    public String getKelzorUrl(CardList card) {
        return "https://www.kelz0r.dk/magic/advanced_search_result.php?keywords=" + card.getCardname() + "&search_in_description=0";
    }

    public void setTextForTextfield() {

        if (result == null){

            return;
        }
        if(!result.isEmpty()){
            names.clear();
            ArrayList<String> check = new ArrayList<>();
            for (CardList card: result
                 ) {
               if(!(check.contains(card.getCardname()))){
                   WishRepository.getInstance().insert(card.getCardname());
                   check.add(card.getCardname());
               }

            }
            names = wishRepository.getNames();
            wishlistAdapter = new WishlistAdapter(WishRepository.getInstance().getNames(), this);
            mResultList.setAdapter(wishlistAdapter);
        } else{

        }

    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        CardDatabaseViewModel database = new CardDatabaseViewModel(getActivity().getApplication());
        int nameIndex = clickedItemIndex;
        System.out.println("CLICKED " + names.get(nameIndex) + database.getCardList().get(nameIndex).getId() +"\n");

        wishRepository.deleteName(database.getCardList().get(nameIndex).getCardname());
        database.deleteCard(database.getCardList().get(nameIndex));
        names = wishRepository.getNames();

    }
}