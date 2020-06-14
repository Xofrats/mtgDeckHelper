package com.example.mtgDeckHelper.database;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mtgDeckHelper.apiRelated.Card;

import java.util.List;

public class CardDatabaseViewModel extends AndroidViewModel {

    private CardDatabaseRepository repository;

    public CardDatabaseViewModel(Application app) {
        super(app);
        repository = CardDatabaseRepository.getInstance(app);
    }

    public List<CardList> getCardList() {
        return repository.getCardList();
    }

    public void insert(CardList card) {
        repository.insert(card);
    }

//    public void deleteAllNotes() {
//        repository.deleteAllNotes();
//    }
}
