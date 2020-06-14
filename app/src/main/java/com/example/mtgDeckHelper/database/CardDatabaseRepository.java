package com.example.mtgDeckHelper.database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.mtgDeckHelper.apiRelated.Card;

import java.util.List;

public class CardDatabaseRepository {

    private CardDatabaseDAO cardDao;
    private static CardDatabaseRepository instance;
    private List<CardList> cardList;

    private CardDatabaseRepository(Application application){
        CardDatabase database = CardDatabase.getInstance(application);
        cardDao = database.CardDatabaseDAO();
    }

    public static synchronized CardDatabaseRepository getInstance(Application application){
        if(instance == null)
            instance = new CardDatabaseRepository(application);

        return instance;
    }

    public List<CardList> getCardList(){

        new AsyncTask<Void, Void, List<CardList>>(){
            @Override
            protected List<CardList> doInBackground(Void... params) {
                cardList = cardDao.getCardlist();
                return cardList;
            }
        }.execute();
        System.out.println("-----------DONE---------------");
        return cardList;


    }


    public void insert(CardList card) {
        new AsyncTask<CardList, Void, Void>(){
            @Override
            protected Void doInBackground(CardList... params) {
                cardDao.insert(params[0]);
                return null;
            }
        }.execute(card);
        //new InsertCardAsync(cardDao).execute(card);
    }

    public void deleteList(){
        new DeleteListAsync(cardDao).execute();
    }


//    private static class InsertCardAsync extends AsyncTask<CardList,Void,Void> {
//        private CardDatabaseDAO cardDao;
//
//        private InsertCardAsync(CardDatabaseDAO cardDao) {
//            this.cardDao = cardDao;
//        }
//
//        @Override
//        protected Void doInBackground(CardList... cards) {
//            cardDao.insert(cards[0]);
//            return null;
//        }
//    }

    private static class DeleteListAsync extends AsyncTask<Void,Void,Void> {
        private CardDatabaseDAO cardDao;

        private DeleteListAsync(CardDatabaseDAO cardDao) {
            this.cardDao = cardDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            cardDao.deleteList();
            return null;
        }
    }
}