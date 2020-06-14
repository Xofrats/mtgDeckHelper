package com.example.mtgDeckHelper.recycleResult;

import com.example.mtgDeckHelper.apiRelated.Card;

import java.util.ArrayList;

public class CardRepository {

    private CardDAO cardDAO;
    private static CardRepository instance;

    private CardRepository(){
        cardDAO = CardDAO.getInstance();
    }

    public static CardRepository getInstance(){
        if(instance == null)
            instance = new CardRepository();

        return instance;
    }

    public ArrayList<Card> getCards(){
        return cardDAO.getCards();
    }

    public void insert(Card card) {
        cardDAO.addCard(card);
    }

    public void deleteCards(){
        cardDAO.deleteWishlist();
    }


}
