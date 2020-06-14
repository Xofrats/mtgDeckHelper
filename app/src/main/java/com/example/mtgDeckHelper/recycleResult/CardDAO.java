package com.example.mtgDeckHelper.recycleResult;


import com.example.mtgDeckHelper.apiRelated.Card;

import java.util.ArrayList;


public class CardDAO {

        private ArrayList<Card> cards;
        private static CardDAO instance;

        private CardDAO() {
            cards = new ArrayList<>();
        }

        public static CardDAO getInstance(){
            if(instance == null) {
                instance = new CardDAO();
            }
            return instance;
        }

        public ArrayList<Card> getCards() {
            return cards;
        }

        public void addCard(Card card) {
            cards.add(card);

        }

        public void deleteWishlist() {

            cards.clear();
        }


}
